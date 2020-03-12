//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 所產生 
// 請參閱 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2019.04.12 於 11:22:09 AM CST 
//


package doc.xml.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "processID",
    "senderID",
    "receiverID",
    "documentType"
})

@XmlRootElement(name = "MessageInfo", namespace = "")
public class MessageInfo {

    @XmlElement(name = "ProcessID", namespace = "", required = true)
    protected String processID;
    @XmlElement(name = "SenderID", namespace = "", required = true)
    protected String senderID;
    @XmlElement(name = "ReceiverID", namespace = "", required = true)
    protected String receiverID;
    @XmlElement(name = "DocumentType", namespace = "", required = true)
    protected String documentType;

    /**
     * processID.
     */    
    public String getProcessID() {
        return processID;
    }
    public void setProcessID(String value) {
        this.processID = value;
    }

    /**
     * senderID 
     */    
    public String getSenderID() {
        return senderID;
    }
    public void setSenderID(String value) {
        this.senderID = value;
    }

    /**
     * receiverID 
     */
    public String getReceiverID() {
        return receiverID;
    }
    public void setReceiverID(String value) {
        this.receiverID = value;
    }

    /**
     * documentType
     */
    public String getDocumentType() {
        return documentType;
    }
    public void setDocumentType(String value) {
        this.documentType = value;
    }

}
