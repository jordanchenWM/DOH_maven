package web.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;

import internal.db.util.DBUtil;
import web.util.DBOperation;

@SuppressWarnings("deprecation")
public class ProcessingDB {
	
	public JSONArray getProcessingRuleTable() throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null;
		String sql = " Select RuleID, RuleIndex, RuleDescription, RuleName, SenderID, ReceiverID, DocTypeID, Service, " +
				 	 " DATE_FORMAT(LastModified, '%Y-%m-%d %T') as LastModified, Disabled, " +
					 " (Select TypeName from BizDocTypeDef where TypeID = ProcessingRule.DocTypeID) as DocTypeName," +
				 	 " (Select CorporationName from Partner where PartnerID = ProcessingRule.SenderID) as SenderName," +
				 	 " (Select CorporationName from Partner where PartnerID = ProcessingRule.ReceiverID) as ReceiverName " +
				 	 " From ProcessingRule "  ;
					 
		try {
			conn = initConnection(conn);
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			
			System.out.println("ProcessingDB.getProcessingRuleTable: "+ ps);
			ResultSet rs = ps.executeQuery();
			
			jsonarray = DBOperation.extractSqlResult(rs);
		}finally {
			closeConnection(conn);
		}
		return jsonarray;
	}
	
	public void delete_rule(String RuleID) throws Exception {
		
		Connection conn = null;
		String sql = " Delete FROM ProcessingRule " +
					 " where RuleID = ? " ;
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, RuleID);
			
			System.out.println("ProcessingDB.delete_rule: "+ ps);
			ps.executeUpdate();
			
		}finally {
			closeConnection(conn);
		}
	}
	
	public void add_rule(String RuleID, String ruleName, String ruleDescription, String senderID, String receiveID, 
			String docTypeID, String service, String rule_Enable, int ruleIndex) throws Exception {
			 
		Connection conn = null;
		String sql = " Insert Into ProcessingRule " +
					 " Values(?, ?, ?, ?, ?, ?, ?, ?, now(), ?) " ;
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, RuleID);
			ps.setInt(2, ruleIndex);
			ps.setString(3, ruleDescription);
			ps.setString(4, ruleName);
			ps.setString(5, senderID);
			ps.setString(6, receiveID);
			ps.setString(7, docTypeID);
			ps.setString(8, service);
			ps.setString(9, rule_Enable);
			
			System.out.println("ProcessingDB.add_rule: "+ ps);
			ps.executeUpdate();
			
		}finally {
			closeConnection(conn);
		}
	}
	
	public void edit_rule(String RuleID, String ruleName, String ruleDescription, String senderID, String receiveID, 
			String docTypeID, String service, String rule_Enable, String ruleIndex) throws Exception {
		
		Connection conn = null;
		String sql = " Update ProcessingRule " +
					 " Set RuleDescription = ?, RuleName = ?, SenderID = ?, ReceiverID = ?, DocTypeID = ?, " +
					 " Service = ?, LastModified = now(), Disabled = ? , RuleIndex = ? " +
					 " Where RuleID = ? " ;
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, ruleDescription);
			ps.setString(2, ruleName);
			ps.setString(3, senderID);
			ps.setString(4, receiveID);
			ps.setString(5, docTypeID);
			ps.setString(6, service);
			ps.setString(7, rule_Enable);
			ps.setInt(8, Integer.parseInt(ruleIndex));
			ps.setString(9, RuleID);
			
			System.out.println("ProcessingDB.edit_rule: "+ ps);
			ps.executeUpdate();
			
		}finally {
			closeConnection(conn);
		}
	}
	
	public void index_order(String newIndex, String oldIndex) throws Exception {
		
		Connection conn = null;
		String sql = "update ProcessingRule set RuleIndex = ? where RuleIndex = ? " ; 
		// 2->4 => 3->2 4->3  | 4->2 => 3->4 2->3 
		try {
			conn = initConnection(conn);
			conn.setAutoCommit(false);
			
			int newI = Integer.parseInt(newIndex);
			int oldI = Integer.parseInt(oldIndex);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			if(newI > oldI) {
				for(int i=oldI+1;i<newI+1;i++) {
					ps.setInt(1, i-1);
					ps.setInt(2, i);
					ps.addBatch();
				} 
			}else {
				for(int i=oldI-1;i>newI-1;i--) {
					ps.setInt(1, i+1);
					ps.setInt(2, i);
					ps.addBatch();
				
				} 
			}
			ps.executeBatch();
			conn.commit();
		}catch(Exception e) {
			conn.rollback();
			throw e;
		}finally {
			closeConnection(conn);
		}
	}
	
	public Integer newIndex() throws Exception {
		
		int Index = 0 ;
		Connection conn = null;
		String sql = "Select Max(RuleIndex) as RuleIndex from ProcessingRule" ; 
		
		try {
			conn = initConnection(conn);
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Index = rs.getInt("RuleIndex");
			}
			
		}finally {
			closeConnection(conn);
		}
		return Index;
	}
	
	protected Connection initConnection(Connection conn) throws SQLException {		
		
		if (conn == null || conn.isClosed()) {
			try {
				conn = DBUtil.getConnection();
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