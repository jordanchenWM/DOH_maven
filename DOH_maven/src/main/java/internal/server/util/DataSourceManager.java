package internal.server.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Throwables;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import internal.db.dao.frame.IDB_Info;
import internal.db.util.DBInjector;

public class DataSourceManager {
		
	private static IDB_Info db_info = DBInjector.getInstance(IDB_Info.class);
	private static Logger logger = LogManager.getLogger(DefaultValues.serverLog);  
	
	private static Map<String, DataSource> srcMap = new HashMap<>();
	private static Map<String, Map<String, String>> jdbcMap = new HashMap<>();
	
	
	private DataSourceManager() {
	  super();
	}
	
	
	public static void main(String[] args) throws Exception {
		
		DataSourceManager.getConnection("123");
		/*
		IDB_Info db_info = DBInjector.getInstance(IDB_Info.class);
		
		List<Map<String, String>> list = db_info.getEnableList();
		
		for (Map<String, String> map : list) {
			String alias = map.get(IDB_Info.Alias_Name);
			try {				
				DataSourceManager.enable(alias, map);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("DB Alias" + alias + ": " + e.getClass().getName() + " - " +  e.getMessage());
			}
		}
		
		System.out.println(jdbcMap);
		System.out.println(srcMap);
		*/
	}
	
	//enable datasource
	public static synchronized void enable(String alias) throws Exception {
		
		if (srcMap.get(alias) != null || jdbcMap.get(alias) != null) {
			logger.warn("Datasource: " + alias + " is already enabled;");
		} else {
			Map<String, String> map = db_info.selectOne(alias);
			enable(alias, map);
		}
	}
	
	public static synchronized void enable(String alias, Map<String, String> map) throws Exception  {
		
		try  {
			logger.info("Initializing datasource: " + alias + "...");
			
			if (map != null && !map.isEmpty()) {
				
				String isPoolEnable = map.get(IDB_Info.isPoolEnable);
				if (isPoolEnable == null || isPoolEnable.equals("0")) {
					//Test connection
					
					logger.info("Connection pool is not enabled, use direct jdbc connection.");		
					logger.info("Connecting...");
										
					Connection conn = getJdbcConnection(map);
					if (conn != null) {
						conn.close();
					}
					jdbcMap.put(alias, map);
				} else {
					//create Hikari connection pool
					HikariConfig config = getHikariConfig(map);
			  		DataSource dataSource = new HikariDataSource(config);
			  		srcMap.put(alias, dataSource);
				}
				
			} else {
				throw new Exception("Alias info does not exist in database");
			}
			
			logger.info("Datasource: " + alias + " is enabled.");
		} catch  (Exception e) {
			e.printStackTrace();
			logger.error("Unable to start DB alias: " + alias + " - " + Throwables.getStackTraceAsString(e));
			throw e;
		}			
	}
	
	//disable datasource
	public static synchronized void disable(String alias) throws Exception {
		
		try {
			logger.info("Stopping datasource: " + alias + "...");
			
			DataSource dataSource = srcMap.get(alias);
			if (dataSource != null) {
				dataSource.unwrap(HikariDataSource.class).close();
				srcMap.remove(alias);
			} else {
				jdbcMap.remove(alias);
			}
			
			logger.info("Datasource: " + alias + " is disabled.");
		} catch  (Exception e) {
			e.printStackTrace();
			logger.error("Unable to stop DB alias: " + alias + " - " + Throwables.getStackTraceAsString(e));
			throw e;
		}
		
	}
	
	//enable datasource by provided map 
	private static HikariConfig getHikariConfig(Map<String, String> map) {
		
		HikariConfig config = new HikariConfig(); 
		
		config.setDriverClassName(map.get(IDB_Info.DataSource_class));	  		
	  	config.setJdbcUrl(map.get(IDB_Info.URL));			
		
	  	
  		config.setUsername(map.get(IDB_Info.Account));
  		config.setPassword(map.get(IDB_Info.Password));
  		  		
  		config.setMinimumIdle(Integer.valueOf(map.get(IDB_Info.MinPoolSize)));
  		config.setMaximumPoolSize(Integer.valueOf(map.get(IDB_Info.MaxPoolSize)));    
  		
  		//wait for a connection from the pool.
  		config.setConnectionTimeout(Long.valueOf(map.get(IDB_Info.Block_Timeout)));
  		
  		//connection is allowed to sit idle in the pool.
  		//applies when minimumIdle is defined to be less than maximumPoolSize
  		config.setIdleTimeout(Long.valueOf(map.get(IDB_Info.Expire_Timeout)));
  		
  		// maximum lifetime of a connection in the pool - default 30min
  		config.setMaxLifetime(90000);
  		
  		return config;				
	}	
	
	public static Connection getConnection(String alias) throws Exception {
		
		logger.debug("pool: " + srcMap.keySet());
		logger.debug("jdbc: " + jdbcMap.keySet());
		
		DataSource dataSource = srcMap.get(alias);
		if (dataSource != null) {
			return dataSource.getConnection();
		} else {			
			return getJdbcConnection(alias);
		}
		
	}
	
	private static Connection getJdbcConnection(Map<String, String> map) throws Exception {
		String url = map.get(IDB_Info.URL);
		String account = map.get(IDB_Info.Account);
		String password = map.get(IDB_Info.Password);
		String dataSource_class = map.get(IDB_Info.DataSource_class);
		
		Class.forName(dataSource_class);
		return DriverManager.getConnection(url, account, password);
	}
	
	private static Connection getJdbcConnection(String alias) throws Exception {
		
		Map<String, String> map = jdbcMap.get(alias);
		if (map == null) {
			logger.warn("Cannot get jdbc info for " + alias + ", check db status...");
			map = db_info.selectOne(alias);
		}
		
		if (map != null && !map.isEmpty()) {
			String disabled = map.get(IDB_Info.Disabled);
			if (disabled != null && disabled.equals("0")) {
				return getJdbcConnection(map);
			} else {
				throw new Exception( alias + " is disabled.");
			}
		} else {
			throw new Exception( alias + " not found.");
		}
		
	}
}
