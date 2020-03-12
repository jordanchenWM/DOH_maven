//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 所產生 
// 請參閱 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2020.03.09 於 05:11:34 PM CST 
//


package test;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MEDPORequest complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="MEDPORequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PurchaseOrder"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="MesgInfo" type="{}messageInformation"/&gt;
 *                   &lt;element name="Header"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="DocInfo" type="{}rec_documentInformation"/&gt;
 *                             &lt;element name="HospInfo" type="{}hospitalInformation"/&gt;
 *                             &lt;element name="VendorInfo" type="{}vendorInformation"/&gt;
 *                             &lt;element name="StatusInfo" type="{}statusInformation"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Items" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="ItemInfo" type="{}rec_itemInformation"/&gt;
 *                             &lt;element name="MedInfo" type="{}medicineInformation"/&gt;
 *                             &lt;element name="OrderInfo" type="{}rec_orderInformation"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
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
@XmlType(name = "MEDPORequest", propOrder = {
    "purchaseOrder"
})
public class MEDPORequest {

    @XmlElement(name = "PurchaseOrder", required = true, nillable = true)
    protected MEDPORequest.PurchaseOrder purchaseOrder;

    /**
     * 取得 purchaseOrder 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link MEDPORequest.PurchaseOrder }
     *     
     */
    public MEDPORequest.PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    /**
     * 設定 purchaseOrder 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link MEDPORequest.PurchaseOrder }
     *     
     */
    public void setPurchaseOrder(MEDPORequest.PurchaseOrder value) {
        this.purchaseOrder = value;
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
     *         &lt;element name="MesgInfo" type="{}messageInformation"/&gt;
     *         &lt;element name="Header"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="DocInfo" type="{}rec_documentInformation"/&gt;
     *                   &lt;element name="HospInfo" type="{}hospitalInformation"/&gt;
     *                   &lt;element name="VendorInfo" type="{}vendorInformation"/&gt;
     *                   &lt;element name="StatusInfo" type="{}statusInformation"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Items" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ItemInfo" type="{}rec_itemInformation"/&gt;
     *                   &lt;element name="MedInfo" type="{}medicineInformation"/&gt;
     *                   &lt;element name="OrderInfo" type="{}rec_orderInformation"/&gt;
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
        "mesgInfo",
        "header",
        "items"
    })
    public static class PurchaseOrder {

        @XmlElement(name = "MesgInfo", required = true, nillable = true)
        protected MessageInformation mesgInfo;
        @XmlElement(name = "Header", required = true, nillable = true)
        protected MEDPORequest.PurchaseOrder.Header header;
        @XmlElement(name = "Items", required = true, nillable = true)
        protected List<MEDPORequest.PurchaseOrder.Items> items;

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
         * 取得 header 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link MEDPORequest.PurchaseOrder.Header }
         *     
         */
        public MEDPORequest.PurchaseOrder.Header getHeader() {
            return header;
        }

        /**
         * 設定 header 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link MEDPORequest.PurchaseOrder.Header }
         *     
         */
        public void setHeader(MEDPORequest.PurchaseOrder.Header value) {
            this.header = value;
        }

        /**
         * Gets the value of the items property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the items property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItems().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MEDPORequest.PurchaseOrder.Items }
         * 
         * 
         */
        public List<MEDPORequest.PurchaseOrder.Items> getItems() {
            if (items == null) {
                items = new ArrayList<MEDPORequest.PurchaseOrder.Items>();
            }
            return this.items;
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
         *         &lt;element name="DocInfo" type="{}rec_documentInformation"/&gt;
         *         &lt;element name="HospInfo" type="{}hospitalInformation"/&gt;
         *         &lt;element name="VendorInfo" type="{}vendorInformation"/&gt;
         *         &lt;element name="StatusInfo" type="{}statusInformation"/&gt;
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
            "docInfo",
            "hospInfo",
            "vendorInfo",
            "statusInfo"
        })
        public static class Header {

            @XmlElement(name = "DocInfo", required = true, nillable = true)
            protected RecDocumentInformation docInfo;
            @XmlElement(name = "HospInfo", required = true, nillable = true)
            protected HospitalInformation hospInfo;
            @XmlElement(name = "VendorInfo", required = true, nillable = true)
            protected VendorInformation vendorInfo;
            @XmlElement(name = "StatusInfo", required = true, nillable = true)
            protected StatusInformation statusInfo;

            /**
             * 取得 docInfo 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link RecDocumentInformation }
             *     
             */
            public RecDocumentInformation getDocInfo() {
                return docInfo;
            }

            /**
             * 設定 docInfo 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link RecDocumentInformation }
             *     
             */
            public void setDocInfo(RecDocumentInformation value) {
                this.docInfo = value;
            }

            /**
             * 取得 hospInfo 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link HospitalInformation }
             *     
             */
            public HospitalInformation getHospInfo() {
                return hospInfo;
            }

            /**
             * 設定 hospInfo 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link HospitalInformation }
             *     
             */
            public void setHospInfo(HospitalInformation value) {
                this.hospInfo = value;
            }

            /**
             * 取得 vendorInfo 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link VendorInformation }
             *     
             */
            public VendorInformation getVendorInfo() {
                return vendorInfo;
            }

            /**
             * 設定 vendorInfo 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link VendorInformation }
             *     
             */
            public void setVendorInfo(VendorInformation value) {
                this.vendorInfo = value;
            }

            /**
             * 取得 statusInfo 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link StatusInformation }
             *     
             */
            public StatusInformation getStatusInfo() {
                return statusInfo;
            }

            /**
             * 設定 statusInfo 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link StatusInformation }
             *     
             */
            public void setStatusInfo(StatusInformation value) {
                this.statusInfo = value;
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
         *         &lt;element name="ItemInfo" type="{}rec_itemInformation"/&gt;
         *         &lt;element name="MedInfo" type="{}medicineInformation"/&gt;
         *         &lt;element name="OrderInfo" type="{}rec_orderInformation"/&gt;
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
            "itemInfo",
            "medInfo",
            "orderInfo"
        })
        public static class Items {

            @XmlElement(name = "ItemInfo", required = true, nillable = true)
            protected RecItemInformation itemInfo;
            @XmlElement(name = "MedInfo", required = true, nillable = true)
            protected MedicineInformation medInfo;
            @XmlElement(name = "OrderInfo", required = true, nillable = true)
            protected RecOrderInformation orderInfo;

            /**
             * 取得 itemInfo 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link RecItemInformation }
             *     
             */
            public RecItemInformation getItemInfo() {
                return itemInfo;
            }

            /**
             * 設定 itemInfo 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link RecItemInformation }
             *     
             */
            public void setItemInfo(RecItemInformation value) {
                this.itemInfo = value;
            }

            /**
             * 取得 medInfo 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link MedicineInformation }
             *     
             */
            public MedicineInformation getMedInfo() {
                return medInfo;
            }

            /**
             * 設定 medInfo 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link MedicineInformation }
             *     
             */
            public void setMedInfo(MedicineInformation value) {
                this.medInfo = value;
            }

            /**
             * 取得 orderInfo 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link RecOrderInformation }
             *     
             */
            public RecOrderInformation getOrderInfo() {
                return orderInfo;
            }

            /**
             * 設定 orderInfo 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link RecOrderInformation }
             *     
             */
            public void setOrderInfo(RecOrderInformation value) {
                this.orderInfo = value;
            }

        }

    }

}
