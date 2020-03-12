package unit;

import java.net.HttpURLConnection;
import java.sql.Connection;

import doc.xml.util.XmlUtil;
import internal.db.dao.frame.IPartnerDelivery;
import internal.db.util.DBInjector;
import internal.db.util.DBUtil;
import internal.tn.ReceiveFlow;
import pub.client.HttpClientUtil;
import pub.client.HttpClientUtil.Auth;

public class HttpSend {

	public static void main(String[] args) throws Exception {
		
		String host = "192.168.11.240";
		String port = "110";
		/*
		String location = deliveryMap.get(IPartnerDelivery.Location);
		String userName = deliveryMap.get(IPartnerDelivery.UserName);
		
		String url = "http://" + host + ":" + port +"/" + location;
		String data = XmlUtil.jaxbObjectToXML(ack);
		
		logger.debug(url);
		
		HttpClient httpClient = new HttpClient();
		HttpClient.Auth auth = null;
		if (userName != null) {
			String password = deliveryMap.get(IPartnerDelivery.Password);
			auth = httpClient.new Auth(userName, password);
		}
		
		HttpURLConnection conn = httpClient.send(url, "POST", auth, data);
		
		//conn.connect();
		
		logger.debug(conn.getResponseCode());
		
		ReceiveFlow flow = DBInjector.getInstance(ReceiveFlow.class);
		flow.persist(data, "text/xml");
		*/
	}
	
	static String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
			"<UePPDocument xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"..\\XML Schema\\UePPPOReply.xsd\">\n" + 
			"	<MessageInfo>\n" + 
			"		<ReceiverID>70436169</ReceiverID>\n" + 
			"		<SenderID>MePR</SenderID>\n" + 
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
	
	
	
	
}
