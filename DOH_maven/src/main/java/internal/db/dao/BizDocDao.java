package internal.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Map;
import java.util.UUID;

import internal.db.dao.frame.IBizDoc;
import internal.db.util.DBUtil;

public class BizDocDao extends BaseDao implements IBizDoc {
		
	/*
	@Override
	public void setConn(Connection conn) {
		this.conn = conn;
	}*/
	
	
	@Override
	public String insert(String senderID, String receiverID, String docTypeID) throws Exception {
				
		String docID = UUID.randomUUID().toString();
		Connection conn = null;
		
		try {		
			conn = DBUtil.getConnection();
						
			String sql = "insert into BizDoc (DocID, DocTypeID, SenderID, ReceiverID, DocTimestamp, RoutingStatus)"
					+ " values (?,?,?,?,now(),?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
								
			pstmt.setString(1, docID);
			pstmt.setString(2, docTypeID); //unknow DocTypeID
			pstmt.setString(3, senderID); //unknow SenderID
			pstmt.setString(4, receiverID); //unknow ReceiverID
			pstmt.setString(5, "New");

			logger.debug(pstmt);
			
			pstmt.executeUpdate();
			
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return docID;
	}


	@Override
	public void update(String docID, Map<String, String> dataMap) throws Exception {
		// TODO Auto-generated method stub
		logger.debug(dataMap);
		
		if (dataMap != null && !dataMap.isEmpty()) {
			
			Connection conn = null;
			
			try {
				conn = DBUtil.getConnection();
				
				StringBuilder sql = new StringBuilder();
				sql.append("update BizDoc set LastModified = now() ");
				for (String key : dataMap.keySet()) {
					sql.append(", " + key + "= '" + dataMap.get(key) + "' " );
				}
				sql.append("where DocID = '" + docID + "'");
				
				logger.debug(sql);
				
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql.toString());
				
			} finally {
				DBUtil.closeConnection(conn);	
			}			
		} 		
	}


	


	

	

}
