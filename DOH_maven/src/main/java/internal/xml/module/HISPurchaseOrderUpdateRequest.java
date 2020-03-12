//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 所產生 
// 請參閱 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2019.05.02 於 05:27:30 PM CST 
//


package internal.xml.module;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MesgInfo" type="{}messageInformation"/>
 *         &lt;element name="HIS_PO" type="{}hp_todd" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mesgInfo",
    "hispo"
})
@XmlRootElement(name = "HISPurchaseOrderUpdateRequest")
public class HISPurchaseOrderUpdateRequest {

    @XmlElement(name = "MesgInfo", required = true, nillable = true)
    protected MessageInformation mesgInfo;
    @XmlElement(name = "HIS_PO", required = true, nillable = true)
    protected List<HpTodd> hispo;

    /**
     * 取得 mesgInfo 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link MessageInformation }
     *     
     */
    public MessageInformation getMesgInfo() {
        return mesgInfo;
    }

    /**
     * 設定 mesgInfo 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageInformation }
     *     
     */
    public void setMesgInfo(MessageInformation value) {
        this.mesgInfo = value;
    }

    /**
     * Gets the value of the hispo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hispo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHISPO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HpTodd }
     * 
     * 
     */
    public List<HpTodd> getHISPO() {
        if (hispo == null) {
            hispo = new ArrayList<HpTodd>();
        }
        return this.hispo;
    }

}
