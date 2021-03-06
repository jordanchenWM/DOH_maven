package service.invoice;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;

import doc.xml.common.ReceivedAck;
import doc.xml.invoice.DoHReceiptReply;
import doc.xml.invoice.RecCCDReocvered;
import doc.xml.invoice.UnitPriceInfo;
import doc.xml.util.XmlUtil;
import internal.tn.module.BizDoc;
import internal.tn.module.BizDocContent;
import service.IService;

public class ProcessInvoice implements IService {

	ReceivedAck ack = new ReceivedAck();
	ReceivedAck.DocumentInfo ack_docInfo = new ReceivedAck.DocumentInfo();
	ReceivedAck.ItemInfo ack_itemInfo = new ReceivedAck.ItemInfo();
	
	
	public static void main(String[] args) throws Exception  {
		ProcessInvoice t = new ProcessInvoice();
		
		BizDocContent bizDocContent = new BizDocContent();
		String path = ("/Users/ecomnb/custom_workspace/DOH_maven/tess_src/MATRCPTReply.xml");
		String xml = FileUtils.readFileToString(new File(path), "utf-8");
		bizDocContent.setContent(xml);
		t.execute(null, bizDocContent);
		
	}
	
	@Override
	public void execute(BizDoc bizDoc, BizDocContent bizDocContent) throws Exception {
		
		DoHReceiptReply reply =  (DoHReceiptReply) XmlUtil.stringToObject(DoHReceiptReply.class, bizDocContent.getContent());
		
		/* price */
		UnitPriceInfo price = reply.getUnitPriceInfo();
		String unreceiptno = price.getUnreceiptno();
		
		/* receipt no */
		RecCCDReocvered reocvered = reply.getMCCDRecoveredInfo();
		String receiptno = reocvered.getReceiptno();
		
		
		if (unreceiptno != null && !unreceiptno.isBlank()) { //單價異常			
			processPrice(price);			
		} else if (receiptno != null && !receiptno.isBlank()) { //訂單回覆			
			processPrice(reocvered);			
		} else {
			
		}
		
	}
	
	public void test() throws Exception {
		
		File f = new File("/Users/ecomnb/custom_workspace/DOH_maven/tess_src/MATRCPTReply.xml");
		
		JAXBContext jaxbContext = JAXBContext.newInstance(DoHReceiptReply.class);				
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();		
		DoHReceiptReply d = (DoHReceiptReply) unmarshaller.unmarshal(f);
		
		//System.out.println(d.getReceiptReplyHead().getHospitalInfo().getHospitalID());
		
		
	}

	public void processPrice(UnitPriceInfo price) throws Exception {
		
		String receiptno = price.getReceiptno();
		if (receiptno == null) {
			
		} else {
			var info = receiptno.split("-");
			if (info.length < 2) {
				throw new Exception("Invalid UnitPriceInfo receiptno: " + receiptno);
			}
			
			String rei_no = info[0];
			String rei_item = info[1];
			String rei_bck_id = "";
			String rei_reason = "";
			
			String red_no = rei_no;
			String red_item = rei_item;
			String red_acp_id = "";
			
			String processId = price.getProcessid();
			
			if (processId == null) {
				throw new Exception("no processId");
			}  
			
			switch (processId) {
				case "O":
					rei_bck_id = processId;
					rei_reason = "單價異常處理放行";
					red_acp_id = "O";
					break;
				case "J":
					rei_bck_id = "R";
					rei_reason = "單價異常處理拒絕退回";		
					red_acp_id = "J";
					break;	
				default:
					red_no = "";
					break;
			};
			
			
			/*
			 * send to back end
			 */
			
			/*
			 * start transaction
			 * 1. dao.hp_trei update/insert by key: rei_no, rei_item
			 *    column: rei_bck_id, rei_reason, (rei_acp_id= 0 for insert)
			 * 2. if (!red_no.isEmpty()) 
			 * 	  dao.hp_tred update 
			 */
			 
			//TransmissionCode = 100
			
			/*
			 * ACK
			 * 
			 */
			
			//ack_docInfo.setDocumentNo(mackDoc(rei_no,rei_item));
			ack.setTransmissionCode("100");
		}
	}
	
	public void processPrice(RecCCDReocvered r) throws Exception {
		
		String receiptno = r.getReceiptno();
		if (receiptno == null) {
			
		} else {
			var info = receiptno.split("-");
			if (info.length < 2) {
				throw new Exception("Invalid RecCCDReocvered receiptno: " + receiptno);
			}
						
			String hprev_source_no = info[0];
			String hprev_source_item = info[1];
			String hprev_source_seq = r.getVersion();
			
			String hprev_ally_id = r.getAllianceid();
			String hprev_hospid = r.getHosprgno();
			String hprev_acp_id = "0";
			String hprev_sort = "2";
			String hprev_new_price = r.getNewprice();
			String hprev_source_disamt = ""; //??? add float
			String hprev_alt_dt = ""; //curent data
			String hprev_alt_time = ""; //current time
			String hprev_acp_dt = null;
			String hprev_acp_time = null;
			 
			//update/insert dao.hp_tred
			//String hprev_acp_id = r.ge
			int rowCount = 0;
			//rowCount = select count(*) from dao.hp_tred where hprev_source_no, hprev_source_item, hprev_source_seq
			if (rowCount == 0) {
				//insert
			} else {
				//update hprev_ally_id, hprev_sort, hprev_new_price, hprev_source_disamt, hprev_alt_dt, hprev_alt_time
				//where hprev_source_no, hprev_source_item, hprev_source_seq
			}
			
			//ack_docInfo.setDocumentNo(mackDoc(hprev_source_no, hprev_source_item));
			ack_docInfo.setStatus(hprev_source_seq);
			//ack_docInfo.setLastUpdateTime(now());
			
			ack.setTransmissionCode("200");
			//TransmissionCode = 200
			
		}
	}

	
}
