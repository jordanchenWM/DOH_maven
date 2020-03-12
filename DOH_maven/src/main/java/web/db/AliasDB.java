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
public class AliasDB {
	
	private Logger logger = LogManager.getLogger(DefaultValues.apLog);
	
	public AliasDB() {
		super();
	} 
	
	public static void main(String[] args) throws Exception {
		
	}
	
	public JSONArray getAliasTable() throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null;
		String sql = " Select Alias_Name, Alias_Description, URL, Account, Password, Driver, " + 
				 	 " DataSource_class, Pooling_Enable, MaxPoolSize, MinPoolSize, " +
				 	 " Block_Timeout, Expire_Timeout, Startup_Timeout, Disabled " + 
					 " From DB_Info "  ;
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			
			logger.trace(ps);
			ResultSet rs = ps.executeQuery();
			
			jsonarray = DBOperation.extractSqlResult(rs);
		} finally {
			closeConnection(conn);
		}
		
		return jsonarray;
	}
	
	public void delete_alia(String alias_Name) throws Exception {
		
		Connection conn = null;
		String sql = " delete From DB_Info " +
				 	 " Where Alias_Name = ? " ;
	
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, alias_Name);
			
			logger.trace(ps);
			ps.executeUpdate();
			
		} finally {
			closeConnection(conn);
		}
	}
	
	public void add_alia(String alias_Name, String alias_Description, String account, String password, 
			String dataSource_class, String driver, String uRL, String pooling_Enable, String maxPoolSize, 
			String minPoolSize, String block_Timeout, String expire_Timeout, String startup_Timeout) throws Exception {
		
		Connection conn = null;
		String sql = " Insert Into DB_Info " +
				 	 " Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " ;
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, alias_Name);
			ps.setString(2, alias_Description);
			ps.setString(3, uRL);
			ps.setString(4, account);
			ps.setString(5, password);
			ps.setString(6, driver);
			ps.setString(7, dataSource_class);
			ps.setInt(8, Integer.parseInt(pooling_Enable));
			ps.setInt(9, Integer.parseInt(maxPoolSize));
			ps.setInt(10, Integer.parseInt(minPoolSize));
			ps.setInt(11, Integer.parseInt(block_Timeout));
			ps.setInt(12, Integer.parseInt(expire_Timeout));
			ps.setInt(13, Integer.parseInt(startup_Timeout));
			ps.setBoolean(14, true);
			
			System.out.println("AliasDB.add_alia: "+ ps);
			ps.executeUpdate();
			
		}finally {
			closeConnection(conn);
		}
	}
	
	public void edit_alia(String alias_Name, String alias_Description, String account, String password, 
			String dataSource_class, String driver, String uRL, String pooling_Enable, String maxPoolSize, 
			String minPoolSize, String Block_Timeout, String expire_Timeout,
			String startup_Timeout, String hideName) throws Exception {
		
		Connection conn = null;
		String sql = " Update DB_Info " +
				 	 " Set Alias_Name = ? ,Alias_Description = ?, URL = ?, Account = ?, Password = ?, " +
				 	 " Driver = ?, DataSource_class = ?, Pooling_Enable = ?, MaxPoolSize = ?, " +
				 	 " MinPoolSize = ?, Block_Timeout = ?, Expire_Timeout = ? , " +
				 	 " Startup_Timeout = ? " +
				 	 " Where Alias_Name = ?" ;
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, alias_Name);
			ps.setString(2, alias_Description);
			ps.setString(3, uRL);
			ps.setString(4, account);
			ps.setString(5, password);
			ps.setString(6, driver);
			ps.setString(7, dataSource_class);
			ps.setInt(8, Integer.parseInt(pooling_Enable));
			ps.setInt(9, Integer.parseInt(maxPoolSize));
			ps.setInt(10, Integer.parseInt(minPoolSize));
			ps.setInt(11, Integer.parseInt(Block_Timeout));
			ps.setInt(12, Integer.parseInt(expire_Timeout));
			ps.setInt(13, Integer.parseInt(startup_Timeout));
			ps.setString(14, hideName);
			
			ps.executeUpdate();
			logger.info("AliasDB.getAliasTable: "+ ps);
			System.out.println("AliasDB.edit_alia: "+ ps.toString());
			
		}finally {
			closeConnection(conn);
		}
	}
	
	public Boolean check_alia(String alias_Name) throws Exception {
		
		Boolean isDuplicate = null;
		Connection conn = null;
		String sql = " Select * " +
					 " From DB_Info " +
				 	 " Where Alias_Name = ? " ;
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, alias_Name);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString("Alias_Name") != null) {
					isDuplicate = true;
				}
			}else
				isDuplicate = false;
			
		}finally {
			closeConnection(conn);
		}
		
		return isDuplicate;
	}
	
	public String enabled_change(String alias_Name, String useUpdate) throws Exception {
		
		Connection conn = null;
		String sql = " Update DB_Info " +
				 	 " Set Disabled = ? " +
				 	 " Where Alias_Name = ?" ;
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, useUpdate);
			ps.setString(2, alias_Name);
			
			System.out.println("AliasDB.enabled_change : "+ ps);
			ps.executeUpdate();
			
		}finally {
			closeConnection(conn);
		}
		return "success";
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
