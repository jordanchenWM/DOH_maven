package internal.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

import com.google.common.base.Throwables;

import internal.db.dao.frame.IActivityLog;
import internal.db.util.DBUtil;

public class ActivityLogDao extends BaseDao implements IActivityLog {
	
	
	public void insert(Integer log_level, String log_type, String docID, String msg, String fullMsg)  {
				
		String logID = UUID.randomUUID().toString();
		Connection conn = null;
		
		try {	
			
			if (fullMsg != null && fullMsg.length() > 1024) {
				fullMsg = fullMsg.substring(0, 1021) + "...";
			}
			conn = DBUtil.getConnection();
			
			String sql = "insert into ACTIVITYLOG "
					+ "(ActivityLogID, RelatedDocID, RelatedDocTypeID, "
					+ "EntryTimestamp, EntryType, EntryClass,"
					+ "BriefMessage, RelatedPartnerID, RelatedInstanceID, RelatedProcRuleID,"
					+ "RelatedStepID, B2BUser, FullMessage)"
					+ " values (?,?,?,now(),?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, logID);
			pstmt.setString(2, docID);
			pstmt.setString(3, null);
			
			pstmt.setInt(4, log_level);
			pstmt.setString(5, log_type);
			
			pstmt.setString(6, msg);
			pstmt.setString(7, null);
			pstmt.setString(8, null);
			pstmt.setString(9, null);
			
			pstmt.setString(10, null);
			pstmt.setString(11, null);
			pstmt.setString(12, fullMsg);
			
			//logger.debug(pstmt);
			
			//System.out.println(pstmt.toString());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Throwables.getStackTraceAsString(e));
		} finally {
			DBUtil.closeConnection(conn);
		}
	}


	


}
