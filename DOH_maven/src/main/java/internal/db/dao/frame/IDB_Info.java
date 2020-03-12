package internal.db.dao.frame;

import java.util.List;
import java.util.Map;

public interface IDB_Info {

	public final static String Alias_Name = "Alias_Name";
	public final static String Alias_Description = "Alias_Description";
	public final static String URL = "URL";
	public final static String Account = "Account";
	public final static String Password = "Password";
	public final static String Driver = "Driver";
	public final static String DataSource_class = "DataSource_class";
	public final static String isPoolEnable = "Pooling_Enable";
	public final static String MaxPoolSize = "MaxPoolSize";
	public final static String MinPoolSize = "MinPoolSize";
	public final static String Block_Timeout = "Block_Timeout";
	public final static String Expire_Timeout = "Expire_Timeout";
	public final static String Startup_Timeout = "Startup_Timeout";
	public final static String Disabled = "Disabled";
	
	public List<Map<String, String>> getEnableList() ;
	public Map<String, String> selectOne(String key) ;
}
