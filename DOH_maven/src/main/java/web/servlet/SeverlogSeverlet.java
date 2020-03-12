package web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Throwables;

@WebServlet("/SeverlogSeverlet")
public class SeverlogSeverlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public SeverlogSeverlet() {
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
		//request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");	
		
		try {
			String serverPath = System.getProperty("catalina.home");
			
			//response.setContentType("text/json");
			//response.setCharacterEncoding("utf-8");	
			
			//LoadFile loadFile = new LoadFile();		
			//ArrayList<String> log = loadFile.Load(serverPath + "/logs/DOH/server.log");
			//String serverPath = "/Users/guofeng/Desktop";
			File file = new File(serverPath + "/logs/DOH/server.log");
			List<String> log = FileUtils.readLines(file, "utf-8");
			
			String sequence = request.getParameter("sequence");
			String first_line = request.getParameter("first_line");
			String number = request.getParameter("display_number");
			
			String logString = "";
			int num =  Integer.parseInt(number);
			int first =  Integer.parseInt(first_line);
			int size = log.size();
		
			if(first>size) {
				first=size-1;
			}
			
			if(num>size) {
				num=size-1;
			}
			
			switch (sequence) {
				case "Descending":
					
					if(first == 0) {
						
						for(int i=(size-1);i>=(size-num);i--){
							
							logString += "<tr><td>" + "[" + i + "] " + log.get(i) + "</td></tr>" ;
						}
					}else {
						
						for(int i=first;i>=(first-num);i--){
							logString += "<tr><td>" + "[" + i + "]  " + log.get(i) + "</td></tr>" ;
							if(i==1) {
								break;
							}
						}
					}
					
					break;
			
				case "Ascending":
					if(first == 0) {
						
						for(int i=1;i<=num;i++){
							
							logString += "<tr><td>" +"[" + i + "]  " + log.get(i) + "</td></tr>" ;
						}
					}else {
						
						for(int i=first;i<=(first+num);i++){
							
							logString += "<tr><td>" +"[" + i + "]  " + log.get(i) + "</td></tr>" ;
							if(i==(size-1)) {
								break;
							}
						}
					}
					
					break;
			}
			
			response.setContentType("text/json");
			out.print(logString);
			
		} catch (Exception e) {
			response.setStatus(500);
			out.println(Throwables.getStackTraceAsString(e));
		}
				
		
	}
	
}
