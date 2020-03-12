package internal.db.dao.frame;

import java.util.List;
import java.util.Map;


public interface ITask {

	public final static String TASK_ID = "UUID";
	public final static String DESCRIPTION = "DESCRIPTION";
	public final static String SERVICE = "SERVICE";
	public final static String STARTTIME = "STARTTIME";
	public final static String ENDTIME = "ENDTIME";
	public final static String TIMEINTERVAL = "TIMEINTERVAL";
	public final static String HOURMASK = "HOURMASK";
	public final static String MINUTEMASK = "MINUTEMASK";
	public final static String STATE = "STATE";
	public final static String RUNNINGON = "RUNNINGON";
	public final static String NEXTRUN = "NEXTRUN";
	public final static String LASTERROR = "LASTERROR";
	public final static String TASK_NAME = "TASK_NAME";
	
	public List<Map<String, String>> getEnableList();
	
	public Map<String, String> selectOne(String key);
	public void update(String id, Map<String, String> dataMap) throws Exception;
	public void delete(String id) throws Exception;

}
