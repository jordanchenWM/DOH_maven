//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 所產生 
// 請參閱 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2020.02.26 於 09:25:44 AM CST 
//


package internal.xml.module.matporequest;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MaterialInfo complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="MaterialInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BatchLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BatchNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaterialType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaterialCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaterialBrand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaterialName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaterialSpec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaterialUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaterialPackage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ComputerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InsuranceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PERMIT_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PERMIT_KIND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PERMIT_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PERMIT_DEADLINE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NATIONALID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FORMULATION_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FORMULATION_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CLASSID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CLASSNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TRANS_RATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ESTIMATE_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="INGREDIENT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TRANS_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PRIZE_NO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BID_START_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BID_END_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SHAPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MaterialInfo", propOrder = {
    "batchLabel",
    "batchNo",
    "materialType",
    "materialCode",
    "materialBrand",
    "materialName",
    "materialSpec",
    "materialUnit",
    "materialPackage",
    "computerCode",
    "insuranceID",
    "permitid",
    "permitkind",
    "permitnumber",
    "permitdeadline",
    "nationalid",
    "nationality",
    "formulationtype",
    "formulationname",
    "classid",
    "classname",
    "transrate",
    "estimateamount",
    "ingredient",
    "transtype",
    "prizeno",
    "bidstartdate",
    "bidenddate",
    "shape"
})
public class MaterialInfo {

	@XmlElement(name = "BatchLabel", required = true)
    protected String batchLabel;
    @XmlElement(name = "BatchNo", required = true)
    protected String batchNo;
    @XmlElement(name = "MaterialType", required = true)
    protected String materialType;
    @XmlElement(name = "MaterialCode", required = true)
    protected String materialCode;
    @XmlElement(name = "MaterialBrand", required = true)
    protected String materialBrand;
    @XmlElement(name = "MaterialName", required = true)
    protected String materialName;
    @XmlElement(name = "MaterialSpec", required = true)
    protected String materialSpec;
    @XmlElement(name = "MaterialUnit", required = true)
    protected String materialUnit;
    @XmlElement(name = "MaterialPackage", required = true)
    protected String materialPackage;
    @XmlElement(name = "ComputerCode", required = true)
    protected String computerCode;
    @XmlElement(name = "InsuranceID", required = true)
    protected String insuranceID;
    @XmlElement(name = "PERMIT_ID", required = true)
    protected String permitid;
    @XmlElement(name = "PERMIT_KIND", required = true)
    protected String permitkind;
    @XmlElement(name = "PERMIT_NUMBER", required = true)
    protected String permitnumber;
    @XmlElement(name = "PERMIT_DEADLINE", required = true)
    protected String permitdeadline;
    @XmlElement(name = "NATIONALID", required = true)
    protected String nationalid;
    @XmlElement(name = "NATIONALITY", required = true)
    protected String nationality;
    @XmlElement(name = "FORMULATION_TYPE", required = true)
    protected String formulationtype;
    @XmlElement(name = "FORMULATION_NAME", required = true)
    protected String formulationname;
    @XmlElement(name = "CLASSID", required = true)
    protected String classid;
    @XmlElement(name = "CLASSNAME", required = true)
    protected String classname;
    @XmlElement(name = "TRANS_RATE", required = true)
    protected String transrate;
    @XmlElement(name = "ESTIMATE_AMOUNT", required = true)
    protected String estimateamount;
    @XmlElement(name = "INGREDIENT", required = true)
    protected String ingredient;
    @XmlElement(name = "TRANS_TYPE", required = true)
    protected String transtype;
    @XmlElement(name = "PRIZE_NO", required = true)
    protected String prizeno;
    @XmlElement(name = "BID_START_DATE")
    protected String bidstartdate;
    @XmlElement(name = "BID_END_DATE", required = true)
    protected String bidenddate;
    @XmlElement(name = "SHAPE", required = true)
    protected String shape;
    
	public String getBatchLabel() {
		return batchLabel;
	}
	public void setBatchLabel(String batchLabel) {
		this.batchLabel = batchLabel;
	}
	
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	public String getMaterialType() {
		return materialType;
	}
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
	
	public String getMaterialCode() {
		return materialCode;
	}
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
	
	public String getMaterialBrand() {
		return materialBrand;
	}
	public void setMaterialBrand(String materialBrand) {
		this.materialBrand = materialBrand;
	}
	
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	
	public String getMaterialSpec() {
		return materialSpec;
	}
	public void setMaterialSpec(String materialSpec) {
		this.materialSpec = materialSpec;
	}
	
	public String getMaterialUnit() {
		return materialUnit;
	}
	public void setMaterialUnit(String materialUnit) {
		this.materialUnit = materialUnit;
	}
	
	public String getMaterialPackage() {
		return materialPackage;
	}
	public void setMaterialPackage(String materialPackage) {
		this.materialPackage = materialPackage;
	}
	
	public String getComputerCode() {
		return computerCode;
	}
	public void setComputerCode(String computerCode) {
		this.computerCode = computerCode;
	}
	
	public String getInsuranceID() {
		return insuranceID;
	}
	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}
	
	public String getPermitid() {
		return permitid;
	}
	public void setPermitid(String permitid) {
		this.permitid = permitid;
	}
	
	public String getPermitkind() {
		return permitkind;
	}
	public void setPermitkind(String permitkind) {
		this.permitkind = permitkind;
	}
	
	public String getPermitnumber() {
		return permitnumber;
	}
	public void setPermitnumber(String permitnumber) {
		this.permitnumber = permitnumber;
	}
	
	public String getPermitdeadline() {
		return permitdeadline;
	}
	public void setPermitdeadline(String permitdeadline) {
		this.permitdeadline = permitdeadline;
	}
	
	public String getNationalid() {
		return nationalid;
	}
	public void setNationalid(String nationalid) {
		this.nationalid = nationalid;
	}
	
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getFormulationtype() {
		return formulationtype;
	}
	public void setFormulationtype(String formulationtype) {
		this.formulationtype = formulationtype;
	}
	
	public String getFormulationname() {
		return formulationname;
	}
	public void setFormulationname(String formulationname) {
		this.formulationname = formulationname;
	}
	
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	
	public String getTransrate() {
		return transrate;
	}
	public void setTransrate(String transrate) {
		this.transrate = transrate;
	}
	
	public String getEstimateamount() {
		return estimateamount;
	}
	public void setEstimateamount(String estimateamount) {
		this.estimateamount = estimateamount;
	}
	
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	
	public String getTranstype() {
		return transtype;
	}
	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}
	
	public String getPrizeno() {
		return prizeno;
	}
	public void setPrizeno(String prizeno) {
		this.prizeno = prizeno;
	}
	
	public String getBidstartdate() {
		return bidstartdate;
	}
	public void setBidstartdate(String bidstartdate) {
		this.bidstartdate = bidstartdate;
	}
	
	public String getBidenddate() {
		return bidenddate;
	}
	public void setBidenddate(String bidenddate) {
		this.bidenddate = bidenddate;
	}
	
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	

}
