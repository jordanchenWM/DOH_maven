package web.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@SuppressWarnings("deprecation")
public class DBOperation {

	
	@SuppressWarnings("unchecked")
	public static JSONArray extractSqlResult(ResultSet rs) throws Exception {
		
		JSONArray jsonArray = new JSONArray();
		List<String> columnNames = new ArrayList<>();
		
		ResultSetMetaData rsmd = rs.getMetaData();
		Map<String, String> map = new HashMap<>();
		
		for (int i = 1; i < rsmd.getColumnCount() +1; i++) {
			columnNames.add(rsmd.getColumnLabel(i));
			//System.out.println(rsmd.getColumnLabel(i));
		}
		while (rs.next()) {		
			for (String columnName : columnNames) {
				map.put(columnName, rs.getString(columnName));	
			}
			JSONObject jsonObject = new JSONObject();
			jsonObject.putAll(map);
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;
	}
}
