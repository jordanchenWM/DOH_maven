package internal.server.servlet;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Throwables;

import internal.db.dao.frame.IDB_Info;
import internal.db.dao.frame.ITask;
import internal.db.util.DBInjector;
import internal.schedule.ScheduleManager;
import internal.server.util.DataSourceManager;
import internal.server.util.DefaultValues;
import internal.server.util.License;
import internal.server.util.LicenseHelper;
import web.db.AliasDB;

@WebListener
public class MyServletContextListener implements ServletContextListener {

	public static boolean isLicensed = false;
	private Logger logger = LogManager.getLogger(DefaultValues.serverLog);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed");	
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
				
		try {
			String lcPath = MyServletContextListener.class.getClassLoader().getResource("test.lc").toURI().getPath();
			String crtPath = MyServletContextListener.class.getClassLoader().getResource("SAI_DEV.crt").toURI().getPath();
			String lcContent = Files.readString(Paths.get(lcPath));
			
			logger.debug("License file: " + lcPath);
			
			License license = LicenseHelper.decode(lcContent, crtPath);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initDataSources();
		initSchedule();		
		
		//CheckLicense.check();
	}

	
	public void initDataSources() {
			
		logger.info("Initializing datasources...");
		
		IDB_Info db_info = DBInjector.getInstance(IDB_Info.class);
		
		List<Map<String, String>> list = db_info.getEnableList();
		
		for (Map<String, String> map : list) {
			String alias = map.get(IDB_Info.Alias_Name);
			try {				
				DataSourceManager.enable(alias, map);
			} catch (Exception e) {		
				e.printStackTrace();
				logger.error(Throwables.getStackTraceAsString(e));
				
				//disable alias 
				try {
					DataSourceManager.disable(alias);
					AliasDB aliasDB = new AliasDB();
					aliasDB.enabled_change(alias, "1");
				} catch (Exception e1) {
					e.printStackTrace();
					logger.error(Throwables.getStackTraceAsString(e));
				}
				
			}
		}
		
		logger.info("Initializing datasources complete.");
		
	}
	
	public void initSchedule() {
		
		logger.info("Initializing schedule...");
		
		ITask task = DBInjector.getInstance(ITask.class);
				
		List<Map<String, String>> list = task.getEnableList();
		
		for (Map<String, String> map : list) {
			String id = map.get(ITask.TASK_ID);
			try {
				ScheduleManager.start(id);
			} catch (Exception e) {			
				e.printStackTrace();
				logger.error(Throwables.getStackTraceAsString(e));
			}			
		}
		
		logger.info("Initializing schedule complete.");
	}
	 

}
