package internal.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import internal.server.util.DefaultValues;
import internal.service.frame.IService;
import internal.tn.module.BizDoc;
import internal.tn.module.BizDocContent;

public class Process implements IService {

	Logger logger = LogManager.getLogger(DefaultValues.serverLog);


	@Override
	public void execute(BizDoc bizDoc, BizDocContent bizDocContent) {
		// TODO Auto-generated method stub
		logger.info(this.getClass().getCanonicalName() + " execute");
	}

	
	/*
	@Override
	public void execute(String docID, String partnerID, Object contentDoc, String schemaPath) throws Exception{
		// TODO Auto-generated method stub
		
		logger.info(this.getClass() + " started... with docID: " + docID);
		
		//XmlExtractor extractor = new XmlExtractor();
		//extractor.setXmlDoc((Document) contentDoc);
		
		ObjectFactory o = new ObjectFactory();
		DoHAck ack = new DoHAck();
		
		MessageInfo msg = new MessageInfo();
		msg.setProcessID("ProcessID");
		msg.setSenderID("SenderID");
		msg.setReceiverID("ReceiverID");
		msg.setDocumentType("DocumentType");
		ack.setMessageInfo(msg);
		
		DoHAck.DocumentInfo info = new DoHAck.DocumentInfo();
		info.setDocumentNo("2920101001-01");
		info.setTransmissionCode("00");
		ack.setDocumentInfo(info);
		
		
		try {
			
			IPartnerDelivery delivery = DBInjector.getInstance(IPartnerDelivery.class);
			Map<String, String> deliveryMap = delivery.getDeliveryByMethod(partnerID, null);
					
			String host = deliveryMap.get(PartnerDelivery.Host);
			String port = deliveryMap.get(PartnerDelivery.Port);
			String location = deliveryMap.get(PartnerDelivery.Location);
			String userName = deliveryMap.get(PartnerDelivery.UserName);
			
			//String url = "http://192.168.11.121:5555/invoke/wm.tn:receive";
			String url = "http://" + host + ":" + port +"/" + location;
			String data = XmlTest.jaxbObjectToXML(ack);
			
			
			HttpClient httpClient = new HttpClient();
			//HttpClient.Auth auth = httpClient.new Auth("Administrator", "manage");
			HttpClient.Auth auth = null;
			if (userName != null) {
				String password = deliveryMap.get(PartnerDelivery.Password);
				auth = httpClient.new Auth(userName, password);
			}
			
			HttpURLConnection conn = httpClient.send(url, "POST", auth, data);
			
			logger.debug("Value" + conn.getResponseCode());
			logger.debug(conn.getResponseMessage());
			logger.debug("content"+conn.getContent());
            
            conn.disconnect();
			        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("send ack error: " + e.getMessage());
		}	    
	}
	*/

}
