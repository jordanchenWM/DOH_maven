package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;

import com.google.common.base.Throwables;

import internal.server.util.DefaultValues;
import web.db.PartnerDB;
 
@SuppressWarnings("deprecation")
@WebServlet("/PartnerServlet")
public class PartnerServlet extends HttpServlet{

	private Logger logger = LogManager.getLogger(DefaultValues.apLog);
	
	private static final long serialVersionUID = 1L;
	
	
	public PartnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = getParameter(request, "method");
		switch(method){
		case "PartnerTable":
			getPartnerTable(request, response);
			break;
		case "partner_add":
			addPartner(request, response);
			break;
		case "partner_edit":
			editPartner(request, response);
			break;
		case "partner_delete":
			deletePartner(request, response);
			break;
		case "Detail":
			getDetailTable(request, response);
			break;
		case "Detail_delete":
			deletePartnerDetail(request, response);
			break;
		case "newType":
			type_add(request, response);
			break;
		case "newDetail":
			detail_add(request, response);
			break;
		case "checkDetail":
			checkDetail(request, response);
			break;
		case "detail_edit":
			detail_edit(request, response);
			break;
		case "checkType":
			checkType(request, response);
			break;
		case "PartnerOne":
			onePartner(request, response);
			break;
		case "Delivery_add":
			delivery_add(request, response);
			break;
		case "getDelivery":
			getDelivery(request, response);
			break;
		case "getEditDeliveyInfo":
			getOneDelivery(request, response);
			break;
		case "delete_delivery":
			deleteDelivery(request, response);
			break;
		case "Delivery_edit":
			delivery_edit(request, response);
			break;
		case "getPreferred":
			getPreferred(request, response);
			break;
		case "checkDelivery" :
			checkMethods(request, response);
			break;
		}
	}
	
	protected void getPartnerTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			PartnerDB panDB = new PartnerDB();
			
			jsonArray = panDB.getPartnerTable();

			response.setContentType("text/json");	
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void addPartner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		Connection conn = null ;
		try {
			PartnerDB panDB = new PartnerDB();
			String key = "" ;
			String Partner_ID = UUID.randomUUID().toString();
			String Corporation_Name = getParameter(request, "Corporation_Name");
			String OrgUnit_Name = getParameter(request, "OrgUnit_Name");
			String Status = getParameter(request, "Status");
			String field = getParameter(request, "field");
			String val = getParameter(request, "val");
			String detail_num = getParameter(request, "detail_num");
			
			if(field != "" && val != "") {
				key = "addPartner";
			}
			
			List<String> al = new ArrayList<String>();
			
			for(int i=0;i<Integer.valueOf(detail_num);i++) {
				al.add(getParameter(request, "field"+(i+1)));
				al.add(getParameter(request, "val"+(i+1)));
				System.out.println(i+1);
			}
			
			conn = panDB.add_Partner(Partner_ID, Corporation_Name, OrgUnit_Name, Status, key, conn);
			if(key == "addPartner") {
				panDB.add_Detail(Partner_ID, field, val, al, key, conn);
			}

			response.setContentType("text/json");	
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void editPartner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			PartnerDB panDB = new PartnerDB();
			
			String Partner_ID = getParameter(request, "PartnerID");
			String Corporation_Name = getParameter(request, "Corporation_Name");
			String OrgUnit_Name = getParameter(request, "OrgUnit_Name");
			String Status = getParameter(request, "Status");
			
			panDB.edit_Partner(Partner_ID, Corporation_Name, OrgUnit_Name, Status);

			response.setContentType("text/json");	
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void deletePartner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		try {
			PartnerDB panDB = new PartnerDB();
			
			String Partner_ID = getParameter(request, "PartnerID");
			
			panDB.delete_PartnerDetil(Partner_ID);
			panDB.delete_Partner(Partner_ID);
			
			getPartnerTable(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void deletePartnerDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");	
		
		PrintWriter out = response.getWriter();
		
		try {
			PartnerDB panDB = new PartnerDB();
			
			String FieldID = getParameter(request, "FieldID");
			
			panDB.delete_PartnerDetail(FieldID);
			
			getDetailTable(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void getDetailTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			PartnerDB panDB = new PartnerDB();
			
			String PartnerID = getParameter(request, "PartnerID");
			
			jsonArray = panDB.getDetailTable(PartnerID);

			response.setContentType("text/json");	
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void type_add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			PartnerDB panDB = new PartnerDB();
			
			String typeName = getParameter(request, "typeName");
			
			panDB.add_FieldType(typeName);

			response.setContentType("text/json");	
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void detail_add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");	
		
		PrintWriter out = response.getWriter();
		Connection conn = null;
		JSONArray jsonArray = new JSONArray();
		List<String> defaultList = new ArrayList<String>();
				
		try {
			PartnerDB panDB = new PartnerDB();
			String key = "newDetail";
			String field_name  = getParameter(request, "field_name");
			String field_val  = getParameter(request, "field_val");
			String hidePartnerID  = getParameter(request, "hidePartnerID");
			
			panDB.add_Detail(hidePartnerID, field_name, field_val, defaultList, key, conn); 

			response.setContentType("text/json");
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void detail_edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");	
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			PartnerDB panDB = new PartnerDB();
			String field_name  = getParameter(request, "field_name");
			String field_val  = getParameter(request, "field_val");
			String FieldID  = getParameter(request, "FieldID");
			
			panDB.edit_Detail(FieldID, field_name, field_val); 
			
			response.setContentType("text/json");
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void checkDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json");	
		
		PrintWriter out = response.getWriter();
		
		try {
			PartnerDB panDB = new PartnerDB();
			
			String col1 = getParameter(request, "col1");
			String col2 = getParameter(request, "col2");
			
			Boolean isDuplicate = panDB.isDuplicateDetail(col1, col2);
			
			out.println(isDuplicate);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void checkType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json");	
		
		PrintWriter out = response.getWriter();
		
		try {
			PartnerDB panDB = new PartnerDB();
			
			String typeName = getParameter(request, "typeName");
			
			Boolean isDuplicate = panDB.isDuplicateType(typeName);
			
			out.println(isDuplicate);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void onePartner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		try {
			PartnerDB panDB = new PartnerDB();
			
			String ID = getParameter(request, "ID");
			
			jsonArray = panDB.getOnePartner(ID);

			response.setContentType("text/json");	
			out.println(jsonArray);
			 
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void delivery_add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			PartnerDB panDB = new PartnerDB();
			String delivery_method  = getParameter(request, "delivery_method");
			String PartnerID = getParameter(request, "PartnerID");
			String host  = getParameter(request, "host");
			String port  = getParameter(request, "port");
			String location  = getParameter(request, "location");
			String user_name  = getParameter(request, "user_name");
			String password  = getParameter(request, "password");
			String preferred  = getParameter(request, "preferred");
			
			if(preferred.equals("true")) {
				panDB.setPreferred(PartnerID);
			}
			
			panDB.add_delivery(PartnerID, delivery_method, host, port, location, user_name, password, preferred); 

			response.setContentType("text/json");	
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void getDelivery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");	
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		try {
			PartnerDB panDB = new PartnerDB();
			
			String PartnerID = getParameter(request, "PartnerID");
			
			jsonArray = panDB.getDelivery(PartnerID);

			response.setContentType("text/json");
			out.println(jsonArray);
			 
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}

	protected void getOneDelivery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");	
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			PartnerDB panDB = new PartnerDB();
			
			String deliveryID = getParameter(request, "deliveryID");
			
			jsonArray = panDB.getOneDelivery(deliveryID);

			response.setContentType("text/json");
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void deleteDelivery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");	
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			PartnerDB panDB = new PartnerDB();
			
			String deliveryID = getParameter(request, "deliveryID");
			
			panDB.delete_Delivery(deliveryID);

			response.setContentType("text/json");
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void delivery_edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");	
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			PartnerDB panDB = new PartnerDB();
			
			String deliveryID = getParameter(request, "HideDeliveryID");
			String PartnerID = getParameter(request, "PartnerID");
			String host  = getParameter(request, "host");
			String port  = getParameter(request, "port");
			String location  = getParameter(request, "location");
			String user_name  = getParameter(request, "user_name");
			String password  = getParameter(request, "password");
			String preferred  = getParameter(request, "preferred");
			
			if(preferred.equals("true")) {
				panDB.setPreferred(PartnerID);
			}
			
			panDB.edit_Delivery(deliveryID, host, port, location, user_name, password, preferred); 

			response.setContentType("text/json");
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void getPreferred(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");	
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			PartnerDB panDB = new PartnerDB();
			
			String PartnerID = getParameter(request, "PartnerID");
			
			jsonArray = panDB.getPreferred(PartnerID);

			response.setContentType("text/json");
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void checkMethods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");	
		
		PrintWriter out = response.getWriter();
		
		try {
			PartnerDB panDB = new PartnerDB();
			
			String delivery_method = getParameter(request, "delivery_method");
			String PartnerID = getParameter(request, "partnerID");
			
			Boolean isDuplicate = panDB.isDuplicateDelivery(delivery_method, PartnerID);

			response.setContentType("text/json");
			out.println(isDuplicate);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}

	private String getParameter(HttpServletRequest request, String input) {
			
			String output = request.getParameter(input);
			if (output == null) {
				output = "";
			} 
				
			return output;
	}

}