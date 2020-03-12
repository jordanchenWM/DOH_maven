package internal.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.google.common.base.Throwables;

import internal.db.dao.frame.IPartnerField;
import internal.db.util.DBUtil;

public class PartnerFieldDao extends BaseDao implements IPartnerField {
	
	
	@Override
	public String getPartnerIDByField(int fieldId, String fieldValue) {
		
		String partnerId = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select PartnerID from PartnerField where Field_ID = ? and Field_Value = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fieldId);
			pstmt.setString(2, fieldValue);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {				
				partnerId = rs.getString("PartnerID");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Throwables.getStackTraceAsString(e));
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return partnerId;
	}

	

}
