package internal.db.dao.frame;

import java.util.Map;

public interface IBizDocType {

	public final static String TypeName = "TypeName";
	public final static String TypeID = "TypeID";
	public final static String TypeDescription = "TypeDescription";
	public final static String Deleted = "Deleted";
	public final static String LastModified = "LastModified";
	public final static String RootTag = "RootTag";
	public final static String SenderPath = "SenderPath";
	public final static String SenderFieldType = "SenderType";
	public final static String ReceiverPath = "ReceiverPath";
	public final static String ReceiveFieldType = "ReceiverType";
	public final static String DocumentPath = "DocumentPath";
	public final static String ConversationPath = "ConversationPath";
	public final static String SchemaPath = "SchemaPath";
	
	//public void setConn(Connection conn);
	public Map<String, String> selectOne(String key) ;
	//public Object getColumnValue(String column);
}
