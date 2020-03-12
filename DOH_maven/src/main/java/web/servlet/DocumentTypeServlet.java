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
import web.db.DocumentDB;

@SuppressWarnings("deprecation")
@WebServlet("/DocumentTypeServlet")
public class DocumentTypeServlet extends HttpServlet{

	private Logger logger = LogManager.getLogger(DefaultValues.apLog);
	
	private static final long serialVersionUID = 1L;
	
	
	public DocumentTypeServlet() {
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
		case "DocumentTypeTable":
			getDocumentTypeTable(request, response);
			break;
		case "Document_add":
			add_documentType(request, response);
			break;
		case "documentType_delete":
			delete_documentType(request, response);
			break;
		case "Document_edit":
			edit_documentType(request, response);
			break;
		case "checkDocumentExist":
			checkDocumentType(request, response);
			break;
		}
	}
	
	protected void getDocumentTypeTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			DocumentDB documentDB = new DocumentDB();
			
			jsonArray = documentDB.getDocumentTypeTable();
			
			response.setContentType("text/json");
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}

	protected void add_documentType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			DocumentDB documentDB = new DocumentDB();
			
			String TypeName = getParameter(request, "type_name");
			String TypeDescription = getParameter(request, "TypeDescription");
			String Status = getParameter(request, "Status");
			String RootTag = getParameter(request, "RootTag");
			String ReceiverPath = getParameter(request, "ReceiverPath");
			String SenderPath = getParameter(request, "SenderPath");
			String DocumentPath = getParameter(request, "DocumentPath");
			String ConversationPath = getParameter(request, "ConversationPath");
			String SchemaPath = getParameter(request, "SchemaPath");
			String SenderType = getParameter(request, "SenderType");
			String ReceiverType = getParameter(request, "ReceiverType");
			
			documentDB.add_documentType(TypeName, TypeDescription, Status, RootTag, ReceiverPath,SenderPath, DocumentPath, ConversationPath, SchemaPath,ReceiverType, SenderType);
			
			response.setContentType("text/json");
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void delete_documentType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			DocumentDB documentDB = new DocumentDB();
			
			String TypeID = getParameter(request, "TypeID");
			
			documentDB.delete_documentType(TypeID);
			
			getDocumentTypeTable(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void edit_documentType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		
		try {
			DocumentDB documentDB = new DocumentDB();
			
			String type_id = getParameter(request, "type_id");
			String TypeName = getParameter(request, "type_name");
			String TypeDescription = getParameter(request, "TypeDescription");
			String Status = getParameter(request, "Status");
			String RootTag = getParameter(request, "RootTag");
			String ReceiverPath = getParameter(request, "ReceiverPath");
			String SenderPath = getParameter(request, "SenderPath");
			String DocumentPath = getParameter(request, "DocumentPath");
			String ConversationPath = getParameter(request, "ConversationPath");
			String SchemaPath = getParameter(request, "SchemaPath");
			String SenderType = getParameter(request, "SenderType");
			String ReceiverType = getParameter(request, "ReceiverType");
			
			documentDB.edit_documentType(TypeName, TypeDescription, Status, RootTag, ReceiverPath, SenderPath,
					DocumentPath, ConversationPath, SchemaPath, type_id, SenderType, ReceiverType);
			
			response.setContentType("text/json");
			out.println(jsonArray);
			
		}catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			logger.error(Throwables.getStackTraceAsString(e));
			out.println(Throwables.getStackTraceAsString(e));
		}
	}
	
	protected void checkDocumentType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");	
		
		PrintWriter out = response.getWriter();
		
		try {
			DocumentDB documentDB = new DocumentDB();
			
			String ID = getParameter(request, "ID");
			
			Boolean isDuplicate = documentDB.isDuplicateDocumentType(ID);

			response.setContentType("text/json");
			out.println(isDuplicate);
			
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