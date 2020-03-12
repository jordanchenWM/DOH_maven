package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
import web.db.UserDB;
@SuppressWarnings("deprecation")
@WebServlet("/UserManagementServlet")
public class UserManagementServlet extends HttpServlet{

	private Logger logger = LogManager.getLogger(DefaultValues.apLog);
	
	private static final long serialVersionUID = 1L;
	
	
	public UserManagementServlet() {
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
			case "UserTable":
				getContentTable(request, response);
				break;
			case "user_add":
				add_user(request, response);
				break;
			case "user_delete":
				user_delete(request, response);
				break;
			case "User_edit":
				user_edit(request, response);
				break;
			case "User_check":
				user_check(request, response);
				break;
		}
	}
	
	protected void getContentTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			UserDB userDB = new UserDB();
			
			jsonArray = userDB.getUserTable();
			
			response.setContentType("text/json");	
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void add_user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json");	
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			UserDB userDB = new UserDB();
			String account = getParameter(request, "account");
			String Password = getParameter(request, "Password");
			String Frist_Name = getParameter(request, "Frist_Name");
			String Last_Name = getParameter(request, "Last_Name");
			String Mail = getParameter(request, "Mail");
			String Role = getParameter(request, "Role");
			String Phone = getParameter(request, "Phone");
			userDB.add_user(account, Password, Frist_Name, Last_Name, Mail, Role, Phone);
			
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}

	protected void user_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json");	
		
		PrintWriter out = response.getWriter();
		
		try {
			UserDB userDB = new UserDB();
			String account = getParameter(request, "account");
			
			userDB.user_delete(account);
			
			getContentTable(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}

	protected void user_edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");	
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			UserDB userDB = new UserDB();
			String account = getParameter(request, "account");
			String Password = getParameter(request, "Password");
			String Frist_Name = getParameter(request, "Frist_Name");
			String Last_Name = getParameter(request, "Last_Name");
			String Mail = getParameter(request, "Mail");
			String Role = getParameter(request, "Role");
			String Phone = getParameter(request, "Phone");
			userDB.user_Edit(account, Password, Frist_Name, Last_Name, Mail, Role, Phone);
			
			response.setContentType("text/html");
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void user_check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		try {
			Boolean isDuplicate = null;
					
			String Name = getParameter(request, "Name");
			
			UserDB userDB = new UserDB();
			
			isDuplicate = userDB.check_user(Name);

			response.setContentType("text/json");	
			out.print(isDuplicate);
			
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