//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 所產生 
// 請參閱 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2020.02.26 於 09:25:44 AM CST 
//


package internal.xml.module.matporequest;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="MesgInfo" type="{}messageInformation"/&gt;
 *         &lt;element name="PORequestHead"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PORequestSummary"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="PONo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="POSort" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="PODate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="TotalAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="TotalQtyDiscountAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="TotalAfterQtyDiscountAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="UpdateTime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="Delete_User" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="Delete_Datetime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="Delete_Reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="HospitalInfo"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="HospitalID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="PurchaseDept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="PurchaseStaff" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="ReqInvoiceDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="Memo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="VendorInfo"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="VendorID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
 *         &lt;element name="PORequestItem" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="PORequestDetail"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="POItemNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="RequireDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="Qty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="UnitPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="QtyDiscountRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="QtyDiscountAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="AfterQtyDiscountAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="MaterialInfo" type="{}MaterialInfo"/&gt;
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
    "poRequestHead",
    "poRequestItem"
})
@XmlRootElement(name = "DoHPORequest")
public class DoHPORequest {

    @XmlElement(name = "MesgInfo", required = true, nillable = true)
    protected MessageInformation mesgInfo;
    @XmlElement(name = "PORequestHead", required = true, nillable = true)
    protected DoHPORequest.PORequestHead poRequestHead;
    @XmlElement(name = "PORequestItem", required = true, nillable = true)
    protected List<DoHPORequest.PORequestItem> poRequestItem;

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
     * 取得 poRequestHead 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link DoHPORequest.PORequestHead }
     *     
     */
    public DoHPORequest.PORequestHead getPORequestHead() {
        return poRequestHead;
    }

    /**
     * 設定 poRequestHead 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link DoHPORequest.PORequestHead }
     *     
     */
    public void setPORequestHead(DoHPORequest.PORequestHead value) {
        this.poRequestHead = value;
    }

    /**
     * Gets the value of the poRequestItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the poRequestItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPORequestItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DoHPORequest.PORequestItem }
     * 
     * 
     */
    public List<DoHPORequest.PORequestItem> getPORequestItem() {
        if (poRequestItem == null) {
            poRequestItem = new ArrayList<DoHPORequest.PORequestItem>();
        }
        return this.poRequestItem;
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
     *         &lt;element name="PORequestSummary"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="PONo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="POSort" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="PODate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="TotalAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="TotalQtyDiscountAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="TotalAfterQtyDiscountAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="UpdateTime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="Delete_User" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="Delete_Datetime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="Delete_Reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="HospitalInfo"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="HospitalID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="PurchaseDept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="PurchaseStaff" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="ReqInvoiceDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="Memo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="VendorInfo"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="VendorID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
        "poRequestSummary",
        "hospitalInfo",
        "vendorInfo"
    })
    public static class PORequestHead {

        @XmlElement(name = "PORequestSummary", required = true, nillable = true)
        protected DoHPORequest.PORequestHead.PORequestSummary poRequestSummary;
        @XmlElement(name = "HospitalInfo", required = true, nillable = true)
        protected DoHPORequest.PORequestHead.HospitalInfo hospitalInfo;
        @XmlElement(name = "VendorInfo", required = true, nillable = true)
        protected DoHPORequest.PORequestHead.VendorInfo vendorInfo;

        /**
         * 取得 poRequestSummary 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link DoHPORequest.PORequestHead.PORequestSummary }
         *     
         */
        public DoHPORequest.PORequestHead.PORequestSummary getPORequestSummary() {
            return poRequestSummary;
        }

        /**
         * 設定 poRequestSummary 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link DoHPORequest.PORequestHead.PORequestSummary }
         *     
         */
        public void setPORequestSummary(DoHPORequest.PORequestHead.PORequestSummary value) {
            this.poRequestSummary = value;
        }

        /**
         * 取得 hospitalInfo 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link DoHPORequest.PORequestHead.HospitalInfo }
         *     
         */
        public DoHPORequest.PORequestHead.HospitalInfo getHospitalInfo() {
            return hospitalInfo;
        }

        /**
         * 設定 hospitalInfo 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link DoHPORequest.PORequestHead.HospitalInfo }
         *     
         */
        public void setHospitalInfo(DoHPORequest.PORequestHead.HospitalInfo value) {
            this.hospitalInfo = value;
        }

        /**
         * 取得 vendorInfo 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link DoHPORequest.PORequestHead.VendorInfo }
         *     
         */
        public DoHPORequest.PORequestHead.VendorInfo getVendorInfo() {
            return vendorInfo;
        }

        /**
         * 設定 vendorInfo 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link DoHPORequest.PORequestHead.VendorInfo }
         *     
         */
        public void setVendorInfo(DoHPORequest.PORequestHead.VendorInfo value) {
            this.vendorInfo = value;
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
         *         &lt;element name="HospitalID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="PurchaseDept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="PurchaseStaff" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="ReqInvoiceDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="Memo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
            "hospitalID",
            "purchaseDept",
            "purchaseStaff",
            "reqInvoiceDate",
            "memo"
        })
        public static class HospitalInfo {

            @XmlElement(name = "HospitalID", required = true, nillable = true)
            protected String hospitalID;
            @XmlElementRef(name = "PurchaseDept", type = JAXBElement.class, required = false)
            protected JAXBElement<String> purchaseDept;
            @XmlElementRef(name = "PurchaseStaff", type = JAXBElement.class, required = false)
            protected JAXBElement<String> purchaseStaff;
            @XmlElementRef(name = "ReqInvoiceDate", type = JAXBElement.class, required = false)
            protected JAXBElement<String> reqInvoiceDate;
            @XmlElementRef(name = "Memo", type = JAXBElement.class, required = false)
            protected JAXBElement<String> memo;

            /**
             * 取得 hospitalID 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHospitalID() {
                return hospitalID;
            }

            /**
             * 設定 hospitalID 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHospitalID(String value) {
                this.hospitalID = value;
            }

            /**
             * 取得 purchaseDept 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getPurchaseDept() {
                return purchaseDept;
            }

            /**
             * 設定 purchaseDept 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setPurchaseDept(JAXBElement<String> value) {
                this.purchaseDept = value;
            }

            /**
             * 取得 purchaseStaff 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getPurchaseStaff() {
                return purchaseStaff;
            }

            /**
             * 設定 purchaseStaff 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setPurchaseStaff(JAXBElement<String> value) {
                this.purchaseStaff = value;
            }

            /**
             * 取得 reqInvoiceDate 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getReqInvoiceDate() {
                return reqInvoiceDate;
            }

            /**
             * 設定 reqInvoiceDate 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setReqInvoiceDate(JAXBElement<String> value) {
                this.reqInvoiceDate = value;
            }

            /**
             * 取得 memo 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getMemo() {
                return memo;
            }

            /**
             * 設定 memo 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setMemo(JAXBElement<String> value) {
                this.memo = value;
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
         *         &lt;element name="PONo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="POSort" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="PODate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="TotalAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="TotalQtyDiscountAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="TotalAfterQtyDiscountAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="UpdateTime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="Delete_User" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="Delete_Datetime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="Delete_Reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
            "poNo",
            "poSort",
            "poDate",
            "totalAmount",
            "totalQtyDiscountAmount",
            "totalAfterQtyDiscountAmount",
            "status",
            "updateTime",
            "deleteUser",
            "deleteDatetime",
            "deleteReason"
        })
        public static class PORequestSummary {

            @XmlElement(name = "PONo", required = true, nillable = true)
            protected String poNo;
            @XmlElement(name = "POSort", required = true, nillable = true)
            protected String poSort;
            @XmlElement(name = "PODate", required = true, nillable = true)
            protected String poDate;
            @XmlElementRef(name = "TotalAmount", type = JAXBElement.class, required = false)
            protected JAXBElement<String> totalAmount;
            @XmlElementRef(name = "TotalQtyDiscountAmount", type = JAXBElement.class, required = false)
            protected JAXBElement<String> totalQtyDiscountAmount;
            @XmlElementRef(name = "TotalAfterQtyDiscountAmount", type = JAXBElement.class, required = false)
            protected JAXBElement<String> totalAfterQtyDiscountAmount;
            @XmlElement(name = "Status", required = true, nillable = true)
            protected String status;
            @XmlElement(name = "UpdateTime", required = true, nillable = true)
            protected String updateTime;
            @XmlElementRef(name = "Delete_User", type = JAXBElement.class, required = false)
            protected JAXBElement<String> deleteUser;
            @XmlElementRef(name = "Delete_Datetime", type = JAXBElement.class, required = false)
            protected JAXBElement<String> deleteDatetime;
            @XmlElementRef(name = "Delete_Reason", type = JAXBElement.class, required = false)
            protected JAXBElement<String> deleteReason;

            /**
             * 取得 poNo 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPONo() {
                return poNo;
            }

            /**
             * 設定 poNo 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPONo(String value) {
                this.poNo = value;
            }

            /**
             * 取得 poSort 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPOSort() {
                return poSort;
            }

            /**
             * 設定 poSort 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPOSort(String value) {
                this.poSort = value;
            }

            /**
             * 取得 poDate 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPODate() {
                return poDate;
            }

            /**
             * 設定 poDate 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPODate(String value) {
                this.poDate = value;
            }

            /**
             * 取得 totalAmount 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getTotalAmount() {
                return totalAmount;
            }

            /**
             * 設定 totalAmount 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setTotalAmount(JAXBElement<String> value) {
                this.totalAmount = value;
            }

            /**
             * 取得 totalQtyDiscountAmount 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getTotalQtyDiscountAmount() {
                return totalQtyDiscountAmount;
            }

            /**
             * 設定 totalQtyDiscountAmount 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setTotalQtyDiscountAmount(JAXBElement<String> value) {
                this.totalQtyDiscountAmount = value;
            }

            /**
             * 取得 totalAfterQtyDiscountAmount 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getTotalAfterQtyDiscountAmount() {
                return totalAfterQtyDiscountAmount;
            }

            /**
             * 設定 totalAfterQtyDiscountAmount 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setTotalAfterQtyDiscountAmount(JAXBElement<String> value) {
                this.totalAfterQtyDiscountAmount = value;
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
             * 取得 updateTime 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUpdateTime() {
                return updateTime;
            }

            /**
             * 設定 updateTime 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUpdateTime(String value) {
                this.updateTime = value;
            }

            /**
             * 取得 deleteUser 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getDeleteUser() {
                return deleteUser;
            }

            /**
             * 設定 deleteUser 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setDeleteUser(JAXBElement<String> value) {
                this.deleteUser = value;
            }

            /**
             * 取得 deleteDatetime 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getDeleteDatetime() {
                return deleteDatetime;
            }

            /**
             * 設定 deleteDatetime 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setDeleteDatetime(JAXBElement<String> value) {
                this.deleteDatetime = value;
            }

            /**
             * 取得 deleteReason 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getDeleteReason() {
                return deleteReason;
            }

            /**
             * 設定 deleteReason 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setDeleteReason(JAXBElement<String> value) {
                this.deleteReason = value;
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
         *         &lt;element name="VendorID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
            "vendorID"
        })
        public static class VendorInfo {

            @XmlElement(name = "VendorID", required = true, nillable = true)
            protected String vendorID;

            /**
             * 取得 vendorID 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVendorID() {
                return vendorID;
            }

            /**
             * 設定 vendorID 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVendorID(String value) {
                this.vendorID = value;
            }

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
     *         &lt;element name="PORequestDetail"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="POItemNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="RequireDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="Qty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="UnitPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="QtyDiscountRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="QtyDiscountAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="AfterQtyDiscountAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="MaterialInfo" type="{}MaterialInfo"/&gt;
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
        "poRequestDetail",
        "materialInfo"
    })
    public static class PORequestItem {

        @XmlElement(name = "PORequestDetail", required = true, nillable = true)
        protected DoHPORequest.PORequestItem.PORequestDetail poRequestDetail;
        @XmlElement(name = "MaterialInfo", required = true, nillable = true)
        protected MaterialInfo materialInfo;

        /**
         * 取得 poRequestDetail 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link DoHPORequest.PORequestItem.PORequestDetail }
         *     
         */
        public DoHPORequest.PORequestItem.PORequestDetail getPORequestDetail() {
            return poRequestDetail;
        }

        /**
         * 設定 poRequestDetail 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link DoHPORequest.PORequestItem.PORequestDetail }
         *     
         */
        public void setPORequestDetail(DoHPORequest.PORequestItem.PORequestDetail value) {
            this.poRequestDetail = value;
        }

        /**
         * 取得 materialInfo 特性的值.
         * 
         * @return
         *     possible object is
         *     {@link MaterialInfo }
         *     
         */
        public MaterialInfo getMaterialInfo() {
            return materialInfo;
        }

        /**
         * 設定 materialInfo 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link MaterialInfo }
         *     
         */
        public void setMaterialInfo(MaterialInfo value) {
            this.materialInfo = value;
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
         *         &lt;element name="POItemNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="RequireDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="Qty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="UnitPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="QtyDiscountRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="QtyDiscountAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="AfterQtyDiscountAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
            "poItemNo",
            "requireDate",
            "qty",
            "unitPrice",
            "amount",
            "qtyDiscountRate",
            "qtyDiscountAmount",
            "afterQtyDiscountAmount"
        })
        public static class PORequestDetail {

            @XmlElement(name = "POItemNo", required = true, nillable = true)
            protected String poItemNo;
            @XmlElementRef(name = "RequireDate", type = JAXBElement.class, required = false)
            protected JAXBElement<String> requireDate;
            @XmlElementRef(name = "Qty", type = JAXBElement.class, required = false)
            protected JAXBElement<String> qty;
            @XmlElementRef(name = "UnitPrice", type = JAXBElement.class, required = false)
            protected JAXBElement<String> unitPrice;
            @XmlElementRef(name = "Amount", type = JAXBElement.class, required = false)
            protected JAXBElement<String> amount;
            @XmlElementRef(name = "QtyDiscountRate", type = JAXBElement.class, required = false)
            protected JAXBElement<String> qtyDiscountRate;
            @XmlElementRef(name = "QtyDiscountAmount", type = JAXBElement.class, required = false)
            protected JAXBElement<String> qtyDiscountAmount;
            @XmlElementRef(name = "AfterQtyDiscountAmount", type = JAXBElement.class, required = false)
            protected JAXBElement<String> afterQtyDiscountAmount;

            /**
             * 取得 poItemNo 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPOItemNo() {
                return poItemNo;
            }

            /**
             * 設定 poItemNo 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPOItemNo(String value) {
                this.poItemNo = value;
            }

            /**
             * 取得 requireDate 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getRequireDate() {
                return requireDate;
            }

            /**
             * 設定 requireDate 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setRequireDate(JAXBElement<String> value) {
                this.requireDate = value;
            }

            /**
             * 取得 qty 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getQty() {
                return qty;
            }

            /**
             * 設定 qty 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setQty(JAXBElement<String> value) {
                this.qty = value;
            }

            /**
             * 取得 unitPrice 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getUnitPrice() {
                return unitPrice;
            }

            /**
             * 設定 unitPrice 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setUnitPrice(JAXBElement<String> value) {
                this.unitPrice = value;
            }

            /**
             * 取得 amount 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getAmount() {
                return amount;
            }

            /**
             * 設定 amount 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setAmount(JAXBElement<String> value) {
                this.amount = value;
            }

            /**
             * 取得 qtyDiscountRate 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getQtyDiscountRate() {
                return qtyDiscountRate;
            }

            /**
             * 設定 qtyDiscountRate 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setQtyDiscountRate(JAXBElement<String> value) {
                this.qtyDiscountRate = value;
            }

            /**
             * 取得 qtyDiscountAmount 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getQtyDiscountAmount() {
                return qtyDiscountAmount;
            }

            /**
             * 設定 qtyDiscountAmount 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setQtyDiscountAmount(JAXBElement<String> value) {
                this.qtyDiscountAmount = value;
            }

            /**
             * 取得 afterQtyDiscountAmount 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getAfterQtyDiscountAmount() {
                return afterQtyDiscountAmount;
            }

            /**
             * 設定 afterQtyDiscountAmount 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setAfterQtyDiscountAmount(JAXBElement<String> value) {
                this.afterQtyDiscountAmount = value;
            }

        }

    }

}
