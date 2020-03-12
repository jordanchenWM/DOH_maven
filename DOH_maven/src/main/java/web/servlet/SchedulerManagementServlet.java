package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;

import com.google.common.base.Throwables;

import internal.db.dao.frame.ITask;
import internal.schedule.ScheduleManager;
import internal.server.util.DefaultValues;
import web.db.ScheduleDB;

@SuppressWarnings("deprecation")
@WebServlet("/SchedulerManagementServlet")
public class SchedulerManagementServlet extends HttpServlet{

	private Logger logger = LogManager.getLogger(DefaultValues.apLog);
	
	private static final long serialVersionUID = 1L;
	ScheduleDB scheduleDB = new ScheduleDB();	
	
	public SchedulerManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String method = getParameter(request, "method");
		switch(method){
			case "ScheduleTable":
				getScheduleTable(request, response);
				break;
			case "delete":
				delete_task(request, response);
				break;
			case "Schedule_Add":
				add_task(request, response);
				break;
			case "suspended":
				update_state(request, response, "0");				
				break;
			case "active":
				update_state(request, response, "1");
				break;
			case "Schedule_edit":
				edit_task(request, response);
				break;
		}
	}
	
	protected void getScheduleTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
				
		try {
			JSONArray jsonArray = scheduleDB.getScheduleTable();

			response.setContentType("text/json");	
			out.println(jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void delete_task(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");	
		
		PrintWriter out = response.getWriter();
		
		try {
			String UUID = getParameter(request, "UUID");
			scheduleDB.delete(UUID);
			
			getScheduleTable(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void add_task(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");	
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		try {
			String id = UUID.randomUUID().toString();
			String description = getParameter(request, "Description");
			String service = getParameter(request, "Service");
			String startTime = getParameter(request, "StartTime");
			String endTime = getParameter(request, "EndTime");
			if (endTime.isEmpty()) {
				endTime = null;
			}
			String mode = getParameter(request, "Mode");
			String interval = "0";
			String hourMask = "0";
			String minuteMask = "0";
			String nextRun = null;
			String task_Name = getParameter(request, "Task_Name");
			
			if (mode.equals("Interval")) {
				interval = getParameter(request, "Interval");
			} else {
				hourMask = getParameter(request, "HourMask");
				minuteMask = getParameter(request, "MinuteMask");
			}
			
			scheduleDB.insertOne(id, description, service, startTime, endTime, interval, hourMask,minuteMask, nextRun, task_Name);

			response.setContentType("text/json");
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void update_state(HttpServletRequest request, HttpServletResponse response, String state) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			String UUID = getParameter(request, "UUID");
			
			/*
			Map<String, String> dataMap = new HashMap<>();
			dataMap.put(IS_USER_TASKS.STATE, state);
			boolean status = scheduleDB.update(UUID, dataMap);
			*/
			if (state.equals("0")) {
				ScheduleManager.stop(UUID);
			} else {
				ScheduleManager.start(UUID);
			}
			
			getScheduleTable(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void edit_task(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");	
		
		PrintWriter out = response.getWriter();
		//JSONArray jsonArray = new JSONArray();
		ScheduleDB scheduleDB = new ScheduleDB();
		
		try {
			String id = getParameter(request, "UUID");
			String description = getParameter(request, "Description");
			String service = getParameter(request, "Service");
			String startTime = getParameter(request, "StartTime");
			String endTime = getParameter(request, "EndTime");
			if (endTime.isEmpty()) {
				endTime = null;
			}
			String mode = getParameter(request, "Mode");
			String interval = "0";
			String hourMask = "0";
			String minuteMask = "0";
			String nextRun = null;
			String task_Name = getParameter(request, "Task_Name");
			
			if (mode.equals("Interval")) {
				interval = getParameter(request, "Interval");
			} else {
				hourMask = getParameter(request, "HourMask");
				minuteMask = getParameter(request, "MinuteMask");
			}
			
			Map<String, String> dataMap = new HashMap<>();
			dataMap.put(ITask.DESCRIPTION, description);
			dataMap.put(ITask.SERVICE, service);
			dataMap.put(ITask.STARTTIME, startTime);
			dataMap.put(ITask.ENDTIME, endTime);
			dataMap.put(ITask.TIMEINTERVAL, interval);
			dataMap.put(ITask.HOURMASK, hourMask);
			dataMap.put(ITask.MINUTEMASK, minuteMask);
			dataMap.put(ITask.NEXTRUN, nextRun);
			dataMap.put(ITask.TASK_NAME, task_Name);
			
			scheduleDB.update(id, dataMap);
			
			//boolean status = scheduleDB.update_state_task(state, UUID);			
			//boolean status = scheduleDB.edit_task(ID, Description, Service, StartTime, EndTime, Interval, HourMask, MinuteMask, nextRun, task_Name);

			//response.setContentType("text/json");
			//out.println(jsonArray);
			
		} catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	private String getParameter(HttpServletRequest request, String input) {
		
		String output = request.getParameter(input);;
		if (output == null) {
			output = "";
		} 
			
		return output;
	}
	
	
}