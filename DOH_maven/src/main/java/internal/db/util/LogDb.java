package internal.db.util;

import internal.db.dao.frame.IActivityLog;

public class LogDb {

	private static IActivityLog activityLog = DBInjector.getInstance(IActivityLog.class);
			
	private LogDb() {
		super();
	}	
	
	 public static void logInfo(String log_type, String docID, String msg, String fullMsg) {
		 activityLog.insert(IActivityLog.info, log_type, docID, msg, fullMsg);
	 }
	 
	 public static void logWarn(String log_type, String docID, String msg, String fullMsg) {
		 activityLog.insert(IActivityLog.warn, log_type, docID, msg, fullMsg);
	 }
	 
	 public static void logError(String log_type, String docID, String msg, String fullMsg) {
		 activityLog.insert(IActivityLog.error, log_type, docID, msg, fullMsg);
	 }
}
