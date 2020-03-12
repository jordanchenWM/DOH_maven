//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 所產生 
// 請參閱 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2019.05.02 於 05:27:30 PM CST 
//


package doc.xml.purchaseOrder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hp_todd", propOrder = {
    "oddNo",
    "oddItem",
    "oddAllyId",
    "oddHospid",
    "oddAcpId",
    "oddIdWay",
    "oddLab",
    "oddSort",
    "oddPurDt",
    "oddGpNm",
    "oddCtrId",
    "oddCtr",
    "oddBatItem",
    "oddReqDt",
    "oddStatus",
    "oddOStatus",
    "oddB2BYn",
    "oddVdrNo",
    "oddDBrand",
    "oddMtr",
    "oddDesc",
    "oddSpec",
    "oddQty",
    "oddUm",
    "oddPrice",
    "oddAmt",
    "oddInvDt",
    "oddEmgYn",
    "oddLabYn",
    "oddChefNm",
    "oddSDt",
    "oddSTime",
    "oddRemark",
    "oddAltDt",
    "oddAltTime",
    "oddDisRte",
    "oddDisAmt",
    "oddPayAmt",
    "oddDisamt",
    "oddComNo",
    "oddBatRemark"
})
public class HpTodd {

    @XmlElement(name = "odd_no", required = true, nillable = true)
    protected String oddNo;
    @XmlElement(name = "odd_item", required = true, nillable = true)
    protected String oddItem;
    @XmlElement(name = "odd_ally_id", required = true, nillable = true)
    protected String oddAllyId;
    @XmlElement(name = "odd_hospid", required = true, nillable = true)
    protected String oddHospid;
    @XmlElement(name = "odd_acp_id", required = true, nillable = true)
    protected String oddAcpId;
    @XmlElement(name = "odd_id_way", required = true, nillable = true)
    protected String oddIdWay;
    @XmlElement(name = "odd_lab", required = true, nillable = true)
    protected String oddLab;
    @XmlElement(name = "odd_sort", required = true, nillable = true)
    protected String oddSort;
    @XmlElement(name = "odd_pur_dt", required = true, nillable = true)
    protected String oddPurDt;
    @XmlElement(name = "odd_gp_nm", required = true, nillable = true)
    protected String oddGpNm;
    @XmlElement(name = "odd_ctr_id", required = true, nillable = true)
    protected String oddCtrId;
    @XmlElement(name = "odd_ctr", required = true, nillable = true)
    protected String oddCtr;
    @XmlElement(name = "odd_bat_item", required = true, nillable = true)
    protected String oddBatItem;
    @XmlElement(name = "odd_req_dt", required = true, nillable = true)
    protected String oddReqDt;
    @XmlElement(name = "odd_status", required = true, nillable = true)
    protected String oddStatus;
    @XmlElement(name = "odd_o_status", required = true, nillable = true)
    protected String oddOStatus;
    @XmlElement(name = "odd_b2b_yn", required = true, nillable = true)
    protected String oddB2BYn;
    @XmlElement(name = "odd_vdr_no", required = true, nillable = true)
    protected String oddVdrNo;
    @XmlElement(name = "odd_d_brand", required = true, nillable = true)
    protected String oddDBrand;
    @XmlElement(name = "odd_mtr", required = true, nillable = true)
    protected String oddMtr;
    @XmlElement(name = "odd_desc", required = true, nillable = true)
    protected String oddDesc;
    @XmlElement(name = "odd_spec", required = true, nillable = true)
    protected String oddSpec;
    @XmlElement(name = "odd_qty", required = true, nillable = true)
    protected String oddQty;
    @XmlElement(name = "odd_um", required = true, nillable = true)
    protected String oddUm;
    @XmlElement(name = "odd_price", required = true, nillable = true)
    protected String oddPrice;
    @XmlElement(name = "odd_amt", required = true, nillable = true)
    protected String oddAmt;
    @XmlElement(name = "odd_inv_dt", required = true, nillable = true)
    protected String oddInvDt;
    @XmlElement(name = "odd_emg_yn", required = true, nillable = true)
    protected String oddEmgYn;
    @XmlElement(name = "odd_lab_yn", required = true, nillable = true)
    protected String oddLabYn;
    @XmlElement(name = "odd_chef_nm", required = true, nillable = true)
    protected String oddChefNm;
    @XmlElement(name = "odd_s_dt", required = true, nillable = true)
    protected String oddSDt;
    @XmlElement(name = "odd_s_time", required = true, nillable = true)
    protected String oddSTime;
    @XmlElement(name = "odd_remark", required = true, nillable = true)
    protected String oddRemark;
    @XmlElement(name = "odd_alt_dt", required = true, nillable = true)
    protected String oddAltDt;
    @XmlElement(name = "odd_alt_time", required = true, nillable = true)
    protected String oddAltTime;
    @XmlElement(name = "odd_dis_rte", required = true, nillable = true)
    protected String oddDisRte;
    @XmlElement(name = "odd_dis_amt", required = true, nillable = true)
    protected String oddDisAmt;
    @XmlElement(name = "odd_pay_amt", required = true, nillable = true)
    protected String oddPayAmt;
    @XmlElement(name = "odd_disamt", required = true, nillable = true)
    protected String oddDisamt;
    @XmlElement(name = "odd_com_no", required = true, nillable = true)
    protected String oddComNo;
    @XmlElement(name = "odd_bat_remark", required = true, nillable = true)
    protected String oddBatRemark;
    
    /*
     * oddNo
     */
	public String getOddNo() {
		return oddNo;
	}
	public void setOddNo(String oddNo) {
		this.oddNo = oddNo;
	}
	
	/*
	 * oddItem
	 */
	public String getOddItem() {
		return oddItem;
	}
	public void setOddItem(String oddItem) {
		this.oddItem = oddItem;
	}
	
	/*
	 * oddAllyId
	 */
	public String getOddAllyId() {
		return oddAllyId;
	}
	public void setOddAllyId(String oddAllyId) {
		this.oddAllyId = oddAllyId;
	}
	
	/*
	 * oddHospid
	 */
	public String getOddHospid() {
		return oddHospid;
	}
	public void setOddHospid(String oddHospid) {
		this.oddHospid = oddHospid;
	}
	
	/*
	 * oddAcpId
	 */
	public String getOddAcpId() {
		return oddAcpId;
	}
	public void setOddAcpId(String oddAcpId) {
		this.oddAcpId = oddAcpId;
	}
	
	/*
	 * oddIdWay
	 */
	public String getOddIdWay() {
		return oddIdWay;
	}
	public void setOddIdWay(String oddIdWay) {
		this.oddIdWay = oddIdWay;
	}
	
	/*
	 * oddLab
	 */
	public String getOddLab() {
		return oddLab;
	}
	public void setOddLab(String oddLab) {
		this.oddLab = oddLab;
	}
	
	/*
	 * oddSort
	 */
	public String getOddSort() {
		return oddSort;
	}
	public void setOddSort(String oddSort) {
		this.oddSort = oddSort;
	}
	
	/*
	 * oddPurDt
	 */
	public String getOddPurDt() {
		return oddPurDt;
	}
	public void setOddPurDt(String oddPurDt) {
		this.oddPurDt = oddPurDt;
	}
	
	/*
	 * oddGpNm
	 */
	public String getOddGpNm() {
		return oddGpNm;
	}
	public void setOddGpNm(String oddGpNm) {
		this.oddGpNm = oddGpNm;
	}
	
	/*
	 * oddCtrId
	 */
	public String getOddCtrId() {
		return oddCtrId;
	}
	public void setOddCtrId(String oddCtrId) {
		this.oddCtrId = oddCtrId;
	}
	
	/*
	 * oddCtr
	 */
	public String getOddCtr() {
		return oddCtr;
	}
	public void setOddCtr(String oddCtr) {
		this.oddCtr = oddCtr;
	}
	
	/*
	 * oddBatItem
	 */
	public String getOddBatItem() {
		return oddBatItem;
	}
	public void setOddBatItem(String oddBatItem) {
		this.oddBatItem = oddBatItem;
	}
	
	/*
	 * oddReqDt
	 */
	public String getOddReqDt() {
		return oddReqDt;
	}
	public void setOddReqDt(String oddReqDt) {
		this.oddReqDt = oddReqDt;
	}
	
	/*oddStatus
	 * 
	 */
	public String getOddStatus() {
		return oddStatus;
	}
	public void setOddStatus(String oddStatus) {
		this.oddStatus = oddStatus;
	}
	
	/*
	 * oddOStatus
	 */
	public String getOddOStatus() {
		return oddOStatus;
	}
	public void setOddOStatus(String oddOStatus) {
		this.oddOStatus = oddOStatus;
	}
	
	/*
	 * oddB2BYn
	 */
	public String getOddB2BYn() {
		return oddB2BYn;
	}
	public void setOddB2BYn(String oddB2BYn) {
		this.oddB2BYn = oddB2BYn;
	}
	
	/*
	 * oddVdrNo
	 */
	public String getOddVdrNo() {
		return oddVdrNo;
	}
	public void setOddVdrNo(String oddVdrNo) {
		this.oddVdrNo = oddVdrNo;
	}
	
	/*
	 * oddDBrand
	 */
	public String getOddDBrand() {
		return oddDBrand;
	}
	public void setOddDBrand(String oddDBrand) {
		this.oddDBrand = oddDBrand;
	}
	
	/*
	 * oddMtr
	 */
	public String getOddMtr() {
		return oddMtr;
	}
	public void setOddMtr(String oddMtr) {
		this.oddMtr = oddMtr;
	}
	
	//
	public String getOddDesc() {
		return oddDesc;
	}
	public void setOddDesc(String oddDesc) {
		this.oddDesc = oddDesc;
	}
	
	//
	public String getOddSpec() {
		return oddSpec;
	}
	public void setOddSpec(String oddSpec) {
		this.oddSpec = oddSpec;
	}
	
	//
	public String getOddQty() {
		return oddQty;
	}
	public void setOddQty(String oddQty) {
		this.oddQty = oddQty;
	}
	
	//
	public String getOddUm() {
		return oddUm;
	}
	public void setOddUm(String oddUm) {
		this.oddUm = oddUm;
	}
	
	//
	public String getOddPrice() {
		return oddPrice;
	}
	public void setOddPrice(String oddPrice) {
		this.oddPrice = oddPrice;
	}
	
	//
	public String getOddAmt() {
		return oddAmt;
	}
	public void setOddAmt(String oddAmt) {
		this.oddAmt = oddAmt;
	}
	
	//
	public String getOddInvDt() {
		return oddInvDt;
	}
	public void setOddInvDt(String oddInvDt) {
		this.oddInvDt = oddInvDt;
	}
	
	//
	public String getOddEmgYn() {
		return oddEmgYn;
	}
	public void setOddEmgYn(String oddEmgYn) {
		this.oddEmgYn = oddEmgYn;
	}
	
	//
	public String getOddLabYn() {
		return oddLabYn;
	}
	public void setOddLabYn(String oddLabYn) {
		this.oddLabYn = oddLabYn;
	}
	
	//
	public String getOddChefNm() {
		return oddChefNm;
	}
	public void setOddChefNm(String oddChefNm) {
		this.oddChefNm = oddChefNm;
	}
	
	//
	public String getOddSDt() {
		return oddSDt;
	}
	public void setOddSDt(String oddSDt) {
		this.oddSDt = oddSDt;
	}
	
	//
	public String getOddSTime() {
		return oddSTime;
	}
	public void setOddSTime(String oddSTime) {
		this.oddSTime = oddSTime;
	}
	
	//
	public String getOddRemark() {
		return oddRemark;
	}
	public void setOddRemark(String oddRemark) {
		this.oddRemark = oddRemark;
	}
	
	//
	public String getOddAltDt() {
		return oddAltDt;
	}
	public void setOddAltDt(String oddAltDt) {
		this.oddAltDt = oddAltDt;
	}
	
	//
	public String getOddAltTime() {
		return oddAltTime;
	}
	public void setOddAltTime(String oddAltTime) {
		this.oddAltTime = oddAltTime;
	}
	
	//
	public String getOddDisRte() {
		return oddDisRte;
	}
	public void setOddDisRte(String oddDisRte) {
		this.oddDisRte = oddDisRte;
	}
	
	//
	public String getOddDisAmt() {
		return oddDisAmt;
	}
	public void setOddDisAmt(String oddDisAmt) {
		this.oddDisAmt = oddDisAmt;
	}
	
	//
	public String getOddPayAmt() {
		return oddPayAmt;
	}
	public void setOddPayAmt(String oddPayAmt) {
		this.oddPayAmt = oddPayAmt;
	}
	
	//
	public String getOddDisamt() {
		return oddDisamt;
	}
	public void setOddDisamt(String oddDisamt) {
		this.oddDisamt = oddDisamt;
	}
	
	//
	public String getOddComNo() {
		return oddComNo;
	}
	public void setOddComNo(String oddComNo) {
		this.oddComNo = oddComNo;
	}
	
	//
	public String getOddBatRemark() {
		return oddBatRemark;
	}
	public void setOddBatRemark(String oddBatRemark) {
		this.oddBatRemark = oddBatRemark;
	}  

}
