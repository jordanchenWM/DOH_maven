package internal.service;


import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;

import internal.db.dao.frame.IPartnerDelivery;
import internal.db.util.DBInjector;
import internal.extractor.XmlExtractor;
import internal.server.util.DefaultValues;
import internal.service.frame.IService;
import internal.tn.module.BizDoc;
import internal.tn.module.BizDocContent;
import internal.xml.module.DoHAck;
import internal.xml.module.MessageInfo;
import internal.xml.util.XmlUtil;
import pub.client.HttpClientUtil;

public class Reorg implements IService {

	Logger logger = LogManager.getLogger(DefaultValues.serverLog);
	
	@Override
	public void execute(BizDoc bizDoc, BizDocContent bizDocContent) {
		// TODO Auto-generated method stub
		if (bizDoc == null || bizDocContent == null) {
			logger.warn("input bizDoc or bizDocContent is null.");
			logger.debug("bizDoc: " + bizDoc + ", bizDocContent: " + bizDocContent);
			return;
		}
		
		logger.info(this.getClass() + " started... with docID: " + bizDoc.getDocID());
		
		try {
			XmlExtractor extractor = new XmlExtractor();	
			
			Object parsedContent = bizDocContent.getParsedContent();
			if (parsedContent == null) {
				extractor.initContent(bizDocContent.getContent());
			} else {
				extractor.setXmlDoc((Document) parsedContent);
			}
			
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
			
			IPartnerDelivery delivery = DBInjector.getInstance(IPartnerDelivery.class);
			String protocal = "HTTP-Primary";
			Map<String, String> deliveryMap = delivery.getDeliveryByMethod(bizDoc.getSenderID(), protocal);
			
			if (deliveryMap == null || deliveryMap.isEmpty()) {
				//logger.warn("deliveryMap is empty");
				logger.warn("No delievery found for " + bizDoc.getSenderID() + ", protocal: " + protocal );
			} else {
				String host = deliveryMap.get(IPartnerDelivery.Host);
				String port = deliveryMap.get(IPartnerDelivery.Port);
				String location = deliveryMap.get(IPartnerDelivery.Location);
				String userName = deliveryMap.get(IPartnerDelivery.UserName);
				
				String url = "http://" + host + ":" + port +"/" + location;
				String data = XmlUtil.jaxbObjectToXML(ack);
				
				logger.debug(url);
				
				HttpClientUtil httpClient = new HttpClientUtil();
				HttpClientUtil.Auth auth = null;
				if (userName != null) {
					String password = deliveryMap.get(IPartnerDelivery.Password);
					auth = httpClient.new Auth(userName, password);
				}
				
				var response = httpClient.send(url, "POST", auth, data);
				
				//conn.connect();
				
				logger.debug(response.statusCode());
				
				//ReceiveFlow flow = DBInjector.getInstance(ReceiveFlow.class);
				//flow.persist(data, "text/xml");
			} 
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("send ack error: " + e.getMessage());
		}
		
		
	}



}
