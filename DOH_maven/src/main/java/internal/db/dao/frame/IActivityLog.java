package internal.db.dao.frame;

public interface IActivityLog {

	public static final Integer info = 2;
	public static final Integer warn = 1;
	public static final Integer error = 0;
	
	public static final String general = "General";
	public static final String recognition = "Recognition";
	public static final String processing = "Processing";
	
	public static final String ActivityLogID = "ActivityLogID";
	public static final String RelatedDocID = "RelatedDocID";
	public static final String RelatedDocTypeID = "RelatedDocTypeID";
	public static final String EntryTimestamp = "EntryTimestamp";
	public static final String EntryType = "EntryType";
	public static final String EntryClass= "EntryClass";
	public static final String BriefMessage = "BriefMessage";
	public static final String FullMessage = "FullMessage";
	
	public void insert(Integer log_level, String log_type, String docID, String msg, String fullMsg) ;
}
