package service;
import java.io.IOException;
import java.util.Map;

import internal.db.dao.frame.IPartnerDelivery;
import internal.db.util.DBInjector;
import internal.tn.ReceiveFlow;
import internal.tn.TnUtil;
import internal.tn.module.BizDoc;
import internal.tn.module.BizDocContent;
import pub.client.HttpClientUtil;

public class HttpTest implements IService {

	public static void main(String[] args) throws Exception {
		HttpTest t = new HttpTest();
		t.test();
	}
	
	String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
			"<UePPDocument xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"..\\XML Schema\\UePPPOReply.xsd\">\n" + 
			"	<MessageInfo>\n" + 
			"		<ReceiverID>MePR</ReceiverID>\n" + 
			"		<SenderID>70436169</SenderID>\n" + 
			"		<Document>willy_123</Document>\n" + 
			"		<ConversationID>2882-5252</ConversationID>\n" + 
			"	</MessageInfo>\n" + 
			"	<DocumentInfo>\n" + 
			"		<POHead>\n" + 
			"			<PONO>2920101001-01</PONO>\n" + 
			"			<STATUSID>04</STATUSID>\n" + 
			"			<STATUSTIME>2003-01-02 16:00:20</STATUSTIME>\n" + 
			"			<HOSPRGNO>99</HOSPRGNO>\n" + 
			"			<VNRGNO>70436169</VNRGNO>\n" + 
			"			<VNREJECTMEMO/>\n" + 
			"		</POHead>\n" + 
			"		<POLine>\n" + 
			"			<POLINENO>01</POLINENO>\n" + 
			"			<ShipSchedule>\n" + 
			"				<SHIPSEQNO>1</SHIPSEQNO>\n" + 
			"				<SHIPQTY>50</SHIPQTY>\n" + 
			"				<SHIPDATE>2003-01-03 00:00:00</SHIPDATE>\n" + 
			"			</ShipSchedule>\n" + 
			"			<ShipSchedule>\n" + 
			"				<SHIPSEQNO>2</SHIPSEQNO>\n" + 
			"				<SHIPQTY>50</SHIPQTY>\n" + 
			"				<SHIPDATE>2003-01-05 00:00:00</SHIPDATE>\n" + 
			"			</ShipSchedule>\n" + 
			"		</POLine>\n" + 
			"	</DocumentInfo>\n" + 
			"</UePPDocument>\n" ; 
	
	public void test() throws Exception {
		
		IPartnerDelivery delivery = DBInjector.getInstance(IPartnerDelivery.class);
		Map<String, String> deliveryMap = delivery.getDeliveryByMethod("1af1d91c-7e00-4280-97d9-dc7619f69333", "http");
		
		
		if (deliveryMap == null || deliveryMap.isEmpty()) {
			//logger.warn("deliveryMap is empty");
			System.out.println("No delievery found for "  );
		} else {
			
			String host = deliveryMap.get(IPartnerDelivery.Host);
			String port = deliveryMap.get(IPartnerDelivery.Port);
			String location = deliveryMap.get(IPartnerDelivery.Location);
			String userName = deliveryMap.get(IPartnerDelivery.UserName);
			
			String url = "http://" + host + ":" + port +"/" + location;
			
			
			
			System.out.println(url);
			
			HttpClientUtil client = new HttpClientUtil();
			HttpClientUtil.Auth auth = null;
			if (userName != null) {
				String password = deliveryMap.get(IPartnerDelivery.Password);
				System.out.println(password);
				auth = client.new Auth(userName, password);
			}
			
			//HttpURLConnection conn = httpClient.send(url, "POST", auth, xml);			
			//conn.connect();
			
			ReceiveFlow flow = new ReceiveFlow();
			String docID = null;
			try {
				docID = flow.startWithoutRule(xml, "text/xml");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/*
			try {
				TnUtil.persist(xml, "text/xml");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			*/
			
			var start = System.currentTimeMillis();
			try {
				
				var rs = client.send(url, "POST", auth, xml);
				//System.out.println(rs.statusCode());
				//System.out.println(rs.body());
				//LogDb.logInfo(IActivityLog.processing, docID, "Send request: " + rs.statusCode() , rs.body());
				TnUtil.addContent(docID, "response " + rs.statusCode(), rs.body(), "text");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				var stop = System.currentTimeMillis();
				System.out.println(stop - start);
				e.printStackTrace();
			}
			
			TnUtil.processDone(docID);
			
			//System.out.println(conn.getResponseCode());
			/*
			ReceiveFlow flow = DBInjector.getInstance(ReceiveFlow.class);
			flow.persist(data, "text/xml");
			*/
		} 
		//HttpClient client = new HttpClient();
		//client.send(url, method, null, xml);
	}

	@Override
	public void execute(BizDoc bizDoc, BizDocContent bizDocContent) throws Exception {
		// TODO Auto-generated method stub
		try {
			test();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
