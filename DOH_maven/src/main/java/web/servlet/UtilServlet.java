package web.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.common.base.Throwables;

import internal.server.util.DefaultValues;
import web.db.DocumentDB;
import web.db.PartnerDB;
import web.util.Vars;

@SuppressWarnings("deprecation")
@WebServlet("/UtilServlet")
public class UtilServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = LogManager.getLogger(DefaultValues.apLog);
	
	public UtilServlet() {
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
			case "checkSession":
				CheckSession(request, response);
				break;
			case "FieldType":
				fieldTypeList(request, response);
				break;
			case "Partner":
				PartnerList(request, response);
				break;
			case "DocumentType":
				DocTypeList(request, response);
				break;
			case "FolderFileList":
				getFileList(request, response);
				break;
			case "DeliveryType":
				getDeliveryType(request, response);
				break;
			case "Protocol":
				getProtocol(request, response);
				break;
		}
	}
	
	protected void CheckSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		if (session == null || session.getAttribute(Vars.Account) == null) {
			out.print("session doesn't exist");		
		} else {
			out.print("session exist");
		}
	}
	
	private void fieldTypeList(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("utf-8");
				
		PrintWriter out = response.getWriter();
		PartnerDB partnerDB = new PartnerDB();
		
		try {
			
			JSONArray jsonArray = partnerDB.fieldTypeList();
			response.setContentType("text/json");
			out.print(jsonArray);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));  		
		}
	}
	
	private void PartnerList(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("utf-8");		
		
		PrintWriter out = response.getWriter();
		PartnerDB partnerDB = new PartnerDB();
		
		try {
			JSONArray jsonArray = partnerDB.getAllPartner();
			response.setContentType("text/json");
			out.print(jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e)); 	
		}
	}
	
	private void DocTypeList(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("utf-8");
		
		
		PrintWriter out = response.getWriter();
		DocumentDB documentDB = new DocumentDB();
		
		try {
			JSONArray jsonArray = documentDB.getDocumentTypeTable();
			response.setContentType("text/json");
			out.print(jsonArray);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e)); 			
		}
	}
	
	@SuppressWarnings("unchecked")
	private void getFileList(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("utf-8");
		
		
		PrintWriter out = response.getWriter();
		String serverPath = System.getProperty("catalina.base");
		String os = System.getProperty("os.name");
		String address = "" ;
		
		if(os.toLowerCase().indexOf("windows") == -1) {
			address = serverPath + "/webapps/DOH_maven/WEB-INF/classes/internal/xml/util/";
		}else {
			address = serverPath + "\\webapps\\DOH_maven\\WEB-INF\\classes\\internal\\xml\\util\\";
		}
		
		List<Object> arr = new ArrayList<>();
		List<Object> num = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		JSONArray jsonArray = new JSONArray();
		
		//System.out.println(this.getServletContext().getRealPath("service/"));
		System.out.println(address);
		
		try (Stream<Path> paths = Files.walk(Paths.get(address))) {
			
			paths.filter(Files::isRegularFile).forEach(arr::add);
			
			for (int i=0; i<arr.size(); i++) {
				arr.set(i,arr.get(i).toString().replace(address, ""));
				num.add("file");
			}
			
			for (int i=0; i<arr.size(); i++) {
				map.put(num.get(i).toString(), arr.get(i).toString());				
				
				JSONObject jsonObject = new JSONObject();
				jsonObject.putAll(map);
				jsonArray.add(jsonObject);
			}
				
			response.setContentType("text/json");
			out.print(jsonArray);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e)); 			
		}
	}
	
	private void getDeliveryType(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("utf-8");		
		
		PrintWriter out = response.getWriter();
		PartnerDB partnerDB = new PartnerDB();
		
		try {
			JSONArray jsonArray = partnerDB.getType();
			response.setContentType("text/json");
			out.print(jsonArray);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e)); 					
		}
	}
	
	private void getProtocol(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("utf-8");		
		
		PrintWriter out = response.getWriter();
		PartnerDB partnerDB = new PartnerDB();
	
		try {
			JSONArray jsonArray = partnerDB.getProtocol();
			response.setContentType("text/json");
			out.print(jsonArray);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e)); 			
		}
	}
	
	private String getParameter(HttpServletRequest request, String input) {
		
		String output = request.getParameter(input);;
		if (output == null) {
			output = "";
		} 
			
		return output;
	}
}