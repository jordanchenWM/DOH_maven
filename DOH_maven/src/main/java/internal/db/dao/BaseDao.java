package internal.db.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import internal.server.util.DefaultValues;


public class BaseDao {
	
	protected Logger logger = LogManager.getLogger(DefaultValues.serverLog); 
	//protected Connection conn = null;
		
	protected void setLogger(Logger logger) {
		this.logger = logger;
	}
	/*
	protected Connection initConnection() throws SQLException {		
		
//		if (conn == null || conn.isClosed()) {
//			try {
//				conn = DBUtil.getConnection();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}	
			
		return DBUtil.getConnection();
	}
	*/
	
	/*
	protected void closeConnection(Connection conn) {
		try {
			DBUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			if (conn != null && conn.getAutoCommit()) {
//				DBUtil.closeConnection(conn);
//			} 
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
	}
	*/
	/*	
	protected String getSql(PreparedStatement pstmt) {
		
		try {			
			return pstmt.unwrap(ServerPreparedStatement.class).asSql();
		} catch (SQLException e) {
			logger.warn(e.getMessage());
			return pstmt.toString();			
		}
	}
	*/

	
	Map<String, String> getDataMap(ResultSet rs) throws SQLException {
		
		Map<String, String> dataMap = new HashMap<>();
		
		ResultSetMetaData metadata = rs.getMetaData();
				
		for (int i=1; i <= metadata.getColumnCount(); i++) {
			String column = metadata.getColumnLabel(i);						
			dataMap.put(column, rs.getString(column));
		}	
				
		return dataMap;
		
	}
	
}
