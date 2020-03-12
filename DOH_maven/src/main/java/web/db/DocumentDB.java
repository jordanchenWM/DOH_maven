package web.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import org.json.simple.JSONArray;

import internal.db.util.DBUtil;
import web.util.DBOperation;

@SuppressWarnings("deprecation")
public class DocumentDB {
	
	public JSONArray getDocumentTypeTable() throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null;
		String sql = " Select TypeName, TypeDescription, Status, " +
				 	 " DATE_FORMAT(LastModified, '%Y-%m-%d %T') as LastModified, TypeID, RootTag, ReceiverPath, SenderPath, " +
				 	 " (Select Field_Type From FieldType where Field_ID = BizDocTypeDef.SenderType ) as SenderTypeName, " +
				 	 " (Select Field_Type From FieldType where Field_ID = BizDocTypeDef.ReceiverType ) as ReceiverTypeName, " +
					 " DocumentPath, ConversationPath , SchemaPath ,SenderType, ReceiverType " +
				 	 " From BizDocTypeDef " +
				 	 " Where TypeID != '00001' " ;
					  
		try {
			conn = initConnection(conn);	
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			
			jsonarray = DBOperation.extractSqlResult(rs);
		}finally {
			closeConnection(conn);
		}
		return jsonarray;
	}
	
	public void add_documentType(String typeName, String typeDescription, String status, String rootTag, 
			String receiverPath, String senderPath, String documentPath, String conversationPath, String schemaPath, String receiverType, String senderType) throws Exception {
		
		Connection conn = null;
		String sql = " Insert BizDocTypeDef" +
				 	 " Values ( ?, ?, ?, ?, now(), ?, ?, ?, ?, ?, ?, ?, ?) "  ;
		
		try {
			String docID = UUID.randomUUID().toString();
			conn = initConnection(conn);
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, typeName);
			ps.setString(2, docID);
			ps.setString(3, typeDescription);
			ps.setInt(4, Integer.parseInt(status));
			ps.setString(5, rootTag);
			ps.setString(6, receiverPath);
			ps.setString(7, senderPath);
			ps.setString(8, documentPath);
			ps.setString(9, conversationPath);
			ps.setString(10, schemaPath);
			ps.setInt(11, Integer.parseInt(receiverType));
			ps.setInt(12, Integer.parseInt(senderType));
			
			System.out.println("DocumentDB.add_documentType: "+ ps);
			ps.executeUpdate();
			
		}finally {
			closeConnection(conn);
		}
	}
	
	public void delete_documentType(String typeID) throws Exception {
		
		Connection conn = null;
		String sql = " Delete From BizDocTypeDef" +
				 	 " Where TypeID = ? "  ;
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, typeID);
			System.out.println("DocumentDB.delete_documentType: "+ ps);
			ps.executeUpdate();
			
		}finally {
			closeConnection(conn);
		}
	}
	
	public void edit_documentType(String typeName, String typeDescription, String status, String rootTag, String receiverPath, 
		String senderPath, String DocumentPath, String ConversationPath, String SchemaPath, String type_id, String senderType, String receiverType) throws Exception {
		
		Connection conn = null;
		String sql = " Update BizDocTypeDef " +
					 " Set TypeName = ?, TypeDescription = ?, Status = ?, LastModified = now(), RootTag = ?, " +
					 " ReceiverPath = ?, SenderPath = ?, DocumentPath = ?, ConversationPath = ? , SchemaPath = ?, " +
					 " ReceiverType = ?, SenderType = ? " +
				 	 " Where TypeID = ? "  ;
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, typeName);
			ps.setString(2, typeDescription);
			ps.setInt(3, Integer.parseInt(status));
			ps.setString(4, rootTag);
			ps.setString(5, receiverPath);
			ps.setString(6, senderPath);
			ps.setString(7, DocumentPath);
			ps.setString(8, ConversationPath);
			ps.setString(9, SchemaPath);
			ps.setInt(10, Integer.parseInt(receiverType));
			ps.setInt(11, Integer.parseInt(senderType));
			ps.setString(12, type_id);
			
			ps.executeUpdate();
			
			System.out.println("DocumentDB.edit_documentType: "+ ps.toString());
			
		}finally {
			closeConnection(conn);
		}
	}
	
	public Boolean isDuplicateDocumentType(String ID) throws Exception {
		
		Boolean isDuplicate = null ; 
		Connection conn = null;
		String sql = " Select DocID, DocTypeID, SenderID, ReceiverID " +
				 	 " From BizDoc "  +
				 	 " Where DocTypeID = ? ";
		
		try {
			conn = initConnection(conn);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, ID);
			
			ResultSet rs = ps.executeQuery();
			System.out.println("DocumentDB.isDuplicateType: "+ ps);
			if(rs.next()) {
				if(rs.getString("DocID") != null) {
					isDuplicate = true;
				}
			}else
				isDuplicate = false;
			
		}finally {
			closeConnection(conn);
		}
		return isDuplicate;
	}
	
	protected Connection initConnection(Connection conn) throws SQLException {		
		
		if (conn == null || conn.isClosed()) {
			try {
				conn = DBUtil.getConnection() ;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;		
	}
	
	protected void closeConnection(Connection conn) {

		try {
			if (conn != null && conn.getAutoCommit()) {
				DBUtil.closeConnection(conn);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
