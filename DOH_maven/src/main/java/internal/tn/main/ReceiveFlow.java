package internal.tn.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Throwables;

import internal.db.dao.frame.IActivityLog;
import internal.db.dao.frame.IBizDoc;
import internal.db.dao.frame.IBizDocType;
import internal.db.dao.frame.IPartnerField;
import internal.db.dao.frame.IProcessingRule;
import internal.db.util.DBInjector;
import internal.db.util.LogDb;
import internal.extractor.IExtractor;
import internal.extractor.XmlExtractor;
import internal.server.util.DefaultValues;
import internal.service.frame.IService;
import internal.tn.FormatException;
import internal.tn.module.BizDoc;
import internal.tn.module.BizDocContent;

public class ReceiveFlow {

	private Logger logger = LogManager.getLogger(DefaultValues.serverLog);  
	
	private BizDoc bizDoc = new BizDoc();
	private BizDocContent bizDocContent = new BizDocContent();
	private String docID = null;
	private boolean useRule = true;
	//private String rootTag = null;
	
		
	//private IBizDoc bizDocDao = DBInjector.getInstance(IBizDoc.class);;
	//private IBizDocContent bizConetentDao = DBInjector.getInstance(IBizDocContent.class);;
	private IPartnerField partnerFieldDao = DBInjector.getInstance(IPartnerField.class);;
	private IBizDocType bizDocTypeDao = DBInjector.getInstance(IBizDocType.class);;
	private IProcessingRule processingRuleDao = DBInjector.getInstance(IProcessingRule.class);;
	private IExtractor extractor = DBInjector.getInstance(XmlExtractor.class);
	
	//Map<String, String> bizDocTypeMap = null;
	
	
	public static void main(String[] args) throws Exception {

		ReceiveFlow flow = DBInjector.getInstance(ReceiveFlow.class);
		String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
				"<UePPDocument xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"..\\XML Schema\\UePPPOReply.xsd\">\n" + 
				"	<MessageInfo>\n" + 
				"		<ReceiverID>70436169</ReceiverID>\n" + 
				"		<DocumentType>MePR</DocumentType>\n" + 
				"	</MessageInfo></UePPDocument>";
		flow.start(content, "1");	
	}
	
		
	public String startWithoutRule(String content, String contentType) throws Exception {
		useRule = false;
		this.start(content, contentType);
		return this.docID;
	}
	
	public String start(String content, String contentType) throws Exception {		     
        			
		//set docID
		//persist(content, contentType);
		try {
			this.docID = TnUtil.persist(content, contentType);			
		} catch (Exception e) {
			logger.error(Throwables.getStackTraceAsString(e));	
			throw e;
		}
		
		bizDoc.setDocID(docID);
		bizDocContent.setContent(content);
		bizDocContent.setContentType(contentType);
		
		new Thread(thread).start();	
		
		return this.docID;
	}
	
	/*
	public void persist(String content, String contentType) throws Exception {
		   
		logger.info("<--- doc persist");
		
		try {
			this.docID = TnUtil.persist(content, contentType);			
		} catch (Exception e) {
			logger.error(Throwables.getStackTraceAsString(e));	
			throw e;
		}
		
		LogDb.logInfo(IActivityLog.general, docID, "doc persist", "doc persist with id: " + this.docID);		
		logger.info(">--- doc persist with docID: " + docID);
					
	}
	*/
	
	Runnable thread = () -> { 
			
		//set rootTag
		recognize();
				
		//processingRule		
		if (useRule) {
			processingRule();
		}		
	};
	
	
	private void recognize() {
		
		String rootTag = null;
		
		try {
			Object parsedContent = extractor.initContent(bizDocContent.getContent());
			rootTag = extractor.getRootTag();
			bizDocContent.setParsedContent(parsedContent);		
			
			//extract		
			Map<String, String> updateMap = extract(rootTag);
				
			//		
			updateBizDoc(updateMap);
			
		} catch (FormatException e) {
			logger.error(Throwables.getStackTraceAsString(e));			
		}		
		
		logger.debug("rootTag: " + rootTag);
	}
	
	
	private void updateBizDoc(Map<String, String> updateMap) {
		
		logger.info("<--- update bizdoc");
		
		try {
			TnUtil.updateBizDoc(docID, updateMap);
		} catch (Exception e) {
			logger.error(Throwables.getStackTraceAsString(e));
		}
				
		logger.info(">--- end of update bizdoc");
	}
	
	
	private void processingRule() {
		
		logger.info("ProcessingRule start...");
		
		Map<String, String> updateMap = new HashMap<>();		
		
		Class<?> clazz;
		try {
			Map<String, String> dataMap = processingRuleDao.getRule(bizDoc.getSenderID(), bizDoc.getReceiverID(), bizDoc.getDocTypeID());
			if (dataMap == null || dataMap.isEmpty()) {
				logger.warn("No Processing Rule found");
				LogDb.logInfo(IActivityLog.processing, docID,
						"No Processing Rule found", "No Processing Rule found");
			} else {
				String ruleName = dataMap.get(IProcessingRule.RuleName);
				String className = dataMap.get(IProcessingRule.Service);
				
				LogDb.logInfo(IActivityLog.processing, docID,
						"Rule " + ruleName + " selected", "Execute " + ruleName);
				
				//execute
				clazz = Class.forName(className);
				IService process = (IService) clazz.getDeclaredConstructor().newInstance();
				process.execute(bizDoc, bizDocContent);
				
				LogDb.logInfo(IActivityLog.general, docID,
						"Processing complete", "	Processing complete");
			}		
			updateMap.put(IBizDoc.RoutingStatus, "Done");
		} catch (Exception e) {
			e.printStackTrace();
			updateMap.put(IBizDoc.RoutingStatus, "Done W/Errors");
			String error = e.getClass().getName() + ": "+ e.getMessage();
			logger.error(Throwables.getStackTraceAsString(e));
			LogDb.logError(IActivityLog.processing, docID, "Processing failed", error);			
		} finally {
			try {
				TnUtil.updateBizDoc(docID, updateMap);
			} catch (Exception e) {
				logger.error(Throwables.getStackTraceAsString(e));
			}
		}		
	}
	
	
	
	
	private Map<String, String> extract(String rootTag) {
				
		logger.info("<--- extract doc content");
		
		//map to update bizdoc
		Map<String, String> updateMap = new HashMap<>();
				
		//get bizDocType data map from db
		Map<String, String> bizDocTypeMap = bizDocTypeDao.selectOne(rootTag);			
		String docTypeID = bizDocTypeMap.get(IBizDocType.TypeID);   
				
		
	    if (StringUtils.isEmpty(docTypeID)) { 
	    		logger.warn("No doc type found for transaction: " + docID);
	    	} else {	    		
	    		
	    		bizDoc.setDocTypeID(docTypeID);
	    		updateMap.put(IBizDoc.DocTypeID, docTypeID);
	    		
	    		//sender
	    		String path = bizDocTypeMap.get(IBizDocType.SenderPath);
	    		String senderID = extractField("SenderID", path);
	    		if (senderID != null) {
	    			String typeID = bizDocTypeMap.get(IBizDocType.SenderFieldType);
	    			String partnerID = getInternalID("SenderID", typeID, senderID);
	    			if (partnerID != null) {
	    				bizDoc.setSenderID(partnerID);
		    			updateMap.put(IBizDoc.SenderID, partnerID);
	    			}	    		
	    		}
	    		
	    		//receiver
	    		path = bizDocTypeMap.get(IBizDocType.ReceiverPath);
	    		String receiverID = extractField("ReceiverID", path);
	    		if (receiverID != null) {
	    			String typeID = bizDocTypeMap.get(IBizDocType.ReceiveFieldType);
	    			String partnerID = getInternalID("ReceiverID", typeID, receiverID);
	    			if (partnerID != null) {
	    				//receiverID = partnerID;
	    				bizDoc.setReceiverID(partnerID);
		    			updateMap.put(IBizDoc.ReceiverID, partnerID);
	    			}	    			
	    		}
	    		
	    		//documentID
	    		path = bizDocTypeMap.get(IBizDocType.DocumentPath);
	    		String nativeID = extractField("DocumentID", path);	    		
	    		if (nativeID != null) {
	    			updateMap.put(IBizDoc.NativeID, nativeID);
	    		}
	    		
	    		//ConversationID
	    		path = bizDocTypeMap.get(IBizDocType.ConversationPath);
	    		String conversationID = extractField("ConversationID", path);	    		
	    		if (conversationID != null) {
	    			updateMap.put(IBizDoc.ConversationID, conversationID);
	    		} 
	    	}
	    
	    logger.info(">--- end of extract");
	    
	    return updateMap;
	}
	
	private String extractField(String field, String path) {	
		
		String extractValue = null;
		
		try {	
			
			extractValue = extractor.extract(path);		
			
			if (StringUtils.isEmpty(extractValue)) {
				throw new FormatException("No value found for path: " + path);
			}
			
			logger.debug(field + ": " + extractValue);
						
		} catch (FormatException e) {	
			logger.warn("Query failed: " + field + " - " + e.getMessage());			
			LogDb.logWarn(IActivityLog.recognition, docID, "Query failed: " + field, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Throwables.getStackTraceAsString(e));
		}
		return extractValue;	
	}
	
	private String getInternalID(String type, String typeId, String externalID) {
		
		String partnerID = null;
		try {			
			
			if (StringUtils.isEmpty(typeId)) {
				throw new FormatException("typeId not found: " + type);
			}
			
			partnerID = partnerFieldDao.getPartnerIDByField(Integer.parseInt(typeId), externalID);
			
			if (StringUtils.isEmpty(partnerID)) {
				throw new FormatException(externalID + " is not defined in any partner");
			}
			
		} catch (FormatException e) {
			logger.warn("Transform failed: " + type + " " + e.getMessage());
			LogDb.logWarn(IActivityLog.recognition, docID, "Transform failed: " + type, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Throwables.getStackTraceAsString(e));
		}
		return partnerID;
	}
	
	
	
	
}
