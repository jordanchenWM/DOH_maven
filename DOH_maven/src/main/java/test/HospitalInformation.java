//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 所產生 
// 請參閱 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2020.03.09 於 05:11:34 PM CST 
//


package test;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>hospitalInformation complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="hospitalInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HospID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *         &lt;element name="PurchasingDept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Purchaser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReceiptDept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReceiptStaff" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hospitalInformation", propOrder = {
    "hospID",
    "purchasingDept",
    "purchaser",
    "receiptDept",
    "receiptStaff"
})
public class HospitalInformation {

    @XmlElement(name = "HospID", required = true, type = Long.class, nillable = true)
    @XmlSchemaType(name = "unsignedInt")
    protected Long hospID;
    @XmlElementRef(name = "PurchasingDept", type = JAXBElement.class, required = false)
    protected JAXBElement<String> purchasingDept;
    @XmlElementRef(name = "Purchaser", type = JAXBElement.class, required = false)
    protected JAXBElement<String> purchaser;
    @XmlElementRef(name = "ReceiptDept", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiptDept;
    @XmlElementRef(name = "ReceiptStaff", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiptStaff;

    /**
     * 取得 hospID 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHospID() {
        return hospID;
    }

    /**
     * 設定 hospID 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHospID(Long value) {
        this.hospID = value;
    }

    /**
     * 取得 purchasingDept 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPurchasingDept() {
        return purchasingDept;
    }

    /**
     * 設定 purchasingDept 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPurchasingDept(JAXBElement<String> value) {
        this.purchasingDept = value;
    }

    /**
     * 取得 purchaser 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPurchaser() {
        return purchaser;
    }

    /**
     * 設定 purchaser 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPurchaser(JAXBElement<String> value) {
        this.purchaser = value;
    }

    /**
     * 取得 receiptDept 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiptDept() {
        return receiptDept;
    }

    /**
     * 設定 receiptDept 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiptDept(JAXBElement<String> value) {
        this.receiptDept = value;
    }

    /**
     * 取得 receiptStaff 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiptStaff() {
        return receiptStaff;
    }

    /**
     * 設定 receiptStaff 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiptStaff(JAXBElement<String> value) {
        this.receiptStaff = value;
    }

}
