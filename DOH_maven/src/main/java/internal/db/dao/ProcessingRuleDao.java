package internal.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Throwables;

import internal.db.dao.frame.IProcessingRule;
import internal.db.util.DBUtil;
import internal.server.util.DefaultValues;

public class ProcessingRuleDao extends BaseDao implements IProcessingRule {

	
	@Override
	public Map<String, String> getRule(String senderID, String receiverID, String docTypeID) {
		
		Map<String, String> dataMap = new HashMap<>();
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * from ProcessingRule");
			sql.append(" where Disabled = 0");
			sql.append(" and (SenderID = ? or SenderID = ?)"); 
			sql.append(" and (ReceiverID = ? or ReceiverID = ?)"); 
			sql.append(" and (DocTypeID = ? or DocTypeID = ?)"); 
			sql.append(" order by RuleIndex asc");
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, senderID);
			pstmt.setString(2, DefaultValues.anyParterID);
			pstmt.setString(3, receiverID);
			pstmt.setString(4, DefaultValues.anyParterID);
			pstmt.setString(5, docTypeID);
			pstmt.setString(6, DefaultValues.anyDocTypeID);
			
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
