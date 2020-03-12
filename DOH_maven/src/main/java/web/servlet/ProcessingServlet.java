package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import web.db.ProcessingDB;

@SuppressWarnings("deprecation")
@WebServlet("/ProcessingServlet")
public class ProcessingServlet extends HttpServlet{

	private Logger logger = LogManager.getLogger(DefaultValues.apLog);
	
	private static final long serialVersionUID = 1L;
	
	
	public ProcessingServlet() {
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
		case "getProcessingTable":
			getProcessingTable(request, response);
			break;
		case "delete":
			delete_rule(request, response);
			break;
		case "Rule_add":
			add_rule(request, response);
			break;
		case "Rule_edit":
			edit_rule(request, response);
			break;
		case "now":
			edit_rule(request, response);
			break;
		}
	}
	
	protected void getProcessingTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json");	
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			ProcessingDB processingDB = new ProcessingDB();
			
			jsonArray = processingDB.getProcessingRuleTable();
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void delete_rule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			String RuleID = getParameter(request, "RuleID");
			
			ProcessingDB processingDB = new ProcessingDB();
			
			processingDB.delete_rule(RuleID);

			getProcessingTable(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void add_rule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");	
		PrintWriter out = response.getWriter();
		
		try {
			String RuleID = UUID.randomUUID().toString();
			String RuleName = getParameter(request, "RuleName");
			String RuleDescription = getParameter(request, "RuleDescription");
			String SenderID = getParameter(request, "SenderID");
			String ReceiveID = getParameter(request, "ReceiveID");
			String DocTypeID = getParameter(request, "DocTypeID");
			String Service = getParameter(request, "Service");
			String Rule_Enable = getParameter(request, "Rule_Enable");
			
			ProcessingDB processingDB = new ProcessingDB();
			
			int newIndex = processingDB.newIndex()+1 ;
			
			processingDB.add_rule(RuleID, RuleName, RuleDescription, SenderID, ReceiveID, DocTypeID, Service, Rule_Enable, newIndex);
			
			getProcessingTable(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void edit_rule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try {
			String hideID = getParameter(request, "hideID");
			String RuleName = getParameter(request, "RuleName");
			String RuleDescription = getParameter(request, "RuleDescription");
			String SenderID = getParameter(request, "SenderID");
			String ReceiveID = getParameter(request, "ReceiveID");
			String DocTypeID = getParameter(request, "DocTypeID");
			String Service = getParameter(request, "Service");
			String Rule_Enable = getParameter(request, "Rule_Enable");
			String RuleIndex = getParameter(request, "RuleIndex");
			String hideIndex = getParameter(request, "hideIndex");
			
			ProcessingDB processingDB = new ProcessingDB();
			int newIndex = processingDB.newIndex() ;
			
			if(Integer.parseInt(RuleIndex) > newIndex) {
				RuleIndex = String.valueOf(newIndex) ;
			}
			
			if(!RuleIndex.equals(hideIndex)) {
				System.out.println("IndexOrder");
				processingDB.index_order(RuleIndex, hideIndex);
			}
			
			processingDB.edit_rule(hideID, RuleName, RuleDescription, SenderID, ReceiveID, DocTypeID, Service, Rule_Enable, RuleIndex);
			
			getProcessingTable(request, response);
			
		}catch(Exception e) {
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