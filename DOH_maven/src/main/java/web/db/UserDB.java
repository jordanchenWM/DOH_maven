package web.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;

import internal.db.util.DBUtil;
import internal.server.util.DefaultValues;
import web.util.DBOperation;
import web.util.Vars;

@SuppressWarnings("deprecation")
public class UserDB {

	private Logger logger = LogManager.getLogger(DefaultValues.apLog);
	
	public Map<String, String> loginSQL(String Account, String Password) throws Exception {
		
		Map<String, String> userInfoMap = new HashMap<>();
		Connection conn = null;
		String sql= " SELECT Account, Password, Phone, Mail, Role, frist_name, last_name " +
					" FROM User " +
					" WHERE Account = ? AND Password = md5(?) ";
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Account);
			ps.setString(2, Password);
			ResultSet rs = ps.executeQuery();
			logger.trace(ps);
			
			if (rs.next()) {
				userInfoMap.put(Vars.Account, rs.getString("Account"));
				userInfoMap.put(Vars.Mail, rs.getString("Mail"));
				userInfoMap.put(Vars.Role, rs.getString("Role"));
				userInfoMap.put(Vars.frist_name, rs.getString("frist_name"));
				userInfoMap.put(Vars.last_name, rs.getString("last_name"));
			}
		} finally {
			closeConnection(conn);
		}
		
		return userInfoMap;
	}
	
	public JSONArray getUserTable() throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null;
		String sql = " Select Account, Password, Phone, Mail, Role, frist_name, last_name " +
				 	 " From User " + 
				 	 " Where 1=1 ";
	
		try {
			conn = initConnection(conn);
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println("UserDB.getUserTable: "+ ps);
			ResultSet rs = ps.executeQuery();
			
			jsonarray = DBOperation.extractSqlResult(rs);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}finally {
			DBUtil.closeConnection(conn);
		}
		return jsonarray;
	}
	
	public boolean add_user(String account, String password, String frist_Name, String last_Name, String mail, String role, String Phone) throws Exception {
		
		Boolean status = true;
		Connection conn = null;
		String sql = " Insert Into User " +
				 	 " Values (?, ?, ?, ?, ?, ?, ?) " ;
	
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);
			ps.setString(3, mail);
			ps.setString(4, role);
			ps.setString(5, frist_Name);
			ps.setString(6, last_Name);
			ps.setString(7, Phone);
			
			System.out.println("UserDB.add_user: "+ ps);
			ps.executeUpdate();
			
		}catch(Exception e) {
			status = false;
			e.printStackTrace();
			logger.error(e.getMessage());
		}finally {
			closeConnection(conn);
		}
		return status;
	}
	
	public Boolean user_delete(String account) throws Exception {
		
		boolean status = true;
		Connection conn = null;
		String sql = " Delete From User " +
				 	 " Where 1=1 AND Account = ? " ;
	
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			
			System.out.println("UserDB.add_user: "+ ps);
			ps.executeUpdate();
			
		}catch(Exception e) {
			status = false;
			e.printStackTrace();
			logger.error(e.getMessage());
		}finally {
			closeConnection(conn);
		}
		return status;
	}
	
	public boolean user_Edit(String account, String password, String frist_Name, String last_Name, String mail, String role, String Phone) throws Exception {
		
		Boolean status = true;
		Connection conn = null;
		String sql = " Update User " +
					 " Set Password = ?, Mail = ?, frist_name = ?, last_name = ?, Phone = ?, Role = ? " +
					 " Where Account = ? ";
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, mail);
			ps.setString(3, frist_Name);
			ps.setString(4, last_Name);
			ps.setString(5, Phone);
			ps.setString(6, role);
			ps.setString(7, account);
			
			System.out.println("UserDB.user_Edit: "+ ps);
			ps.executeUpdate();
			
		}catch(Exception e) {
			status = false;
			e.printStackTrace();
			logger.error(e.getMessage());
		}finally {
			closeConnection(conn);
		}
		return status;
	}
	
	public Boolean check_user(String user_Name) throws Exception {
		
		Boolean isDuplicate = null;
		Connection conn = null;
		String sql = " Select * " +
					 " From User " +
				 	 " Where Account = ? " ;
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user_Name);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString("Account") != null) {
					isDuplicate = true;
				}
			}else
				isDuplicate = false;
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}finally {
			closeConnection(conn);
		}
		return isDuplicate;
	}
	
	protected Connection initConnection(Connection conn) throws SQLException {		
		
		if (conn == null || conn.isClosed()) {
			try {
				conn = DBUtil.getConnection() ;
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e.getStackTrace());
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
			logger.error(e.getMessage());
		}
	}
}
