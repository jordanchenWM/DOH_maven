//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 所產生 
// 請參閱 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2020.03.03 於 04:11:52 PM CST 
//


package doc.xml.invoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rec_CCDReocvered", propOrder = {
    "refno",
    "version",
    "hosprgno",
    "allianceid",
    "receiptno",
    "newprice",
    "recoveredamount",
    "status",
    "flag"
})
public class RecCCDReocvered {

    @XmlElement(name = "REFNO", required = true, nillable = true)
    protected String refno;
    @XmlElement(name = "VERSION", required = true, nillable = true)
    protected String version;
    @XmlElement(name = "HOSPRGNO", required = true, nillable = true)
    protected String hosprgno;
    @XmlElement(name = "ALLIANCEID", required = true, nillable = true)
    protected String allianceid;
    @XmlElement(name = "RECEIPTNO", required = true, nillable = true)
    protected String receiptno;
    @XmlElement(name = "NEW_PRICE", required = true, nillable = true)
    protected String newprice;
    @XmlElement(name = "RECOVERED_AMOUNT", required = true, nillable = true)
    protected String recoveredamount;
    @XmlElement(name = "STATUS", required = true, nillable = true)
    protected String status;
    @XmlElement(name = "FLAG", required = true, nillable = true)
    protected String flag;
    
    /*
     * refno
     */
	public String getRefno() {
		return refno;
	}
	public void setRefno(String refno) {
		this.refno = refno;
	}
	
	/*
	 * version
	 */
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
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
	 * allianceid
	 */
	public String getAllianceid() {
		return allianceid;
	}
	public void setAllianceid(String allianceid) {
		this.allianceid = allianceid;
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
	 * newprice
	 */
	public String getNewprice() {
		return newprice;
	}
	public void setNewprice(String newprice) {
		this.newprice = newprice;
	}
	
	/*
	 * recoveredamount
	 */
	public String getRecoveredamount() {
		return recoveredamount;
	}
	public void setRecoveredamount(String recoveredamount) {
		this.recoveredamount = recoveredamount;
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
	 * flag
	 */
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

    
}
