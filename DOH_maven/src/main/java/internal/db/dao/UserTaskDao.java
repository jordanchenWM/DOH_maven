package internal.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Throwables;

import internal.db.dao.frame.ITask;
import internal.db.util.DBUtil;

public class UserTaskDao extends BaseDao implements ITask {

	//private PreparedStatement pstmt = null;
	//private ResultSet rs = null;
	
	@Override
	public Map<String, String> selectOne(String key) {
		
		Map<String, String> dataMap = new HashMap<>();
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select * from IS_USER_TASKS where UUID = ? ";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, key);
			
			logger.debug(pstmt);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dataMap = getDataMap(rs);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Throwables.getStackTraceAsString(e));
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return dataMap;
	}

	@Override
	public List<Map<String, String>> getEnableList() {
		
		List<Map<String, String>> list = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = DBUtil.getConnection();
			
			String sql = "select * from IS_USER_TASKS where STATE in (1,2)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			logger.debug(pstmt);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Map<String, String> dataMap = new HashMap<>();
				dataMap = getDataMap(rs);
				list.add(dataMap);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Throwables.getStackTraceAsString(e));
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return list;
	}

	@Override
	public void update(String id, Map<String, String> dataMap) throws Exception {
		// TODO Auto-generated method stub
			
		logger.debug(dataMap);
		
		if (dataMap != null && !dataMap.isEmpty()) {
			Connection conn = null;
			try {
				conn = DBUtil.getConnection();
				
				StringBuilder sql = new StringBuilder();
				sql.append("update IS_USER_TASKS ");
				sql.append("set ");
				sql.append(String.join("= ?, ", dataMap.keySet()));
				sql.append("= ? ");
				
				sql.append("where UUID = ?");
				
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				int index = 1;
 				for (String key : dataMap.keySet()) {
					pstmt.setString(index, dataMap.get(key));
					index++;
				}
 				pstmt.setString(index, id);
 				
 				logger.debug(pstmt);
 				
 				pstmt.executeUpdate();				
				
			}  finally {
				DBUtil.closeConnection(conn);	
			}			
		} 	
		
	}


	@Override
	public void delete(String id) throws Exception{
		
		String sql = " delete FROM IS_USER_TASKS where UUID = ? " ;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			logger.debug(pstmt);
			
			pstmt.executeUpdate();
			
		}  finally {
			DBUtil.closeConnection(conn);
		}
		
	}

	
}
