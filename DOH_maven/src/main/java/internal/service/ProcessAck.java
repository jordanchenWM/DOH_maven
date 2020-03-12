package internal.service;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import doc.xml.common.ReceivedAck;
import internal.service.frame.IService;
import internal.tn.module.BizDoc;
import internal.tn.module.BizDocContent;
import internal.xml.util.XmlTestUtil;

public class ProcessAck implements IService {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String xxml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ReceivedAck>\n" + 
				"  <MesgInfo>\n" + 
				"    <ProcessID>WeiShengShu2-20030220182615830</ProcessID>\n" + 
				"    <SenderID>01</SenderID>\n" + 
				"    <ReceiverID>16</ReceiverID>\n" + 
				"    <DocumentType>MAT PO</DocumentType>\n" + 
				"  </MesgInfo>\n" + 
				"  <DocumentInfo>\n" + 
				"    <DocumentNo>2920717020-01</DocumentNo>\n" + 
				"    <Status>07</Status>\n" + 
				"    <LastUpdateTime>2003-09-09 10:41:18</LastUpdateTime>\n" + 
				"  </DocumentInfo>\n" + 
				"  <TransmissionCode>00</TransmissionCode>\n" + 
				"</ReceivedAck>";
		exeTest(xxml);

	}

	@Override
	public  void execute(BizDoc bizDoc, BizDocContent bizDocContent) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("got it");
		System.out.println(bizDocContent.getContent());
		
		JAXBContext jaxbContext = JAXBContext.newInstance(ReceivedAck.class);				
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		ReceivedAck ack = (ReceivedAck) unmarshaller.unmarshal(new StringReader(bizDocContent.getContent()));
		System.out.println(ack.getDocumentInfo().getLastUpdateTime());
		
		
	}
	
	public static void exeTest(String xxml) throws JAXBException, ClassNotFoundException, SQLException {
		//ReceivedAck ack = new ReceivedAck();
		JAXBContext jaxbContext = JAXBContext.newInstance(ReceivedAck.class);				
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		ReceivedAck ack = (ReceivedAck) unmarshaller.unmarshal(new StringReader(xxml));
		//ReceivedAck d = (ReceivedAck) unmarshaller.unmarshal(new StringReader(xxml));
		String DocumentNo = ack.getDocumentInfo().getDocumentNo();
		String TransmissionCode = ack.getTransmissionCode();
		System.out.println("DocumentNo = "+DocumentNo+", TransmissionCode = "+TransmissionCode);
		XmlTestUtil.matProcessAck(DocumentNo, TransmissionCode);
	}

}
