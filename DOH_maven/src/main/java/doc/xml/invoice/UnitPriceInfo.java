package doc.xml.invoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "unreceiptno",
    "receiptno",
    "hospid",
    "hosprgno",
    "processid",
    "confirmby",
    "confirmtime",
    "memo",
    "flag"
})
public class UnitPriceInfo {

    @XmlElement(name = "UNRECEIPTNO", required = true, nillable = true)
    protected String unreceiptno;
    @XmlElement(name = "RECEIPTNO", required = true, nillable = true)
    protected String receiptno;
    @XmlElement(name = "HOSPID", required = true, nillable = true)
    protected String hospid;
    @XmlElement(name = "HOSPRGNO", required = true, nillable = true)
    protected String hosprgno;
    @XmlElement(name = "PROCESSID", required = true, nillable = true)
    protected String processid;
    @XmlElement(name = "CONFIRMBY", required = true, nillable = true)
    protected String confirmby;
    @XmlElement(name = "CONFIRMTIME", required = true, nillable = true)
    protected String confirmtime;
    @XmlElement(name = "MEMO", required = true, nillable = true)
    protected String memo;
    @XmlElement(name = "FLAG", required = true, nillable = true)
    protected String flag;
    
    /*
     * unreceiptno
     */
	public String getUnreceiptno() {
		return unreceiptno;
	}
	public void setUnreceiptno(String unreceiptno) {
		this.unreceiptno = unreceiptno;
	}
	
	/*
	 * receiptno
	 */
	public String getReceiptno() {
		return receiptno;
	}
	public void setReceiptno(String receiptno) {
		this.receiptno = receiptno;
	}
	
	/*
	 * hospid
	 */
	public String getHospid() {
		return hospid;
	}
	public void setHospid(String hospid) {
		this.hospid = hospid;
	}
	
	/*
	 * hosprgno
	 */
	public String getHosprgno() {
		return hosprgno;
	}
	public void setHosprgno(String hosprgno) {
		this.hosprgno = hosprgno;
	}
	
	/*
	 * processid
	 */
	public String getProcessid() {
		return processid;
	}
	public void setProcessid(String processid) {
		this.processid = processid;
	}
	
	/*
	 * confirmby
	 */
	public String getConfirmby() {
		return confirmby;
	}
	public void setConfirmby(String confirmby) {
		this.confirmby = confirmby;
	}
	
	/*
	 * confirmtime
	 */
	public String getConfirmtime() {
		return confirmtime;
	}
	public void setConfirmtime(String confirmtime) {
		this.confirmtime = confirmtime;
	}
	
	/*
	 * memo
	 */
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	/*
	 * flag
	 */
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

    

}
