package unit;

import javax.xml.bind.JAXBException;

import doc.xml.common.DoHAck;
import doc.xml.common.MessageInfo;
import doc.xml.util.XmlUtil;

public class XmlTest {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		DoHAck ack = new DoHAck();
		
		MessageInfo msg = new MessageInfo();
		msg.setProcessID("WeiShengShu2-20030220182615830");
		msg.setSenderID("99");
		msg.setReceiverID("01");
		msg.setDocumentType("RF");
		ack.setMessageInfo(msg);
		/*
		//DoHAck.DocumentInfo info = new DoHAck.DocumentInfo();
		DoHAck.DocumentInfo info = new DoHAck.DocumentInfo();
		
		info.setDocumentNo("2920101001-01");
		info.setTransmissionCode("00");
		ack.setDocumentInfo(info);
		*/
				
		String xml = XmlUtil.jaxbObjectToXML(ack);
		System.out.println(xml);
		//String version = Runtime.class.getPackage().getImplementationVersion();
	}
}
