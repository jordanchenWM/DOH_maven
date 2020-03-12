package internal.db.dao.frame;

import java.util.Map;


public interface IBizDocContent {

	public static final String docID = "DocID";
	public static final String partName = "PartName";
	public static final String mimeType = "MimeType";
	public static final String contentLength = "ContentLength";
	public static final String content = "Content";
	
	//public void setConn(Connection conn);
	public void insert(String docID, String name, String content, String contentType) throws Exception;
	public Map<String, String> selectOne(String key);
}
