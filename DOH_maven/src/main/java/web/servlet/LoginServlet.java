package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Throwables;

import internal.server.util.DefaultValues;
import web.db.UserDB;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = LogManager.getLogger(DefaultValues.apLog); 
	
	public LoginServlet() {
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
	
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();			
		
		try {			
			String Account = request.getParameter("userid");
			String Password = request.getParameter("password");
					
			UserDB userDB = new UserDB();			
		
			Map<String, String> userInfoMap = userDB.loginSQL(Account, Password);
			
			if (userInfoMap.isEmpty()) {
				out.print("access dinied");
			} else {				
				
				for (String key : userInfoMap.keySet()) {
					session.setAttribute(key, userInfoMap.get(key));
					logger.debug(key + ": " + session.getAttribute(key) + "\t\t");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Throwables.getStackTraceAsString(e));
			response.setStatus(500);	
			out.print(e.getMessage());
		}
	}
}