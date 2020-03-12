package web.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.util.LoadFile;


@WebServlet("/ConfigServlet")
public class ConfigServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ConfigServlet() {
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
	
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");	
		PrintWriter out = response.getWriter();
		System.out.println(this.getServletContext().getRealPath("WEB-INF/classes/config/db.conf"));
		String configAddress = this.getServletContext().getRealPath("WEB-INF/classes/config/db.conf");
		//String configAddress = "/Users/guofeng/db.conf" ;
		String configString = "";
		String ConfigContent = request.getParameter("ConfigContent");
		String method = request.getParameter("method");
		System.out.println(method);
		System.out.println(ConfigContent);
		
		if(method.equals("save")) {
			File configfile=new File(configAddress);
			try {
				FileWriter wre =new FileWriter(configfile);
				wre.write(ConfigContent);
				wre.flush();
				wre.close();
			 
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		LoadFile loadFile = new LoadFile();
		ArrayList<String> config = loadFile.Load(configAddress);
		
		for(int i=0;i<=config.size()-1;i++){
			
			configString += config.get(i) + "\n" ;
		}
	
		
		out.print(configString);
	}
}