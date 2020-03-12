package internal.tn.module;

import internal.server.util.DefaultValues;

public class BizDoc {

	private String docID = null;	
	private String docTypeID = DefaultValues.docTypeID;		
	private String senderID = DefaultValues.senderID;
	private String receiverID = DefaultValues.receiverID;	
	//private BizDocContent content = null;

	public String getDocID() {
		return docID;
	}

	public void setDocID(String docID) {
		this.docID = docID;
	}

	public String getDocTypeID() {
		return docTypeID;
	}

	public void setDocTypeID(String docTypeID) {
		this.docTypeID = docTypeID;
	}

	public String getSenderID() {
		return senderID;
	}

	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}

	public String getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(String receiverID) {
		this.receiverID = receiverID;
	}

	
	
	
}
