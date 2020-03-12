package internal.tn.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import internal.db.dao.frame.IActivityLog;
import internal.db.dao.frame.IBizDoc;
import internal.db.dao.frame.IBizDocContent;
import internal.db.util.DBInjector;
import internal.db.util.LogDb;
import internal.server.util.DefaultValues;

public class TnUtil {

	private static Logger logger = LogManager.getLogger(DefaultValues.serverLog);  
	
	private static IBizDoc bizDocDao = DBInjector.getInstance(IBizDoc.class);
	private static IBizDocContent bizConetentDao =  DBInjector.getInstance(IBizDocContent.class);
	
	public static String persist(String content, String contentType) throws Exception {
		
		String docID = null;
		
		try {		
				       
			logger.info("<--- doc persist");
			
			//insert with unknown doctype/sender/receiver
			docID = bizDocDao.insert(DefaultValues.senderID, DefaultValues.receiverID, DefaultValues.docTypeID);  	        
	        bizConetentDao.insert(docID, "xmldata", content, contentType);
	        	     
	        LogDb.logInfo(IActivityLog.general, docID, "doc persist", "doc persist with id: " + docID);		
			logger.info(">--- doc persist with docID: " + docID);
	        
		} catch (Exception e) {			
			throw e;
		} finally {
			//conn.setAutoCommit(true); //for connection pool
			//DBUtil.closeConnection(conn);			
		}
		
		return docID;
	}
	
	public static void addContent(String docID, String name, String content, String contentType) throws Exception {
		bizConetentDao.insert(docID, name, content, contentType);
	}
	/*
	public static String persist(String content, String contentType) throws Exception {
		
		String docID = null;
		
		//Connection conn = DBUtil.getConnection();
		
		try {		
				        
			//insert with unknown doctype/sender/receiver
			docID = bizDocDao.insert(DefaultValues.senderID, DefaultValues.receiverID, DefaultValues.docTypeID);  	        
	        bizConetentDao.insert(docID, content, contentType);
	        	        	        
	        //conn.commit();	 
	        
		} catch (Exception e) {			
			throw e;
		} finally {
			//conn.setAutoCommit(true); //for connection pool
			//DBUtil.closeConnection(conn);			
		}
		
		return docID;
	}
	*/
	
	public static void updateBizDoc(String docID, Map<String, String> updateMap) throws Exception {
		
		if (updateMap != null && !updateMap.isEmpty()) {			
			bizDocDao.update(docID, updateMap);			
		}		
	}
	
	public static void processDone(String docID) throws Exception {
		
		Map<String, String> updateMap = new HashMap<>();
		
		updateMap.put(IBizDoc.RoutingStatus, "Done");
		updateMap.put(IBizDoc.UserStatus, "Complete");
		
		bizDocDao.update(docID, updateMap);	
	}
	
	public static void processError(String docID) throws Exception {
		
		Map<String, String> updateMap = new HashMap<>();
		
		updateMap.put(IBizDoc.RoutingStatus, "Done");
		updateMap.put(IBizDoc.UserStatus, "Done W/Errors");
		
		bizDocDao.update(docID, updateMap);	
	}
	
	public static void resubmit(String id) throws Exception {
		
		Map<String, String> dataMap = bizConetentDao.selectOne(id);
		
		String content = dataMap.get(IBizDocContent.content);
		String partName = dataMap.get(IBizDocContent.partName);
		
		ReceiveFlow flow = DBInjector.getInstance(ReceiveFlow.class);		
		flow.start(content, partName);
	}
	
}
