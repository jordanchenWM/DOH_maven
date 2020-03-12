package internal.db.dao.frame;

import java.util.Map;

public interface IProcessingRule {

	public final static String RuleName = "RuleName";
	public final static String Service = "Service";
	
	public Map<String, String> getRule(String senderID, String receiverID, String docTypeID);
}
