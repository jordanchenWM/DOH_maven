package internal.schedule;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Throwables;

import internal.db.dao.frame.ITask;
import internal.db.util.DBInjector;
import internal.server.util.DefaultValues;

public class ScheduleManager {

	private static Logger logger = LogManager.getLogger(DefaultValues.serverLog);
	private static Map<String, ScheduledExecutorService> serviceMap = new HashMap<>();
	private static ITask task = null;
	
	static {
		task = DBInjector.getInstance(ITask.class);
	}
	
	private ScheduleManager() {
		super();
	}
	
	public static void main(String[] args) throws Exception  {
		ScheduleManager.start("0a527564-4bfa-4dca-8a5f-ef01207aedee");
	}
	/*
	private static void update(String id, String state, String nextRun) throws Exception {		
		Map<String, String> updateMap = new HashMap<>();
		updateMap.put(ITask.STATE, state);
		updateMap.put(ITask.NEXTRUN, nextRun);
		task.update(id, updateMap);		
	}
	*/
	
	public synchronized static void stop(String id) throws Exception {
				
		try {
			logger.info("Stopping schedule: " + id + "...");
			
			ScheduledExecutorService service = serviceMap.get(id);
			if (service != null) {
				service.shutdown();
				serviceMap.remove(id);
			} else {
				logger.warn("Schedule: " + id + " is not running.");
			}		
			
			try {			
				Map<String, String> updateMap = new HashMap<>();
				updateMap.put(ITask.STATE, "0");
				updateMap.put(ITask.NEXTRUN, null);
				task.update(id, updateMap);		
			} catch (Exception e) {
				logger.error("Schedule: " + id + " update failed.");
				logger.error(Throwables.getStackTraceAsString(e));
			}
			
			logger.info("Schedule: " + id + " is stopped");
			
		} catch (Exception e) {
			logger.error("Stop schedule" + id + " failed." );
			throw e;
		}
		
	}
	
	public synchronized static void start(String id) throws Exception {
		
		String task_name = "";
		
		try {
			//check service status
			ScheduledExecutorService service = serviceMap.get(id);
			if (service != null && !service.isShutdown()) {
				logger.warn("Schedule: " + id + " is running.");
				return;
			}
			
			//get schedule config
			Map<String, String> dataMap = task.selectOne(id);
			if (dataMap == null || dataMap.isEmpty()) {
				logger.error("No schedule found by id = " + id);
			} else {
				
				task_name = dataMap.get(ITask.TASK_NAME);
				logger.info("Starting schedule: " + task_name + "(" + id + ")...");
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							
				String className = dataMap.get(ITask.SERVICE);
				String interval_s = dataMap.get(ITask.TIMEINTERVAL);
				String startTime_s = dataMap.get(ITask.STARTTIME);
				String endTime_s = dataMap.get(ITask.ENDTIME);
				
				//default interval 1 day
				int interval = 24 * 60 * 60; //1 day
				long delay = 0;
				
				Date now = new Date();
				Date startDate = sdf.parse(startTime_s);
				
				//mode = interval
				if (interval_s != null && !interval_s.equals("0")) {
					interval = Integer.valueOf(interval_s);
					if (startDate.after(now))  {
						delay = startDate.getTime() - now.getTime();
					} else {
						delay = 60000 - now.getTime()%60000;						
					}
				} else { //execute every 1 day
					
					//get next execute Date
					Calendar nextDate = Calendar.getInstance();				
					if (startDate.after(now)) {
						nextDate.setTime(startDate);
					} else {
						nextDate.setTime(now);
					}				
					nextDate.set(Calendar.HOUR_OF_DAY, Integer.valueOf(dataMap.get(ITask.HOURMASK)));
					nextDate.set(Calendar.MINUTE, Integer.valueOf(dataMap.get(ITask.MINUTEMASK)));
					nextDate.set(Calendar.SECOND, 0);
					
					if (nextDate.getTime().before(now)) {
						nextDate.add(Calendar.DATE, 1);
					}
					
					delay = nextDate.getTimeInMillis() - now.getTime();				
				}
				
				Schedule schedule = new Schedule(id, endTime_s, interval, className);				
				service = Executors.newSingleThreadScheduledExecutor();		        
				service.scheduleAtFixedRate(schedule, delay/1000, interval, TimeUnit.SECONDS);
				
				serviceMap.put(id, service);
								
				try {
					Map<String, String> updateMap = new HashMap<>();
					updateMap.put(ITask.STATE, Schedule.STATE_START);
					updateMap.put(ITask.NEXTRUN, sdf.format(now.getTime() + delay));
					updateMap.put(ITask.LASTERROR, null);
					task.update(id, updateMap);	
				} catch (Exception e) {
					e.printStackTrace();
					logger.error("Updating schedule: " + task_name + "(" + id + ") failed");
				}
				
				logger.info("Schedule: " + task_name + "(" + id + ") is started");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Starting schedule" + task_name + "(" + id + ") failed." );
			throw e;
		}
	}	
}
