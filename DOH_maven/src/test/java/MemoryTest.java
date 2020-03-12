

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import internal.server.util.DefaultValues;

/**
 * Servlet implementation class MemoryTest
 */
@WebServlet("/MemoryTest")
public class MemoryTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LogManager.getLogger(DefaultValues.serverLog);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemoryTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub3
		int MEGABYTE = (1024*1024);
		
		MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
		
        
		int iteratorValue = 20;
		for (int i = 1; i < 200; i++) {
				        
			try {
				
				MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
		        long maxMemory = heapUsage.getMax() / MEGABYTE;
		        long usedMemory = heapUsage.getUsed() / MEGABYTE;
				logger.info(i+ " : Memory Use :" + usedMemory + "M/" + maxMemory + "M");
				System.out.println("Iteration " + i + " Free Mem: " + Runtime.getRuntime().freeMemory() / MEGABYTE);
				
				byte[] b = new byte[500];
				int loop1 = 2;
				int[] memoryFillIntVar = new int[iteratorValue];
				// feel memoryFillIntVar array in loop..
				do {
					memoryFillIntVar[loop1] = 0;
					loop1--;
				} while (loop1 > 0);
				
				iteratorValue = iteratorValue + 50000000;
				
				
				
				Thread.sleep(3000);
				
			} catch (Exception e) {
	            e.printStackTrace();
	        } 
			
			
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
