

import java.util.Map;

import doc.xml.common.DoHAck;
import doc.xml.common.MessageInfo;
import doc.xml.util.XmlUtil;
import internal.db.dao.frame.IPartnerDelivery;
import internal.db.dao.frame.IPartnerField;
import internal.db.util.DBInjector;
import internal.server.util.DataSourceManager;
import internal.tn.ReceiveFlow;

public class MappingTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//MappingTest.test();
		//MappingTest.test2();
		
		//DB
		DataSourceManager.enable("Alias_Test");
		DataSourceManager.getConnection("Alias_Test");
		
		
		//XML
		DoHAck ack = new DoHAck();
		
		MessageInfo msg = new MessageInfo();
		msg.setProcessID("WeiShengShu2-20030220182615830");
		msg.setSenderID("99");
		msg.setReceiverID("01");
		msg.setDocumentType("RF");
		ack.setMessageInfo(msg);
		
		DoHAck.DocumentInfo info = new DoHAck.DocumentInfo();
		info.setDocumentNo("2920101001-01");
		info.setTransmissionCode("00");
		ack.setDocumentInfo(info);
		
		//send
		String content = XmlUtil.jaxbObjectToXML(ack);
		ReceiveFlow flow = DBInjector.getInstance(ReceiveFlow.class);
		flow.start(content, "text/xml");
	}

	
	public static void test() {
		
		IPartnerField f = DBInjector.getInstance(IPartnerField.class);
		
		String id = f.getPartnerIDByField(10, "css");
		
		System.out.println(id);
	}
	
	public static Map<String, String>  test2() {
		
		IPartnerDelivery d = DBInjector.getInstance(IPartnerDelivery.class);
		
		Map<String, String> map = d.getDeliveryByMethod("b640835c-3ee0-4fe1-8761-0d278c4cdc61", "HTTPS-aaaa");
		
		System.out.println(map);
		
		return map;
	}
	
}
