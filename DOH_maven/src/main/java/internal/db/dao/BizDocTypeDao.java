package internal.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Throwables;

import internal.db.dao.frame.IBizDocType;
import internal.db.util.DBUtil;

public class BizDocTypeDao extends BaseDao implements IBizDocType{
	
	/*
	@Override
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	*/
	
	@Override
	public Map<String, String> selectOne(String rootTag) {
		
		Map<String, String> dataMap = new HashMap<>();
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select * from BizDocTypeDef where RootTag = ? and Status = 1";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rootTag);
			
			logger.debug(pstmt);
			
			ResultSet rs = pstmt.executeQuery();
						
			if (rs.next()) {
				dataMap = getDataMap(rs);
			}
			
			logger.debug(dataMap);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Throwables.getStackTraceAsString(e));
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return dataMap;
	}



}
