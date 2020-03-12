//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 所產生 
// 請參閱 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2019.05.02 於 05:27:30 PM CST 
//


package internal.xml.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>MED_PO complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="MED_PO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HISPurchaseOrderUpdateRequest">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MesgInfo" type="{}messageInformation"/>
 *                   &lt;element name="HIS_PO" type="{}hp_todd" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;any processContents='lax'/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MED_PO", propOrder = {
    "hisPurchaseOrderUpdateRequest",
    "any"
})
public class MEDPO {

    @XmlElement(name = "HISPurchaseOrderUpdateRequest", required = true, nillable = true)
    protected MEDPO.HISPurchaseOrderUpdateRequest hisPurchaseOrderUpdateRequest;
    @XmlAnyElement(lax = true)
    protected Object any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * 取得 hisPurchaseOrderUpdateRequest 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link MEDPO.HISPurchaseOrderUpdateRequest }
     *     
     */
    public MEDPO.HISPurchaseOrderUpdateRequest getHISPurchaseOrderUpdateRequest() {
        return hisPurchaseOrderUpdateRequest;
    }

    /**
     * 設定 hisPurchaseOrderUpdateRequest 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link MEDPO.HISPurchaseOrderUpdateRequest }
     *     
     */
    public void setHISPurchaseOrderUpdateRequest(MEDPO.HISPurchaseOrderUpdateRequest value) {
        this.hisPurchaseOrderUpdateRequest = value;
    }

    /**
     * 取得 any 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link Element }
     *     {@link Object }
     *     
     */
    public Object getAny() {
        return any;
    }

    /**
     * 設定 any 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link Element }
     *     {@link Object }
     *     
     */
    public void setAny(Object value) {
        this.any = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }


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
    public static class HISPurchaseOrderUpdateRequest {

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

}
