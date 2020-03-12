package internal.tn.main;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import internal.db.dao.frame.IBizDocContent;
import internal.db.util.DBInjector;

/**
 * Servlet implementation class DocResubmit
 */
@WebServlet("/DocResubmit")
public class DocResubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocResubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			
			ReceiveFlow flow = DBInjector.getInstance(ReceiveFlow.class);		
			IBizDocContent cont = DBInjector.getInstance(IBizDocContent.class);
			
			Map<String, String> dataMap = cont.selectOne("048530f4-6c36-440c-83ba-bd35edf59e13");
			
			String content = dataMap.get(IBizDocContent.content);
			String partName = dataMap.get(IBizDocContent.partName);
		
		
			flow.start(content, partName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
