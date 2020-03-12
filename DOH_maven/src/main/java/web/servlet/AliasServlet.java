package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;

import com.google.common.base.Throwables;


import internal.server.util.DataSourceManager;
import internal.server.util.DefaultValues;
import web.db.AliasDB;

@SuppressWarnings("deprecation")
@WebServlet("/AliasServlet")
public class AliasServlet extends HttpServlet{

	private Logger logger = LogManager.getLogger(DefaultValues.apLog);
	
	private static final long serialVersionUID = 1L;
	
	public AliasServlet() {
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
			case "AliasTable":
				getAliasTable(request, response);
				break;
			case "test_conn" :
				testConnect(request, response);
				break;
			case "delete_alias":
				delete_alias(request, response);
				break;
			case "JBDC_add":
				add_alias(request, response);
				break;
			case "JDBC_edit":
				edit_alias(request, response);
				break;
			case "checkJBDC":
				checkJBDC(request, response);
				break;
			case "enable_Alias":
				change_enabled(request, response);
				break;
		}
	}
	
	protected void getAliasTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonarray = new JSONArray();
		try {
			AliasDB aliasDB = new AliasDB();
			
			jsonarray = aliasDB.getAliasTable();

			response.setContentType("text/json");	
			out.print(jsonarray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	@SuppressWarnings("unused")
	protected void testConnect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonarray = new JSONArray();
		try {
			String URL = getParameter(request, "URL");
			String Account = getParameter(request, "Account");
			String Password = getParameter(request, "Password");
			String Driver = getParameter(request, "Driver");
			//String DataSource_class = getParameter(request, "DataSource_class");
			
			Connection conn = null;
			
			if(Driver.equals("Oracle")) {
				Class.forName("oracle.jdbc.OracleDriver");
			}else if(Driver.equals("SQL_Server")) {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			}else if(Driver.equals("Sybase")) {
				Class.forName("com.sybase.jdbc4.jdbc.SybDriver");
			}
			//Class.forName(DataSource_class);

			response.setContentType("text/html");	
			conn = DriverManager.getConnection(URL,Account,Password);
			
			out.print("Connection Test Success!");
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void delete_alias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		try {
			String Alias_Name = getParameter(request, "Alias_Name");
			
			AliasDB aliasDB = new AliasDB();
			aliasDB.delete_alia(Alias_Name);
			
			getAliasTable(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void add_alias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonarray = new JSONArray();
		try {
			String Alias_Name = getParameter(request, "Alias_Name");
			String Alias_Description = getParameter(request, "Alias_Description");
			String Account = getParameter(request, "Account");
			String Password = getParameter(request, "Password");
			String DataSource_class = "";
			String Driver = getParameter(request, "Driver");
			String URL = getParameter(request, "URL");
			String Pooling_Enable = getParameter(request, "Pooling_Enable");
			String MaxPoolSize = getParameter(request, "MaxPoolSize");
			String MinPoolSize = getParameter(request, "MinPoolSize");
			String Block_Timeout = getParameter(request, "Block_Timeout");
			String Expire_Timeout = getParameter(request, "Expire_Timeout");
			String Startup_Timeout = getParameter(request, "Startup_Timeout");
			
			if(MaxPoolSize.equals("")) {
				MaxPoolSize = "0";
			}
			
			if(Driver.equals("Oracle")) {
				DataSource_class = "oracle.jdbc.OracleDriver" ;
			}else if(Driver.equals("SQL_Server")) {
				DataSource_class = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
			}else if(Driver.equals("MySQL")) {
				DataSource_class = "com.mysql.cj.jdbc.Driver" ;
			}else if(Driver.equals("Sybase")) {
				DataSource_class = "com.sybase.jdbc4.jdbc.SybDriver" ;
			}
			
			AliasDB aliasDB = new AliasDB();
			aliasDB.add_alia(Alias_Name, Alias_Description, Account, Password, DataSource_class, Driver, URL, 
					Pooling_Enable, MaxPoolSize, MinPoolSize, Block_Timeout, Expire_Timeout, Startup_Timeout);

			response.setContentType("text/json");
			out.println(jsonarray);
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void edit_alias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonarray = new JSONArray();
		try {
			String Alias_Name = getParameter(request, "Alias_Name");
			String HideName = getParameter(request, "HideName");
			String Alias_Description = getParameter(request, "Alias_Description");
			String Account = getParameter(request, "Account");
			String Password = getParameter(request, "Password");
			String DataSource_class = "";
			String Driver = getParameter(request, "Driver");
			String URL = getParameter(request, "URL");
			String Pooling_Enable = getParameter(request, "Pooling_Enable");
			String MaxPoolSize = getNumParameter(request, "MaxPoolSize");
			String MinPoolSize = getNumParameter(request, "MinPoolSize");
			String Block_Timeout = getNumParameter(request, "Block_Timeout");
			String Expire_Timeout = getNumParameter(request, "Expire_Timeout");
			String Startup_Timeout = getNumParameter(request, "Startup_Timeout");
			
			if(Driver.equals("Oracle")) {
				DataSource_class = "oracle.jdbc.OracleDriver" ;
			}else if(Driver.equals("SQL_Server")) {
				DataSource_class = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
			}else if(Driver.equals("MySQL")) {
				DataSource_class = "com.mysql.cj.jdbc.Driver" ;
			}else if(Driver.equals("Sybase")) {
				DataSource_class = "net.sourceforge.jtds.jdbc.Driver" ;
			}
			
			AliasDB aliasDB = new AliasDB();
			aliasDB.edit_alia(Alias_Name, Alias_Description, Account, Password, DataSource_class, Driver, URL, 
					Pooling_Enable, MaxPoolSize, MinPoolSize, Block_Timeout, 
					Expire_Timeout, Startup_Timeout, HideName);

			response.setContentType("text/json");	
			out.println(jsonarray);
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void checkJBDC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json");	
		
		PrintWriter out = response.getWriter();
		try {
			Boolean isDuplicate = null;
					
			String Name = getParameter(request, "Name");
			String hideName = getParameter(request, "hideName");
			
			AliasDB aliasDB = new AliasDB();
			
			if(Name.equals(hideName)) {
				isDuplicate = false;
			}else {
				isDuplicate = aliasDB.check_alia(Name);
			}
			
			out.print(isDuplicate);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void change_enabled(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json");	
		
		PrintWriter out = response.getWriter();
		try {
			
			String alias_Name = getParameter(request, "Alias_Name");
			String disabled = getParameter(request, "Disabled");
			String useUpdate = "";
			
			if (disabled.equals("0")) {
				useUpdate = "1";
				DataSourceManager.disable(alias_Name);
			} else {
				useUpdate = "0";
				DataSourceManager.enable(alias_Name);
			}
			
			AliasDB aliasDB = new AliasDB();
			aliasDB.enabled_change(alias_Name, useUpdate);
			
			getAliasTable(request, response);
			
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
	
	private String getNumParameter(HttpServletRequest request, String input) {
		
		String output = request.getParameter(input);;
		if (output == null || output.equals("")) {
			output = "0";
		} 
			
		return output;
	}
}