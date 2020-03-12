package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.reflections.Reflections;

import service.IService;

/**
 * Servlet implementation class ServiceList
 */
@WebServlet("/ServiceList")
@SuppressWarnings("deprecation")
public class ServiceList extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		
		Reflections reflections = new Reflections("service");    
		Set<Class<? extends IService>> classes = reflections.getSubTypesOf(IService.class);
		
		

		List<String> classNames = new ArrayList<>();
		for (Class<?> c : classes) {
			//System.out.println(c.getCanonicalName());
			classNames.add(c.getCanonicalName());
		}
		List<String> sorted_classNames = classNames.stream().collect(Collectors.toList());
		for (String name : sorted_classNames) {
			System.out.println(name);
			//classNames.add(c.getCanonicalName());
		}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");		
		PrintWriter out = response.getWriter();
		
		Reflections reflections = new Reflections("service");    
		Set<Class<? extends IService>> classes = reflections.getSubTypesOf(IService.class);
		
		
		List<String> classNames = new ArrayList<>();
		for (Class<?> c : classes) {
			classNames.add(c.getCanonicalName());
		}
		Collections.sort(classNames);
		
		JSONArray jsonArray = new JSONArray();
		Map<String, String> map = new HashMap<>();
		for (String name : classNames) {
			System.out.println(name);
			map.put("service", name);
			JSONObject jsonObject = new JSONObject();
			jsonObject.putAll(map);
			jsonArray.add(jsonObject);
		}
		response.setContentType("text/json");
		out.println(jsonArray);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
