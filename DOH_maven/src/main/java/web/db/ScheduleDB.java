package web.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.json.simple.JSONArray;

import internal.db.dao.UserTaskDao;
import internal.db.util.DBUtil;
import internal.server.util.DefaultValues;
import web.util.DBOperation;

@SuppressWarnings("deprecation")
public class ScheduleDB extends UserTaskDao {
	
	public ScheduleDB() {
		this.setLogger(LogManager.getLogger(DefaultValues.apLog));
	}
	
	public void insertOne(String ID, String description, String service, String startTime, String endTime,
			String interval, String hourMask, String minuteMask, String nextRun, String task_Name) throws Exception {
		
		Connection conn = null;
		String sql = " Insert Into IS_USER_TASKS " +
				 " Values (?, ?, ?, ?, ?, ?, ?, ?, 0, 'ON' , ? , '', ?) " ;
				
		try {
			conn = DBUtil.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			
			String[] values = {ID, description, service, startTime, endTime, 
					interval, hourMask, minuteMask, nextRun, task_Name};
			
			for (int i=0; i<values.length; i++) {
				ps.setString(i+1, values[i]);
			}

			logger.trace(sql);
			ps.executeUpdate();
			
		}finally {
			DBUtil.closeConnection(conn);
		}
	}
	

	public JSONArray getScheduleTable() throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null;
		String sql = "Select UUID, DESCRIPTION, SERVICE, " +
					 "DATE_FORMAT(STARTTIME, '%Y-%m-%d %H:%i') as STARTTIME, " +
					 "DATE_FORMAT(ENDTIME, '%Y-%m-%d %H:%i') as ENDTIME, " +
					 "DATE_FORMAT(NEXTRUN, '%Y-%m-%d %H:%i:%s') as NEXTRUN, " +
					 "TIMEINTERVAL, HOURMASK, MINUTEMASK, STATE, RUNNINGON, " +
					 "LASTERROR, TASK_NAME " +
				 	 "From IS_USER_TASKS "  ;
		
		try {
			conn = DBUtil.getConnection();
			
			logger.trace(sql);
			PreparedStatement ps = conn.prepareStatement(sql.toString());		
			
			ResultSet rs = ps.executeQuery();
			
			jsonarray = DBOperation.extractSqlResult(rs);
		} finally {
			DBUtil.closeConnection(conn);
		}
		return jsonarray;
	}
	
}
