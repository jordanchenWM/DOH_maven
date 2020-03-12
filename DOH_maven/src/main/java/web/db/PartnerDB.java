package web.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;

import internal.db.util.DBUtil;
import internal.server.util.DefaultValues;
import web.util.DBOperation;

@SuppressWarnings("deprecation")
public class PartnerDB {
	
	private Logger logger = LogManager.getLogger(DefaultValues.apLog);
	
	public JSONArray getPartnerTable() throws Exception {
		
		JSONArray jsonarray = new JSONArray() ;
		Connection conn = null ;
		String sql = " Select PartnerID, CorporationName, OrgUnitName, Deleted, " +
					 " DATE_FORMAT(LastModified, '%Y-%m-%d %T') as LastModified, Status " +
				 	 " From Partner " +
				 	 " Where PartnerID != '00001' AND PartnerID != 'Any' " +
				 	 " AND Deleted = 0 "  ;
		
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			
			jsonarray = DBOperation.extractSqlResult(rs);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}finally {
			closeConnection(conn);
		}
		return jsonarray ;
	}
	
	public Connection add_Partner(String Partner_ID, String Corporation_Name, String orgUnit_Name, String status, String key, Connection conn) throws Exception {
	
		String sql = " Insert Into Partner " +
					 " Values ( ? , ? , ? , 0 , now(), ?)" ;
		
		try {
			conn = initConnection(conn) ;
			conn.setAutoCommit(false);
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, Partner_ID);
			ps.setString(2, Corporation_Name);
			ps.setString(3, orgUnit_Name);
			ps.setString(4, status);
			
			ps.executeUpdate();
			
			System.out.println("PartnerDB.add_Partner: "+ ps);
			
			if(key != "addPartner") {
				conn.commit();
			}
			
		}catch(Exception e) {
			rollback(conn); 
			throw e;
		}finally {
			if(key != "addPartner") {
				closeConnection(conn);
			}
		}
		return conn;
	}
	
	
	public void edit_Partner(String Partner_ID, String Corporation_Name, String orgUnit_Name, String status) throws Exception {

		Connection conn = null ;
		String sql = " Update Partner " +
					 " Set CorporationName = ? , OrgUnitName = ? , Status = ? , LastModified = now() " + 
					 " Where PartnerID = ? ";
		try {
			conn = initConnection(conn) ;
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			
			ps.setString(1, Corporation_Name);
			ps.setString(2, orgUnit_Name);
			ps.setString(3, status);
			ps.setString(4, Partner_ID);
			
			System.out.println("PartnerDB.edit_Partner: "+ ps);
			ps.executeUpdate();
			
		}finally {
			closeConnection(conn);
		}
	}
	
	public void delete_Partner(String Partner_ID) throws Exception {
		
		Connection conn = null ;
		String sql = " Update Partner " +
					 " Set Deleted = 1 "+
					 " Where PartnerID = ? ";
		
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, Partner_ID);
			
			System.out.println("PartnerDB.delete_Partner: "+ ps);
			ps.executeUpdate();
			
		}finally {
			closeConnection(conn);
		}
	}
	
	public void delete_PartnerDetil(String Partner_ID) throws Exception {
		
		Connection conn = null ;
		String sql = " delete From PartnerField " +
					 " Where PartnerID = ? ";
					 
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, Partner_ID);
			
			System.out.println("PartnerDB.delete_PartnerDetil: "+ ps);
			ps.executeUpdate();
			
		}finally {
			closeConnection(conn);
		}
	}

	public void delete_PartnerDetail(String FieldID) throws Exception {
		
		Connection conn = null ;
		String sql = " delete From PartnerField " +
					 " Where FieldID = ? ";
		
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, FieldID);
			
			System.out.println("PartnerDB.delete_PartnerDetail: "+ ps);
			ps.executeUpdate();
			
		}finally {
			closeConnection(conn);
		}
	}

	public JSONArray getDetailTable(String PartnerID) throws Exception {
		
		JSONArray jsonarray = new JSONArray() ;
		Connection conn = null ;
		String sql = " Select PartnerID, FieldID, Field_ID, Field_Value, " +
				 	 " (Select Field_Type From FieldType where Field_ID = PartnerField.Field_ID ) as Field " +
				 	 " From PartnerField " +
				 	 " Where PartnerID = ? "  ;
					 
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, PartnerID);
			
			System.out.println("PartnerDB.getDetailTable: "+ ps);
			ResultSet rs = ps.executeQuery();
			
			jsonarray = DBOperation.extractSqlResult(rs) ;
		}finally {
			closeConnection(conn);
		}
		
		return jsonarray;
	}
	
	public void add_FieldType(String typeName) throws Exception {
		
		Connection conn = null ;
		String sql = " Insert Into FieldType(Field_Type) " +
					 " Values (?) ";
		
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, typeName);
			
			System.out.println("PartnerDB.add_FieldType: "+ ps);
			ps.executeUpdate();
			
		}finally {
			closeConnection(conn);
		}
	}
	
	public void add_Detail(String partner_ID, String field, String val, List<String> al, String key, Connection conn) throws Exception {
		
		StringBuilder sql = new StringBuilder();
		String Ssql = " Insert Into PartnerField " +
					  " Values (?, ?, ?, ?) ";
		
		try {
			if(key != "addPartner") {
				conn = initConnection(conn) ;
			}
			conn.setAutoCommit(false);
			sql.append(Ssql);

			if(al.size()>0) {
				for(int i=0; i<al.size()-1;i+=2) {
					if(al.get(i) !="" ) {
						sql.append(", ('"+(partner_ID+i)+"','"+partner_ID+"','"+al.get(i)+"','"+al.get(i+1)+"')");
					}
				}
			}
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, partner_ID+field+val);
			ps.setString(2, partner_ID);
			ps.setString(3, field);
			ps.setString(4, val);
			
			System.out.println("PartnerDB.add_Detail: "+ ps);
			ps.executeUpdate();
			System.out.println(key);
			
			conn.commit();
			
		}catch(Exception e) {
			rollback(conn);
			throw e;
		}finally {
			closeConnection(conn);
		}
	}
	
	public void edit_Detail(String fieldID, String field_name, String field_val) throws Exception {
		
		Connection conn = null ;
		String sql = " Update PartnerField " +
					 " Set Field_ID = ? , Field_Value = ? " +
					 " Where FieldID = ? ";
		
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, field_name);
			ps.setString(2, field_val);
			ps.setString(3, fieldID);
			
			System.out.println("PartnerDB.edit_Detail: "+ ps);
			ps.executeUpdate();
			
		}finally {
			closeConnection(conn);
		}
	}
	
	public JSONArray fieldTypeList() throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null ;
		String sql = " Select Field_ID, Field_Type" +
					 " From FieldType ";
					 
		try {
			
			conn = initConnection(conn) ;
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			
			ResultSet rs = ps.executeQuery();
			jsonarray = DBOperation.extractSqlResult(rs);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(conn);
		}
		return jsonarray ;
	}
	
	public Boolean isDuplicateDetail(String col1, String col2) throws Exception {
		
		Connection conn = null ;
		String sql = " Select PartnerID, FieldID, Field_ID, Field_Value " +
				 	 " From PartnerField "  +
				 	 " Where Field_ID = ? AND Field_Value = ? ";
		
		Boolean isDuplicate = null ; 
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, col1);
			ps.setString(2, col2);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString("FieldID") != null) {
					isDuplicate = true;
				}
			}else
				isDuplicate = false;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(conn);
		}
		return isDuplicate;
	}
	
	public Boolean isDuplicateType(String typeName) throws Exception {
		 
		Connection conn = null ;
		String sql = " Select Field_ID, Field_Type " +
				 	 " From FieldType "  +
				 	 " Where Field_Type = ? ";
		
		Boolean isDuplicate = null ; 
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, typeName);
			
			ResultSet rs = ps.executeQuery();
			System.out.println("PartnerDB.isDuplicateType: "+ ps);
			if(rs.next()) {
				if(rs.getString("Field_Type") != null) {
					isDuplicate = true;
				}
			}else
				isDuplicate = false;
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}finally {
			closeConnection(conn);
		}
		return isDuplicate;
	}
	
	public JSONArray getOnePartner(String ID) throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null ;
		String sql = " Select PartnerID, CorporationName, OrgUnitName, Deleted, LastModified, Status " +
				 	 " From Partner " +
				 	 " Where PartnerID = ? " ;
					 
		try {
			
			conn = initConnection(conn) ;
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, ID);
			
			System.out.println("PartnerDB.getOnePartner: "+ ps);
			ResultSet rs = ps.executeQuery();
			
			jsonarray = DBOperation.extractSqlResult(rs);
		}finally {
			closeConnection(conn);
		}
		
		return jsonarray;
	}
	
	public JSONArray getAllPartner() throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null ;
		String sql = " Select PartnerID, CorporationName " +
				 	 " From Partner " ;
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			
			jsonarray = DBOperation.extractSqlResult(rs) ;
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}finally {
			closeConnection(conn);
		}
		return jsonarray;
	}
	
	public JSONArray getType() throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null ;
		String sql = " Select distinct Type " +
					 " From DeliveryService " ;
					 
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			
			jsonarray = DBOperation.extractSqlResult(rs);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}finally {
			closeConnection(conn);
		}
		
		return jsonarray;
	}
	
	public void add_delivery(String PartnerID,String delivery_method, String host, String port, String location, 
			String user_name, String password, String preferred) throws Exception {
		
		Connection conn = null ;
		String sql = " Insert PartNerDelivery " +
					 " Values (?, ?, ?, ?, ?, ?, ?, ?, ?) " ;
		
		try {
			conn = initConnection(conn) ;
			
			String deliveryID = UUID.randomUUID().toString();
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, deliveryID);
			ps.setString(2, PartnerID);
			ps.setString(3, delivery_method);
			ps.setString(4, host);
			ps.setString(5, port);
			ps.setString(6, location);
			ps.setString(7, user_name);
			ps.setString(8, password);
			ps.setBoolean(9, Boolean.parseBoolean(preferred));
			
			System.out.println("PartnerDB.add_delivery: "+ ps);
			ps.executeUpdate();
			
		}finally {
			closeConnection(conn);
		}
	}
	
	public JSONArray getDelivery(String PartnerID) throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null ;
		String sql = " Select DeliveryID, PartnerID, Methods, Host, Port, Location, UserName, Password " +
				 	 " From PartnerDelivery " +
				 	 " Where PartnerID = ? "  ;
					 
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, PartnerID);
			
			//System.out.println("PartnerDB.getDelivery: "+ ps);
			ResultSet rs = ps.executeQuery();
			
			jsonarray = DBOperation.extractSqlResult(rs) ;
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}finally {
			closeConnection(conn);
		}
		
		return jsonarray;
	}
	
	public JSONArray getOneDelivery(String DeliveryID) throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null ;
		String sql = " Select DeliveryID, Methods, Host, Port, Location, UserName, Password, Preferred" +
				 	 " From PartnerDelivery " +
				 	 " Where DeliveryID = ? "  ;
					 
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, DeliveryID);
			ResultSet rs = ps.executeQuery();
			
			jsonarray = DBOperation.extractSqlResult(rs);
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}finally {
			closeConnection(conn);
		}
		
		return jsonarray;
	}
	
	public void delete_Delivery(String DeliveryID) throws Exception {
			
		Connection conn = null ;
		String sql = " Delete From PartnerDelivery " +
					 " Where DeliveryID = ? ";
		 
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, DeliveryID);
			
			System.out.println("PartnerDB.delete_Delivery: "+ ps);
			ps.executeUpdate();
			
		}finally {
			closeConnection(conn);
		}
	}
	
	public void edit_Delivery(String deliveryID, String host, String port, String location,
							  String user_name, String password, String preferred) throws Exception {
		
		Connection conn = null ;
		String sql = " Update PartnerDelivery " +
					 " Set Host = ?, Port = ?, Location = ?, UserName = ?, Password = ?, Preferred = ? " +
					 " Where DeliveryID = ? ";
		
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, host);
			ps.setString(2, port);
			ps.setString(3, location);
			ps.setString(4, user_name);
			ps.setString(5, password);
			ps.setBoolean(6, Boolean.parseBoolean(preferred));
			ps.setString(7, deliveryID);
			
			System.out.println("PartnerDB.edit_Delivery: "+ ps);
			ps.executeUpdate();
			
		}finally {
			closeConnection(conn);
		}
	}
	
	public JSONArray getPreferred(String PartnerID) throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null ;
		String sql = " Select Methods " +
				 	 " From PartnerDelivery " +
				 	 " Where Preferred = true AND PartnerID = ? "  ;
					 
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, PartnerID);
			ResultSet rs = ps.executeQuery();
			
			jsonarray = DBOperation.extractSqlResult(rs);
		}finally {
			closeConnection(conn);
		}
		
		return jsonarray;
	}

	public JSONArray getProtocol() throws Exception {
		
		JSONArray jsonarray = new JSONArray();
		Connection conn = null ;
		String sql = " Select distinct Protocol " +
				 	 " From DeliveryService " ;
					 
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ResultSet rs = ps.executeQuery();
			
			jsonarray = DBOperation.extractSqlResult(rs);
		}finally {
			closeConnection(conn);
		}
		
		return jsonarray;
	}
	
	public void setPreferred(String PartnerID) throws Exception {
		
		Connection conn = null ;
		String sql = " Update PartnerDelivery " +
					 " Set Preferred = false " +
				 	 " Where PartnerID = ? "  ;
					 
		try {
			conn = initConnection(conn) ;
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, PartnerID);
			ps.executeUpdate();
			
		}finally {
			closeConnection(conn);
		}
	}
	
	public Boolean isDuplicateDelivery(String delivery_method, String partnerID) throws Exception {
		 
		Connection conn = null ;
		String sql = " Select DeliveryID " +
				 	 " From PartnerDelivery "  +
				 	 " Where Methods = ? AND PartnerID = ? ";
		
		Boolean isDuplicate = null ; 
		try {
			
			conn = initConnection(conn) ;
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, delivery_method);
			ps.setString(2, partnerID);
			
			ResultSet rs = ps.executeQuery();
			System.out.println("PartnerDB.isDuplicateDelivery: "+ ps);
			if(rs.next()) {
				if(rs.getString("DeliveryID") != null) {
					isDuplicate = true;
				}
			}else
				isDuplicate = false;
			
		}finally {
			closeConnection(conn);
		}
		return isDuplicate;
	}

	public void rollback(Connection conn) throws SQLException {
			if(conn.getAutoCommit()) {
				conn.rollback();
			}
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
