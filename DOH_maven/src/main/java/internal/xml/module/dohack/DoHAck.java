//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 所產生 
// 請參閱 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2020.02.26 於 06:03:55 PM CST 
//


package internal.xml.module.dohack;

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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}MessageInfo"/&gt;
 *         &lt;element name="DocumentInfo"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="DocumentNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="LastUpdateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="TransmissionCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ItemInfo" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ItemNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="LastUpdateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="TransmissionCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "messageInfo",
    "documentInfo",
    "itemInfo"
})
@XmlRootElement(name = "DoHAck")
public class DoHAck {

    @XmlElement(name = "MessageInfo", namespace = "", required = true)
    protected MessageInfo messageInfo;
    @XmlElement(name = "DocumentInfo", required = true)
    protected DoHAck.DocumentInfo documentInfo;
    @XmlElement(name = "ItemInfo")
    protected List<DoHAck.ItemInfo> itemInfo;

    /**
     * 取得 messageInfo 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link MessageInfo }
     *     
     */
    public MessageInfo getMessageInfo() {
        return messageInfo;
    }

    /**
     * 設定 messageInfo 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageInfo }
     *     
     */
    public void setMessageInfo(MessageInfo value) {
        this.messageInfo = value;
    }

    /**
     * 取得 documentInfo 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link DoHAck.DocumentInfo }
     *     
     */
    public DoHAck.DocumentInfo getDocumentInfo() {
        return documentInfo;
    }

    /**
     * 設定 documentInfo 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link DoHAck.DocumentInfo }
     *     
     */
    public void setDocumentInfo(DoHAck.DocumentInfo value) {
        this.documentInfo = value;
    }

    /**
     * Gets the value of the itemInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DoHAck.ItemInfo }
     * 
     * 
     */
    public List<DoHAck.ItemInfo> getItemInfo() {
        if (itemInfo == null) {
            itemInfo = new ArrayList<DoHAck.ItemInfo>();
        }
        return this.itemInfo;
    }


    /**
     * <p>anonymous complex type 的 Java 類別.
     * 
     * <p>下列綱要片段會指定此類別中包含的預期內容.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="DocumentNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="LastUpdateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="TransmissionCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "documentNo",
        "status",
        "lastUpdateTime",
        "transmissionCode"
    })
    public static class DocumentInfo {

        @XmlElement(name = "DocumentNo", required = true)
        protected String documentNo;
        @XmlElement(name = "Status")
        protected String status;
        @XmlElement(name = "LastUpdateTime")
        protected String lastUpdateTime;
        @XmlElement(name = "TransmissionCode", required = true)
        protected String transmissionCode;

        /**
         * 取得 documentNo 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDocumentNo() {
            return documentNo;
        }

        /**
         * 設定 documentNo 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDocumentNo(String value) {
            this.documentNo = value;
        }

        /**
         * 取得 status 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatus() {
            return status;
        }

        /**
         * 設定 status 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatus(String value) {
            this.status = value;
        }

        /**
         * 取得 lastUpdateTime 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLastUpdateTime() {
            return lastUpdateTime;
        }

        /**
         * 設定 lastUpdateTime 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLastUpdateTime(String value) {
            this.lastUpdateTime = value;
        }

        /**
         * 取得 transmissionCode 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransmissionCode() {
            return transmissionCode;
        }

        /**
         * 設定 transmissionCode 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransmissionCode(String value) {
            this.transmissionCode = value;
        }

    }


    /**
     * <p>anonymous complex type 的 Java 類別.
     * 
     * <p>下列綱要片段會指定此類別中包含的預期內容.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ItemNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="LastUpdateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="TransmissionCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "itemNo",
        "status",
        "lastUpdateTime",
        "transmissionCode"
    })
    public static class ItemInfo {

        @XmlElement(name = "ItemNo", required = true)
        protected String itemNo;
        @XmlElement(name = "Status")
        protected String status;
        @XmlElement(name = "LastUpdateTime")
        protected String lastUpdateTime;
        @XmlElement(name = "TransmissionCode", required = true)
        protected String transmissionCode;

        /**
         * 取得 itemNo 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getItemNo() {
            return itemNo;
        }

        /**
         * 設定 itemNo 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setItemNo(String value) {
            this.itemNo = value;
        }

        /**
         * 取得 status 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatus() {
            return status;
        }

        /**
         * 設定 status 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatus(String value) {
            this.status = value;
        }

        /**
         * 取得 lastUpdateTime 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLastUpdateTime() {
            return lastUpdateTime;
        }

        /**
         * 設定 lastUpdateTime 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLastUpdateTime(String value) {
            this.lastUpdateTime = value;
        }

        /**
         * 取得 transmissionCode 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransmissionCode() {
            return transmissionCode;
        }

        /**
         * 設定 transmissionCode 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransmissionCode(String value) {
            this.transmissionCode = value;
        }

    }

}
