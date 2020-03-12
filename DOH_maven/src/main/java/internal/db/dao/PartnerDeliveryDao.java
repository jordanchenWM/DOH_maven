package internal.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Throwables;

import internal.db.dao.frame.IPartnerDelivery;
import internal.db.util.DBUtil;
import internal.server.util.AES;

public class PartnerDeliveryDao extends BaseDao implements IPartnerDelivery {

	//private PreparedStatement pstmt = null;
	//private ResultSet rs = null;
	
	@Override
	public Map<String, String> getDeliveryByMethod(String partnerID, String methods) {
		
		Map<String, String> dataMap = new HashMap<>();
		Connection conn = null;
		boolean searchByName = false;
		
		try {
			conn = DBUtil.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select Methods, Host, Port, Location, UserName, Password, Preferred ");
			sql.append("from PartnerDelivery ");
			sql.append("where PartnerID = ? ");
			
			if (StringUtils.isEmpty(methods)) {
				sql.append("and Preferred = true ");
			} else if (methods.equals("http")) {
				sql.append("and (Methods = 'HTTP-Primary' or Methods = 'HTTP-Secondary') ");
			} else {
				sql.append("and Methods = ? ");
				searchByName = true;
			}
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, partnerID);
			
			if (searchByName) {
				pstmt.setString(2, methods);
			}
			
			logger.debug(pstmt);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dataMap = getDataMap(rs);
				//update password
				dataMap.put("Password", AES.Decrypt(rs.getString("Password")));
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Throwables.getStackTraceAsString(e));
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return dataMap;
	}

}
