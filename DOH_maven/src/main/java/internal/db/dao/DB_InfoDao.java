package internal.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Throwables;

import internal.db.dao.frame.IDB_Info;
import internal.db.util.DBUtil;

public class DB_InfoDao extends BaseDao implements IDB_Info {

	
	public static void main(String[] args) throws Exception {
		DB_InfoDao d = new DB_InfoDao();
		List<Map<String, String>> mm = d.getEnableList();
		System.out.println(mm);
		
		Map<String, String> map = d.selectOne("Oracle1");
		System.out.println(map);
	}
	
	@Override
	public Map<String, String> selectOne(String alias) {
		
		Map<String, String> dataMap = new HashMap<>();
		Connection conn = null;
		
		try {
			
			conn = DBUtil.getConnection();
			
			String sql = "select * from DB_Info where Alias_Name = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, alias);
			
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
	
	@Override
	public List<Map<String, String>> getEnableList() {
		
		List<Map<String, String>> list = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = DBUtil.getConnection();
			
			String sql = "select * from DB_Info where Disabled = false";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			logger.debug(pstmt);
			
			ResultSet rs = pstmt.executeQuery();			
			ResultSetMetaData metadata = rs.getMetaData();
			
			while (rs.next()) {
				Map<String, String> dataMap = new HashMap<>();
				//String key = rs.getString(DB_Info.Alias_Name);
				for (int i=1; i < metadata.getColumnCount()+1; i++) {
					String key = metadata.getColumnName(i);	
					dataMap.put(key, rs.getString(key));
				}		
				list.add(dataMap);
			}
			
			logger.debug(list);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(Throwables.getStackTraceAsString(e));
		} finally {
			DBUtil.closeConnection(conn);
		}
		
		return list;
	}

	

}
