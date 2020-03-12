package internal.db.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Throwables;

import internal.db.dao.frame.IBizDocContent;
import internal.db.util.DBUtil;

public class BizDocContentDao extends BaseDao implements IBizDocContent{

	/*
	@Override
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	*/
	
	
	@Override
	public Map<String, String> selectOne(String DocID)  {

		Map<String, String> dataMap = new HashMap<>();
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select * from BizDocContent where DocID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, DocID);
			
			logger.debug(pstmt);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dataMap = getDataMap(rs);
			}
			
			logger.debug(dataMap);
			
		} catch (Exception e){
			e.printStackTrace();
			logger.error(Throwables.getStackTraceAsString(e));
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return dataMap;
	}
	
	@Override
	public void insert(String docID, String name,  String content, String contentType) throws Exception {
		// TODO Auto-generated method stub
				
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "insert into BizDocContent (DocID, PartName, Content, MimeType, ContentLength) "
					+ "values (?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
					
			pstmt.setString(1, docID);
			pstmt.setString(2, name);
			pstmt.setString(3, content);
			pstmt.setString(4, contentType);
			pstmt.setInt(5, content.getBytes().length);
			
			logger.debug(pstmt);
			
			pstmt.executeUpdate();
		} finally {	
			DBUtil.closeConnection(conn);
		}
		
	}


	



	

}
