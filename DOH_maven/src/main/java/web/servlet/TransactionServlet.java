package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;

import com.google.common.base.Throwables;


import internal.db.dao.frame.IBizDocContent;
import internal.db.util.DBInjector;
import internal.server.util.DefaultValues;
import internal.tn.ReceiveFlow;
import web.db.TransactionDB;

@WebServlet("/TransactionServlet")
@SuppressWarnings("deprecation")
public class TransactionServlet extends HttpServlet{

	private Logger logger = LogManager.getLogger(DefaultValues.apLog);
	
	private static final long serialVersionUID = 1L;
	
	
	public TransactionServlet() {
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
		case "BizDocTable":
			getBizDocTable(request, response);
			break;
		case "ActivityTable":
			getActivityTable(request, response);
			break;
		case "BizDocContentTable":
			getBizDocContentTable(request, response);
			break;
		case "ActivityFullMessageTable":
			getActivityFullMessageTable(request, response);
			break;
		case "ContentTable":
			getContentTable(request, response);
			break;
		case "transaction_purge":
			purge(request, response);
			break;
		case "resummit":
			resubmmit(request, response);
			break;
		}
	}
	
	protected void getBizDocTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			TransactionDB tranDB = new TransactionDB();
			
			String start_date = getParameter(request, "start_date");
			String end_date = getParameter(request, "end_date");
			
			jsonArray = tranDB.getBizDocTable(start_date, end_date);

			response.setContentType("text/json");
			out.println(jsonArray);
			
		} catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void getActivityTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			TransactionDB tranDB = new TransactionDB();
			
			String DocTypeID = getParameter(request, "DocTypeID");
			String DocID = getParameter(request, "DocID");
			
			jsonArray = tranDB.getActivityTable(DocID, DocTypeID);
			
			response.setContentType("text/json");
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void getBizDocContentTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			TransactionDB tranDB = new TransactionDB();
			String DocID = getParameter(request, "DocID");
			//JPEGImageEncoder img = new JPEGImageEncoder();
			
			jsonArray = tranDB.getBizDocContentTable(DocID);
			
			response.setContentType("text/json");
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void getActivityFullMessageTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json");	
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			TransactionDB tranDB = new TransactionDB();
			
			String ActivityLogID = getParameter(request, "ActivityLogID");
			
			jsonArray = tranDB.getActivityFullMessageTable(ActivityLogID);
			
			response.setContentType("text/json");
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}

	protected void getContentTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json");	
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			TransactionDB tranDB = new TransactionDB();
			
			String DocID = getParameter(request, "DocID");
			String PartName = getParameter(request, "PartName");
			
			jsonArray = tranDB.getContentTable(DocID, PartName);
			
			response.setContentType("text/json");
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void purge(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json");	
		JSONArray jsonArray = new JSONArray();
		PrintWriter out = response.getWriter();
		Connection conn = null;
		TransactionDB tranDB = new TransactionDB();
		int execute_order = 0; 
		
		try {
			String start_day = getParameter(request, "start_day");
			int size = Integer.parseInt(getParameter(request, "size"));
			
			execute_order = tranDB.purge_order(start_day);
			
			for(int i=0;i<=execute_order/size;i++) {
				tranDB.purge(start_day, size, conn);
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
	
	protected void resubmmit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		JSONArray jsonArray = new JSONArray();
		PrintWriter out = response.getWriter();
		
		IBizDocContent cont = DBInjector.getInstance(IBizDocContent.class);
		
		try {
			String[] checkboxs = request.getParameterValues("checkboxs[]");
			
			for (String id : checkboxs) {
				
				System.out.println(id);
				
				Map<String, String> dataMap = cont.selectOne(id);
				
				String content = dataMap.get(IBizDocContent.content);
				String partName = dataMap.get(IBizDocContent.partName);
				
				try {
					ReceiveFlow flow = new ReceiveFlow();	
					flow.start(content, partName);
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
			}
			
			response.setContentType("text/json");
			out.println(jsonArray);
		} catch(Exception e) {
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