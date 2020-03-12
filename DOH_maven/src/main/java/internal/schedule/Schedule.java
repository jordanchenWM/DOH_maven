package internal.schedule;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Throwables;

import internal.db.dao.frame.ITask;
import internal.db.util.DBInjector;
import internal.server.util.DefaultValues;
import service.IService;



public class Schedule extends TimerTask {

	private String id = "";
	private String endTime_s = null;
	private int interval = 0;
	private String className = "";
	
	private Logger logger = LogManager.getLogger(DefaultValues.serverLog);  
	private ITask task = DBInjector.getInstance(ITask.class);
	
	public static final String STATE_RUNNING = "2";
	public static final String STATE_START = "1";
	public static final String STATE_STOP = "0";
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
    public Schedule(String id, String endTime_s, int interval, String className) {
        this.id = id;
        this.endTime_s = endTime_s;
        this.interval = interval;
        this.className = className;
    }
 
	@Override
    public void run() {
		
		try {
			
			logger.info("Service: " +  id + " start.");
			
			//get next run time
			Calendar calendar = Calendar.getInstance();			
			calendar.add(Calendar.SECOND, interval);			
			Date nextRun = calendar.getTime();			
			
			//stop schedule 
			if (endTime_s != null) {
				Date endTime = format.parse(endTime_s);				
				if (nextRun.after(endTime)) {
					String nextRun_s = format.format(nextRun);
					logger.info("End time: " + endTime_s + ", next run:" + nextRun_s +  " - stop schedule.");
					ScheduleManager.stop(id);
					return;
				}
			}
			
			//update state to running
			try {
				Map<String, String> updateMap = new HashMap<>();
				updateMap.put(ITask.STATE, Schedule.STATE_RUNNING);
				task.update(id, updateMap);
			} catch (Exception e) {				
				logger.error(Throwables.getStackTraceAsString(e));
			}
			
			//run service
			Class<?> clazz;
			try {
				if (className == null) {
					logger.warn("No service defined for schedule: " + id);
				} else {
					clazz = Class.forName(className);
					IService service = (IService) clazz.getDeclaredConstructor().newInstance();
					service.execute(null, null);
				}			
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(Throwables.getStackTraceAsString(e));
				
				//update schedule last error
				try {
					Map<String, String> updateMap = new HashMap<>();
					updateMap.put(ITask.LASTERROR, format.format(new Date()) + " - " + e.getClass().getCanonicalName());
					task.update(id, updateMap);
				} catch (Exception e1) {
					e.printStackTrace();
					logger.error(Throwables.getStackTraceAsString(e));					
				}
			}
			
			try {				
				String nextRun_s = format.format(nextRun);
				logger.debug("NEXTRUN: " + nextRun_s);
				
				Map<String, String> updateMap = new HashMap<>();
				updateMap.put(ITask.STATE, Schedule.STATE_START);
				updateMap.put(ITask.NEXTRUN, nextRun_s);
				task.update(id, updateMap);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(Throwables.getStackTraceAsString(e));
			}
			
		} catch (Exception e) {	
			e.printStackTrace();
			logger.error(Throwables.getStackTraceAsString(e));
		}   
    }

 
	
}
