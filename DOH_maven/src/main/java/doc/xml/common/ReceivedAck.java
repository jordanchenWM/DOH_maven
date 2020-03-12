//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 所產生 
// 請參閱 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2020.03.04 於 05:14:13 PM CST 
//


package doc.xml.common;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mesgInfo",
    "documentInfo",
    "itemInfo",
    "transmissionCode"
})
@XmlRootElement(name = "ReceivedAck")
public class ReceivedAck {

    @XmlElement(name = "MesgInfo", required = true, nillable = true)
    protected MessageInfo mesgInfo;
    @XmlElement(name = "DocumentInfo", required = true, nillable = true)
    protected ReceivedAck.DocumentInfo documentInfo;
    @XmlElement(name = "ItemInfo", nillable = true)
    protected List<ReceivedAck.ItemInfo> itemInfo;
    @XmlElement(name = "TransmissionCode", required = true, nillable = true)
    protected String transmissionCode;
    
        
    /*
     * mesgInfo
     */
    public MessageInfo getMesgInfo() {
		return mesgInfo;
	}
	public void setMesgInfo(MessageInfo mesgInfo) {
		this.mesgInfo = mesgInfo;
	}


	/*
	 * documentInfo
	 */
	public ReceivedAck.DocumentInfo getDocumentInfo() {
		return documentInfo;
	}
	public void setDocumentInfo(ReceivedAck.DocumentInfo documentInfo) {
		this.documentInfo = documentInfo;
	}


	/*
	 * itemInfo
	 */
	public List<ReceivedAck.ItemInfo> getItemInfo() {
		return itemInfo;
	}
	public void setItemInfo(List<ReceivedAck.ItemInfo> itemInfo) {
		this.itemInfo = itemInfo;
	}

	/*
	 * transmissionCode
	 */
	public String getTransmissionCode() {
		return transmissionCode;
	}
	public void setTransmissionCode(String transmissionCode) {
		this.transmissionCode = transmissionCode;
	}


	@XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "documentNo",
        "status",
        "lastUpdateTime"
    })
    public static class DocumentInfo {

        @XmlElement(name = "DocumentNo", required = true, nillable = true)
        protected String documentNo;
        @XmlElement(name = "Status", required = false)
        protected String status;
        @XmlElement(name = "LastUpdateTime", required = false)
        protected String lastUpdateTime;
        
        /*
         * documentNo
         */
		public String getDocumentNo() {
			return documentNo;
		}
		public void setDocumentNo(String documentNo) {
			this.documentNo = documentNo;
		}
		
		/*
		 * status
		 */
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		/*
		 * lastUpdateTime
		 */
		public String getLastUpdateTime() {
			return lastUpdateTime;
		}
		public void setLastUpdateTime(String lastUpdateTime) {
			this.lastUpdateTime = lastUpdateTime;
		}

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "itemNo",
        "status",
        "lastUpdateTime"
    })
    public static class ItemInfo {

    	@XmlElement(name = "ItemNo", required = false)
        protected String itemNo;
    	@XmlElement(name = "Status", required = false)
        protected String status;
    	@XmlElement(name = "LastUpdateTime", required = false)
        protected String lastUpdateTime;
		
    	/*
    	 * itemNo
    	 */
    	public String getItemNo() {
			return itemNo;
		}
		public void setItemNo(String itemNo) {
			this.itemNo = itemNo;
		}
		
		/*
		 * status
		 */
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		/*
		 * lastUpdateTime
		 */
		public String getLastUpdateTime() {
			return lastUpdateTime;
		}
		public void setLastUpdateTime(String lastUpdateTime) {
			this.lastUpdateTime = lastUpdateTime;
		}

    }

}
