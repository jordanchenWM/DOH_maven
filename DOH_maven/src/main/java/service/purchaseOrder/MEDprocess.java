package service.purchaseOrder;


import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import internal.db.dao.frame.IPartnerDelivery;
import internal.db.util.DBInjector;
import internal.server.util.DefaultValues;
import internal.tn.module.BizDoc;
import internal.tn.module.BizDocContent;
import pub.client.HttpClientUtil;
import service.IService;

public class MEDprocess implements IService{

	Logger logger = LogManager.getLogger(DefaultValues.serverLog); 
	
	@Override
	public void execute(BizDoc bizDoc, BizDocContent bizDocContent) {
		// TODO Auto-generated method stub
		
		
		IPartnerDelivery partnerDelivery = DBInjector.getInstance(IPartnerDelivery.class);
		Map<String, String> deliveryMap = partnerDelivery.getDeliveryByMethod(bizDoc.getReceiverID(), "http-primary");
		
		logger.info("map: "+deliveryMap);
		
		String host = deliveryMap.get(IPartnerDelivery.Host);
		String port = deliveryMap.get(IPartnerDelivery.Port);
		String location = deliveryMap.get(IPartnerDelivery.Location);
		String userName = deliveryMap.get(IPartnerDelivery.UserName);
		
		String url = "http://" + host + ":" + port + "/" + location;
		//String data = XmlUtil.jaxbObjectToXML(ack);
		String data = bizDocContent.getContent();
		
		logger.debug(url);
		System.out.println("Send Xml to " + url + ".... ");
		HttpClientUtil httpClient = new HttpClientUtil();
		HttpClientUtil.Auth auth = null;
		if (userName != null) {
			String password = deliveryMap.get(IPartnerDelivery.Password);
			auth = httpClient.new Auth(userName, password);
		}
		
		try {
			var response = httpClient.send(url, "POST", auth, data);
			logger.debug(response.statusCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
