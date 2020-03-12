package internal.db.dao.frame;

import java.util.Map;

public interface IPartnerDelivery {

	public static final String DeliveryID = "DeliveryID";
	public static final String PartnerID = "PartnerID";
	public static final String Methods = "Methods";
	public static final String Host = "Host";
	public static final String Port = "Port";
	public static final String Location = "Location";
	public static final String UserName = "UserName";
	public static final String Password = "Password";
	public static final String Preferred = "Preferred";
	
	public Map<String, String> getDeliveryByMethod(String partnerID, String methods);
}
