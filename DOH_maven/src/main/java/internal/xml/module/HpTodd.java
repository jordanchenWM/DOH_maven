//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 所產生 
// 請參閱 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2019.05.02 於 05:27:30 PM CST 
//


package internal.xml.module;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>hp_todd complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="hp_todd">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="odd_no" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_item" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_ally_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_hospid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_acp_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_id_way" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_lab" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_sort" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_pur_dt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_gp_nm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_ctr_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_ctr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_bat_item" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_req_dt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_o_status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_b2b_yn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_vdr_no" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_d_brand" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_mtr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_desc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_spec" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_qty" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_um" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_price" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_inv_dt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_emg_yn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_lab_yn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_chef_nm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_s_dt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_s_time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_remark" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_alt_dt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_alt_time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_dis_rte" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_dis_amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_pay_amt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_disamt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_com_no" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odd_bat_remark" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
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

    /**
     * 取得 oddNo 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddNo() {
        return oddNo;
    }

    /**
     * 設定 oddNo 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddNo(String value) {
        this.oddNo = value;
    }

    /**
     * 取得 oddItem 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddItem() {
        return oddItem;
    }

    /**
     * 設定 oddItem 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddItem(String value) {
        this.oddItem = value;
    }

    /**
     * 取得 oddAllyId 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddAllyId() {
        return oddAllyId;
    }

    /**
     * 設定 oddAllyId 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddAllyId(String value) {
        this.oddAllyId = value;
    }

    /**
     * 取得 oddHospid 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddHospid() {
        return oddHospid;
    }

    /**
     * 設定 oddHospid 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddHospid(String value) {
        this.oddHospid = value;
    }

    /**
     * 取得 oddAcpId 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddAcpId() {
        return oddAcpId;
    }

    /**
     * 設定 oddAcpId 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddAcpId(String value) {
        this.oddAcpId = value;
    }

    /**
     * 取得 oddIdWay 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddIdWay() {
        return oddIdWay;
    }

    /**
     * 設定 oddIdWay 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddIdWay(String value) {
        this.oddIdWay = value;
    }

    /**
     * 取得 oddLab 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddLab() {
        return oddLab;
    }

    /**
     * 設定 oddLab 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddLab(String value) {
        this.oddLab = value;
    }

    /**
     * 取得 oddSort 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddSort() {
        return oddSort;
    }

    /**
     * 設定 oddSort 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddSort(String value) {
        this.oddSort = value;
    }

    /**
     * 取得 oddPurDt 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddPurDt() {
        return oddPurDt;
    }

    /**
     * 設定 oddPurDt 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddPurDt(String value) {
        this.oddPurDt = value;
    }

    /**
     * 取得 oddGpNm 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddGpNm() {
        return oddGpNm;
    }

    /**
     * 設定 oddGpNm 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddGpNm(String value) {
        this.oddGpNm = value;
    }

    /**
     * 取得 oddCtrId 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddCtrId() {
        return oddCtrId;
    }

    /**
     * 設定 oddCtrId 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddCtrId(String value) {
        this.oddCtrId = value;
    }

    /**
     * 取得 oddCtr 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddCtr() {
        return oddCtr;
    }

    /**
     * 設定 oddCtr 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddCtr(String value) {
        this.oddCtr = value;
    }

    /**
     * 取得 oddBatItem 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddBatItem() {
        return oddBatItem;
    }

    /**
     * 設定 oddBatItem 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddBatItem(String value) {
        this.oddBatItem = value;
    }

    /**
     * 取得 oddReqDt 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddReqDt() {
        return oddReqDt;
    }

    /**
     * 設定 oddReqDt 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddReqDt(String value) {
        this.oddReqDt = value;
    }

    /**
     * 取得 oddStatus 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddStatus() {
        return oddStatus;
    }

    /**
     * 設定 oddStatus 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddStatus(String value) {
        this.oddStatus = value;
    }

    /**
     * 取得 oddOStatus 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddOStatus() {
        return oddOStatus;
    }

    /**
     * 設定 oddOStatus 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddOStatus(String value) {
        this.oddOStatus = value;
    }

    /**
     * 取得 oddB2BYn 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddB2BYn() {
        return oddB2BYn;
    }

    /**
     * 設定 oddB2BYn 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddB2BYn(String value) {
        this.oddB2BYn = value;
    }

    /**
     * 取得 oddVdrNo 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddVdrNo() {
        return oddVdrNo;
    }

    /**
     * 設定 oddVdrNo 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddVdrNo(String value) {
        this.oddVdrNo = value;
    }

    /**
     * 取得 oddDBrand 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddDBrand() {
        return oddDBrand;
    }

    /**
     * 設定 oddDBrand 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddDBrand(String value) {
        this.oddDBrand = value;
    }

    /**
     * 取得 oddMtr 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddMtr() {
        return oddMtr;
    }

    /**
     * 設定 oddMtr 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddMtr(String value) {
        this.oddMtr = value;
    }

    /**
     * 取得 oddDesc 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddDesc() {
        return oddDesc;
    }

    /**
     * 設定 oddDesc 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddDesc(String value) {
        this.oddDesc = value;
    }

    /**
     * 取得 oddSpec 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddSpec() {
        return oddSpec;
    }

    /**
     * 設定 oddSpec 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddSpec(String value) {
        this.oddSpec = value;
    }

    /**
     * 取得 oddQty 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddQty() {
        return oddQty;
    }

    /**
     * 設定 oddQty 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddQty(String value) {
        this.oddQty = value;
    }

    /**
     * 取得 oddUm 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddUm() {
        return oddUm;
    }

    /**
     * 設定 oddUm 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddUm(String value) {
        this.oddUm = value;
    }

    /**
     * 取得 oddPrice 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddPrice() {
        return oddPrice;
    }

    /**
     * 設定 oddPrice 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddPrice(String value) {
        this.oddPrice = value;
    }

    /**
     * 取得 oddAmt 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddAmt() {
        return oddAmt;
    }

    /**
     * 設定 oddAmt 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddAmt(String value) {
        this.oddAmt = value;
    }

    /**
     * 取得 oddInvDt 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddInvDt() {
        return oddInvDt;
    }

    /**
     * 設定 oddInvDt 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddInvDt(String value) {
        this.oddInvDt = value;
    }

    /**
     * 取得 oddEmgYn 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddEmgYn() {
        return oddEmgYn;
    }

    /**
     * 設定 oddEmgYn 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddEmgYn(String value) {
        this.oddEmgYn = value;
    }

    /**
     * 取得 oddLabYn 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddLabYn() {
        return oddLabYn;
    }

    /**
     * 設定 oddLabYn 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddLabYn(String value) {
        this.oddLabYn = value;
    }

    /**
     * 取得 oddChefNm 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddChefNm() {
        return oddChefNm;
    }

    /**
     * 設定 oddChefNm 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddChefNm(String value) {
        this.oddChefNm = value;
    }

    /**
     * 取得 oddSDt 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddSDt() {
        return oddSDt;
    }

    /**
     * 設定 oddSDt 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddSDt(String value) {
        this.oddSDt = value;
    }

    /**
     * 取得 oddSTime 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddSTime() {
        return oddSTime;
    }

    /**
     * 設定 oddSTime 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddSTime(String value) {
        this.oddSTime = value;
    }

    /**
     * 取得 oddRemark 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddRemark() {
        return oddRemark;
    }

    /**
     * 設定 oddRemark 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddRemark(String value) {
        this.oddRemark = value;
    }

    /**
     * 取得 oddAltDt 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddAltDt() {
        return oddAltDt;
    }

    /**
     * 設定 oddAltDt 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddAltDt(String value) {
        this.oddAltDt = value;
    }

    /**
     * 取得 oddAltTime 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddAltTime() {
        return oddAltTime;
    }

    /**
     * 設定 oddAltTime 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddAltTime(String value) {
        this.oddAltTime = value;
    }

    /**
     * 取得 oddDisRte 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddDisRte() {
        return oddDisRte;
    }

    /**
     * 設定 oddDisRte 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddDisRte(String value) {
        this.oddDisRte = value;
    }

    /**
     * 取得 oddDisAmt 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddDisAmt() {
        return oddDisAmt;
    }

    /**
     * 設定 oddDisAmt 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddDisAmt(String value) {
        this.oddDisAmt = value;
    }

    /**
     * 取得 oddPayAmt 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddPayAmt() {
        return oddPayAmt;
    }

    /**
     * 設定 oddPayAmt 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddPayAmt(String value) {
        this.oddPayAmt = value;
    }

    /**
     * 取得 oddDisamt 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddDisamt() {
        return oddDisamt;
    }

    /**
     * 設定 oddDisamt 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddDisamt(String value) {
        this.oddDisamt = value;
    }

    /**
     * 取得 oddComNo 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddComNo() {
        return oddComNo;
    }

    /**
     * 設定 oddComNo 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddComNo(String value) {
        this.oddComNo = value;
    }

    /**
     * 取得 oddBatRemark 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddBatRemark() {
        return oddBatRemark;
    }

    /**
     * 設定 oddBatRemark 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddBatRemark(String value) {
        this.oddBatRemark = value;
    }

}
