package internal.db.dao.frame;

public interface IPartnerField {

	public static final String ID = "Field_ID";
	public static final String type = "Field_Type";
	
	public String getPartnerIDByField(int fieldId, String fieldValue);
}
