package internal.db.dao.frame;

import java.util.Map;


public interface IBizDoc {
		
	public final static String DocTypeID = "DocTypeID";
	public final static String SenderID = "SenderID";
	public final static String ReceiverID = "ReceiverID";
	public final static String NativeID = "NativeID";
	public final static String ConversationID = "ConversationID";
	public final static String RoutingStatus = "RoutingStatus";
	public final static String UserStatus = "UserStatus";
	
	public String insert(String senderID, String receiverID, String docTypeID) throws Exception;
	public void update(String docID, Map<String, String> dataMap) throws Exception;
	//public void setConn(Connection conn);
}
