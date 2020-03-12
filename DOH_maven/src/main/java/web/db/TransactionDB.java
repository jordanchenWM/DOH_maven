package web.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;

import internal.db.util.DBUtil;
import internal.server.util.DefaultValues;
import web.util.DBOperation;

@SuppressWarnings("deprecation")
public class TransactionDB {
	
	private Logger logger = LogManager.getLogger(DefaultValues.apLog);
	
	public JSONArray getBizDocTable(String start_date, String end_date) throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null;
		String sql = " Select DATE_FORMAT(DocTimestamp, '%m.%d.%Y %T') as DocTimestamp, " +
				     " DocTypeID, RoutingStatus, UserStatus, DocID, SenderID, ReceiverID, ConversationID, NativeID, " +
					 " df.TypeName as DocTypeName," +
					 " p1.CorporationName as SenderName, " +
				  	 " p1.Deleted as SenderDeleted, " +
					 " p2.CorporationName as ReceiverName, " +
				  	 " p2.Deleted as ReceiverDeleted " +
				  	 " From BizDoc d " +
					 " Left Join BizDocTypeDef df on df.TypeID = d.DocTypeID " +
					 " Left Join Partner p1 On p1.PartnerID = d.SenderID " +
					 " Left Join Partner p2 On p2.PartnerID = d.ReceiverID " +
					 " Where 1=1 " ;
		
		if (!start_date.equals("")) {
			sql = sql + " AND DocTimestamp >= " + "'" + start_date + "' " ;
		}
		
		if (!end_date.equals("")) {
			sql = sql + " AND DocTimestamp <= "+ "'" + end_date + "' " ;
		}
		
		sql = sql + " Order By DocTimestamp Desc " +
				    " Limit 1000 ";
		
		try {
			conn = DBUtil.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			
			logger.trace(ps);
			jsonarray = DBOperation.extractSqlResult(rs);
		
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return jsonarray;
	}
	
	
	public JSONArray getActivityTable(String DocID, String DocTypeID) throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null;
		String sql = " Select EntryType, DATE_FORMAT(EntryTimestamp, '%Y-%m-%d %T') as EntryTimestamp, BriefMessage, EntryClass, B2BUser, RelatedPartnerID, ActivityLogID " +
					 " From ActivityLog " + 
					 " Where 1=1 AND RelatedDocID = ? ";
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, DocID);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("TransactionDB.getActivityTable: "+ ps);
			jsonarray = DBOperation.extractSqlResult(rs);
			
		}finally {
			closeConnection(conn);
		}
		return jsonarray;
	}

	
	public JSONArray getBizDocContentTable(String DocID) throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null;
		String sql = " Select PartName, ContentLength, MimeType, DocID " +
					 " From BizDocContent " +
					 " Where 1=1 AND DocID = ? " ;
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, DocID);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("TransactionDB.getBizDocContentTable: "+ ps);
			jsonarray = DBOperation.extractSqlResult(rs);
			
		}finally {
			closeConnection(conn);
		}
		return jsonarray;
	}
	
	
	public JSONArray getActivityFullMessageTable(String ActivityLogID) throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null;
		String sql = " Select FullMessage " +
					 " From ActivityLog " +
					 " Where 1=1 AND  ActivityLogID = ? " ;
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, ActivityLogID);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("TransactionDB.getActivityFullMessageTable: "+ ps);
			jsonarray = DBOperation.extractSqlResult(rs);
		}finally {
			closeConnection(conn);
		}
		return jsonarray;
	}
	
	
	public JSONArray getContentTable(String DocID, String PartName) throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null;
		String sql = " Select Content " +
					 " From BizDocContent " +
					 " Where 1=1 AND  DocID = ? AND PartName = ? ";
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, DocID);
			ps.setString(2, PartName);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("TransactionDB.getContentTable: "+ ps);
			jsonarray = DBOperation.extractSqlResult(rs);
		}finally {
			closeConnection(conn);
		}
		return jsonarray;
	}
	
	
	public Connection purge(String start_day, int size, Connection conn) throws Exception {
		
		String sql_BZ = " Delete from BizDoc " +
						" Where (DocTimestamp) < SUBDATE(now(), INTERVAL ? day) " +
						" Limit ? ";		
		
		try {
			conn = initConnection(conn);
			conn.setAutoCommit(false);
			
			PreparedStatement ps = conn.prepareStatement(sql_BZ.toString());
			ps.setInt(1, Integer.parseInt(start_day));
			ps.setInt(2, size);
			
			System.out.println(ps);
			ps.executeUpdate();
			conn.commit();
			
		}finally {
			closeConnection(conn);
		}
		return conn;
		
	}

	public int purge_order(String start_day) throws Exception {
		
		int order = 0;
		Connection conn = null;
		String sql = " Select Count(DocID) as DocNum " +
					 " From BizDoc " +
					 " Where (DocTimestamp) < SUBDATE(now(), INTERVAL ? day) ";

		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, Integer.parseInt(start_day));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				order = rs.getInt("DocNum");
			}
			
		}finally {
			closeConnection(conn);
		}
		return order;
	}
	
	protected Connection initConnection(Connection conn) throws SQLException {		
		
		if (conn == null || conn.isClosed()) {
			try {
				conn = DBUtil.getConnection() ;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;		
	}
	
	protected void closeConnection(Connection conn) {

		try {
			if (conn != null && conn.getAutoCommit()) {
				DBUtil.closeConnection(conn);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
