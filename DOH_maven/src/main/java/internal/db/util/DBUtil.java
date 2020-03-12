package internal.db.util;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Throwables;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import internal.server.util.DefaultValues;

public class DBUtil {
	
	static Logger logger = LogManager.getLogger(DefaultValues.serverLog);
	static DataSource dataSource = null;
  
	 
	private static void init() {	  
		
		try { 	
			//System.out.println("new system HikariConfig");	
			logger.info("Initializing system datasource...");
			
			String configPath = DBUtil.class.getClassLoader().getResource("hikari.properties").toURI().getPath();
			logger.debug("Database config file path: " + configPath);
			
			HikariConfig config = new HikariConfig(configPath);
			dataSource = new HikariDataSource(config);
			
			logger.info("System datasource is initialized.");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Throwables.getStackTraceAsString(e));
					
			logger.info("Can't get system db connection, wait 15s to retry");
			try {
				Thread.sleep(15*1000);
				init();
			} catch (InterruptedException e1) {
				e.printStackTrace();
			}
			
		}		   
	}
   
  /**
   * 获取数据库连接
   * @return 数据库连接
 * @throws SQLException 
   */
  
  public static final Connection getConnection() throws SQLException {
	  
    Connection conn = null;
    if (dataSource == null) {
    	init();
    }
    conn = dataSource.getConnection();
    
    return conn;
  }
  
  
  public static void destroy() throws SQLException {
	  dataSource.unwrap(HikariDataSource.class).close();
  }
 
  /**
  * 关闭连接
  * 
  * @param conn
  *			需要關閉的連接
 * @throws SQLException 
  */
  public static void closeConnection(Connection conn) {
    try {
		if (conn != null && !conn.isClosed()) {
		    conn.close();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		logger.error(Throwables.getStackTraceAsString(e));
	}
  }
}
