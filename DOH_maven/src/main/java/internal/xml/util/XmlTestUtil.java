package internal.xml.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import internal.db.dao.frame.IPartnerDelivery;
import internal.db.util.DBInjector;
import internal.tn.main.ReceiveFlow;
import internal.tn.main.TnUtil;
import pub.client.HttpClientUtil;
import pub.client.HttpClientUtil.Auth;
import unit.Para;

public class XmlTestUtil {
	public static void main(String[] args) throws Exception {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" + 
				"<DoHPORequest xsi:noNamespaceSchemaLocation=\"..\\XML Schema\\MATPORequest.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" + 
				"    <MesgInfo>\n" + 
				"        <ProcessID>WeiShengShu2-20030220182615830</ProcessID>\n" + 
				"        <SenderID>99</SenderID>\n" + 
				"        <ReceiverID>01</ReceiverID>\n" + 
				"        <DocumentType>RF</DocumentType>\n" + 
				"    </MesgInfo>\n" + 
				"    <PORequestHead>\n" + 
				"        <PORequestSummary>\n" + 
				"            <PONo>2920716007-02</PONo>\n" + 
				"            <POSort>2</POSort>\n" + 
				"            <PODate>2003-07-16 00:00:00</PODate>\n" + 
				"            <TotalAmount>1698.00</TotalAmount>\n" + 
				"            <TotalQtyDiscountAmount>0.00</TotalQtyDiscountAmount>\n" + 
				"            <TotalAfterQtyDiscountAmount>1698.00</TotalAfterQtyDiscountAmount>\n" + 
				"            <Status>E</Status>\n" + 
				"            <UpdateTime>2003-08-07 18:11:43</UpdateTime>\n" + 
				"            <Delete_User></Delete_User>\n" + 
				"            <Delete_Reason></Delete_Reason>\n" + 
				"        </PORequestSummary>\n" + 
				"        <HospitalInfo>\n" + 
				"            <HospitalID>02</HospitalID>\n" + 
				"            <PurchaseDept>總 倉</PurchaseDept>\n" + 
				"            <PurchaseStaff>王靜婷</PurchaseStaff>\n" + 
				"            <ReqInvoiceDate>2003-07-01 00:00:00</ReqInvoiceDate>\n" + 
				"            <Memo></Memo>\n" + 
				"        </HospitalInfo>\n" + 
				"        <VendorInfo>\n" + 
				"            <VendorID>59220402</VendorID>\n" + 
				"        </VendorInfo>\n" + 
				"    </PORequestHead>\n" + 
				"    <PORequestItem>\n" + 
				"        <PORequestDetail>\n" + 
				"            <POItemNo>02</POItemNo>\n" + 
				"            <RequireDate>2003-07-16 00:00:00</RequireDate>\n" + 
				"            <Qty>60.000</Qty>\n" + 
				"            <UnitPrice>28.3000</UnitPrice>\n" + 
				"            <Amount>1698.00</Amount>\n" + 
				"            <QtyDiscountRate>0.0000</QtyDiscountRate>\n" + 
				"            <QtyDiscountAmount>0.00</QtyDiscountAmount>\n" + 
				"            <AfterQtyDiscountAmount>1698.00</AfterQtyDiscountAmount>\n" + 
				"        </PORequestDetail>\n" + 
				"        <MaterialInfo>\n" + 
				"            <BatchLabel>1</BatchLabel>\n" + 
				"            <BatchNo>C1331-02</BatchNo>\n" + 
				"            <MaterialType>2</MaterialType>\n" + 
				"            <MaterialCode></MaterialCode>\n" + 
				"            <MaterialBrand></MaterialBrand>\n" + 
				"            <MaterialName></MaterialName>\n" + 
				"            <MaterialSpec></MaterialSpec>\n" + 
				"            <MaterialUnit>個</MaterialUnit>\n" + 
				"        </MaterialInfo>\n" + 
				"    </PORequestItem>\n" + 
				"</DoHPORequest>";
		doPost(xml);
	}
	
	public static String nullOrTrim(String val) {
	    if (val==null || val.equals("")) {
	    	val = "";
	    	return val;
	    } else {
	    	val = val.trim();
	    	return val;
	    }
	}
	
	//補滿幾位數
	public static String padLeft(String s, int len) {
		return String.format("%0"+len+"d", Integer.parseInt(s));
	}
	
	//1091020, 182533 -> 2020-10-20 18:25:33
	public static String HISToDatetime(String ming, String time) {
		String siyun = null;
		String newTime = null;
		String result = null;
		/*
		if (ming.equals("") || ming==null || time.equals("") || time==null) {
			System.out.println("It's null");
			result = "";
			return result;
		}*/
		
		if (ming.length()==7) {
			//1091020
			int year = Integer.parseInt(ming.substring(0, 3))+1911;
			String month = ming.substring(3, 5);
			String day = ming.substring(5);
			siyun = String.valueOf(year)+"-"+month+"-"+day;
			
		} else if (ming.length()==6) {
			//851020
			int year = Integer.parseInt(ming.substring(0, 2))+1911;
			String month = ming.substring(2, 4);
			String day = ming.substring(4);
			siyun = String.valueOf(year)+"-"+month+"-"+day;
		}
		
		//12:03:55
		if (!time.equals("") || !time.equals(null)) {
			String hour = time.substring(0, 2);
			String minute= time.substring(2, 4);
			String second= time.substring(4);
			newTime = " "+hour+":"+minute+":"+second;
		} else {
			newTime = " 00:00:00";
		}
		
		result = siyun + newTime;
		return result;
	}
	
	//1091020 -> 2020-10-20 00:00:00
	public static String HISToDatetime(String ming) {
		String siyun = null;
		String result = null;
		
		if (ming.length()==7) {
			//1091205
			int year = Integer.parseInt(ming.substring(0, 3))+1911;
			String month = ming.substring(3, 5);
			String day = ming.substring(5);
			
			siyun = String.valueOf(year)+"-"+month+"-"+day;
		} else if (ming.length()==6){
			//970805
			int year = Integer.parseInt(ming.substring(0, 2))+1911;
			String month = ming.substring(2, 4);
			String day = ming.substring(4);
			
			//2003-07-01 00:00:00
			siyun = String.valueOf(year)+"-"+month+"-"+day;
		}
		
		result = siyun + " 00:00:00";
		return result;
	}
	
	//10908 -> 2010-08-01 00:00:00
	public static String HISYMToDatetime(String ming) {
		String siyun = null;
		String result = null;
		ming = ming+"01";
		
		if (ming.length()==7) {
			//10908
			int year = Integer.parseInt(ming.substring(0, 3))+1911;
			String month = ming.substring(3, 5);
			String day = ming.substring(5);
			siyun = String.valueOf(year)+"-"+month+"-"+day;
			
		} else if (ming.length()==6){
			//9708
			int year = Integer.parseInt(ming.substring(0, 2))+1911;
			String month = ming.substring(2, 4);
			String day = ming.substring(4);
			siyun = String.valueOf(year)+"-"+month+"-"+day;
		}
		
		result = siyun + " 00:00:00";
		return result;
	}
	
	//12345678-02
	public static String MakeDoc(String doc_no, String doc_item) {
		String pono = null;
		
		if (!doc_no.equals(null) || doc_no!="" && !doc_item.equals(null) || doc_item!="") {
			pono = doc_no+"-"+padLeft(doc_item,2); 
		} else if (doc_no.equals(null) || doc_no=="" && !doc_item.equals(null) || doc_item!=""){
			pono = ""+"-"+padLeft(doc_item,2);
		} else if (!doc_no.equals(null) || doc_no!="" && doc_item.equals(null) || doc_item=="") {
			pono = doc_no+"-"+"";
		}else if (!doc_no.equals(null) || doc_no=="" && doc_item.equals(null) || doc_item=="") {
			pono = "";
		}
		
		return pono;
	}
	
	 public static void doPost(String xml) throws IOException, InterruptedException {
		 
		 String username = "Administrator";
		 String password = "manage";
		 String basicAuth = "Basic " + new String(Base64.getEncoder().encode((username+":"+password).getBytes()));
		 HttpClient client = HttpClient.newBuilder().build();
		 HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://192.168.11.121:5105/invoke/wm.tn/receive"))
                .header("Content-Type","text/xml")
                .header("Authorization", basicAuth)
                .POST(HttpRequest.BodyPublishers.ofString(xml))
                .build();

	      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	      System.out.println(response.statusCode());
	    }
	 
	 public static String matProcessAck(String DocumentNo, String TransmissionCode) throws ClassNotFoundException, SQLException {
		 String receivedCode = Para.getReceivedCode();
		 String receivedCode_inventory = Para.getReceivedCode_inventory();
		 String unsendCode = Para.getUnsendCode();
		 String accessCode = null;
		 String exceptionID = null;
		 
		 String odf_no = "";
		 String odf_item = "";
		 String odf_acp_id = "";
		 String odf_b_status_new = "";
		 String odf_err_id = "";
		 String odf_bck_rem = "";
		 
		 String[] tokens = DocumentNo.split("-");
		 String doc_no = tokens[0];
		 String doc_item = tokens[1];
		 
		 String URL = "jdbc:sqlserver://192.168.11.92:1433;databaseName=HIS;allowMultiQueries=true";
		 String Account = "sa";
		 String Password = "ecom@168";	
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 Connection conn = DriverManager.getConnection(URL,Account,Password);
		 
		 String sel_hp_todf = "Select * from hp_todf where odf_no = '"
		 		+ doc_no
		 		+ "' and odf_item = '"
		 		+ doc_item
		 		+ "'";
		 PreparedStatement ps = conn.prepareStatement(sel_hp_todf);
		 ResultSet rs = ps.executeQuery();
		 String odf_b_status = rs.getString("odf_b_status");
		 
		 if (TransmissionCode == "00" ) {
			 accessCode = receivedCode; //1
		 } else if (TransmissionCode == "00512" ) {
			 exceptionID = decodeExceptionID(TransmissionCode);
			 odf_no = doc_no;
			 odf_item = doc_item;
			 odf_acp_id = unsendCode;
			 odf_b_status_new = "R";
			 odf_err_id = "P";
			 odf_bck_rem = exceptionID;
			 accessCode = receivedCode;
		 } else if(TransmissionCode.length()==5 && TransmissionCode != "00512") {
			 exceptionID = decodeExceptionID(TransmissionCode);
			 odf_no = doc_no;
			 odf_item = doc_item;
			 odf_acp_id = unsendCode;
			 odf_b_status_new = "R";
			 odf_err_id = "S";
			 odf_bck_rem = exceptionID;
			 accessCode = "T";
		 } else {
			 odf_no = doc_no;
			 odf_item = doc_item;
			 odf_acp_id = unsendCode;
			 odf_b_status_new = odf_b_status;
			 odf_err_id = "P";
			 odf_bck_rem = exceptionID;
			 accessCode = unsendCode;
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 return null;
	 }
	 
	 public static String decodeExceptionID(String TransmissionCode) {
		 String unitCode = null;
		 String reason = "";
		 String signFlag = "false";
		 String exceptionID = null;
		 if (!TransmissionCode.equals("")) {
			 switch (TransmissionCode) {
			 case "2" :
				 unitCode = "B";
				 reason = "屆別異常";
				 break;
			 case "4" :
				 unitCode = "C";
				 reason = "代碼異常";
				 break;
			 case "8" :
				 unitCode = "S";
				 reason = "項次異常";
				 break;
			 case "16" :
				 unitCode = "T";
				 reason = "品項異常";
				 break;
			 case "32" :
				 unitCode = "G";
				 reason = "統一編號錯誤";
				 break;
			 case "64" :
				 unitCode = "D";
				 reason = "D折讓率異常";
				 break;
			 case "128" :
				 unitCode = "M";
				 reason = "金額為負";
				 break;
			 case "256" :
				 unitCode = "Q";
				 reason = "跨級距折讓差額異常";
				 break;
			 case "512" :
				 unitCode = "P";
				 reason = "單價有誤，請至聯購網單價異常管理功能進行放行或拒絕";
				 break;
			 case "1024" :
				 unitCode = "O";
				 reason = "單價異常處理放行";
				 break;
			 case "2048" :
				 unitCode = "J";
				 reason = "單價異常處理拒絕退回";
				 break;
			 case "4096" :
				 unitCode = "E";
				 reason = "訂單不存在";
				 break;
			 case "8192" :
				 unitCode = "F";
				 reason = "驗收單數量總和超過訂購物數量";
				 break;
			 case "16384" :
				 unitCode = "W";
				 //reason = "";
				 break;
			 case "32768" :
				 unitCode = "I";
				 reason = "醫院自行付款單據重驗後不需上傳連夠網";
				 break;
			 }
			 
			 if (signFlag.equals("true")) {
				 reason = "，"+reason;
			 }
			 
			 exceptionID = exceptionID + reason;
			 signFlag = "true";
			 
		 }
		 return exceptionID;
		 
	 }
	
	
	
	

}
