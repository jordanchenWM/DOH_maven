package internal.server.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import internal.server.util.DefaultValues;
import internal.tn.FormatException;
import internal.tn.ReceiveFlow;



/**
 * Servlet implementation class Inbound
 */
@WebServlet("/inbound")
public class Inbound extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Logger logger = LogManager.getLogger(DefaultValues.serverLog);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inbound() {
        super();        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");		
							
		String contentType = request.getContentType();
		String content = IOUtils.toString(request.getReader());
				
		logger.debug("inbound receive contentType: " + contentType);
				
		//--------- try to extract info from doc-------------	
		ReceiveFlow flow = new ReceiveFlow();
		
		try {
			flow.start(content, contentType);
		} catch (FormatException e) {
			e.printStackTrace();
			response.setStatus(400);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
		} 
			
	}

}
