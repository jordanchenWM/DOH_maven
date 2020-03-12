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
 * <p>MATPORequest complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="MATPORequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DoHPORequest"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="MesgInfo" type="{}messageInformation"/&gt;
 *                   &lt;element name="PORequestHead"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="PORequestSummary"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="PONo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="POSort" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="PODate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="TotalAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                                       &lt;element name="TotalQtyDiscountAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                                       &lt;element name="TotalAfterQtyDiscountAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                                       &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="UpdateTime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="Delete_User" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                                       &lt;element name="Delete_Datetime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                                       &lt;element name="Delete_Reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="HospitalInfo"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="HospitalID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="PurchaseDept" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                                       &lt;element name="PurchaseStaff" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                                       &lt;element name="ReqInvoiceDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                                       &lt;element name="Memo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="VendorInfo"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="VendorID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="PORequestItem" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="PORequestDetail"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="POItemNo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="RequireDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                                       &lt;element name="Qty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                                       &lt;element name="UnitPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                                       &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                                       &lt;element name="QtyDiscountRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                                       &lt;element name="QtyDiscountAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                                       &lt;element name="AfterQtyDiscountAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="MaterialInfo" type="{}MaterialInfo"/&gt;
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
@XmlType(name = "MATPORequest", propOrder = {
    "doHPORequest"
})
public class MATPORequest {

    @XmlElement(name = "DoHPORequest", required = true)
    protected MATPORequest.DoHPORequest doHPORequest;

    /**
     * 取得 doHPORequest 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link MATPORequest.DoHPORequest }
     *     
     */
    public MATPORequest.DoHPORequest getDoHPORequest() {
        return doHPORequest;
    }

    /**
     * 設定 doHPORequest 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link MATPORequest.DoHPORequest }
     *     
     */
    public void setDoHPORequest(MATPORequest.DoHPORequest value) {
        this.doHPORequest = value;
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
    public static class DoHPORequest {

        @XmlElement(name = "MesgInfo", required = true)
        protected MessageInformation mesgInfo;
        @XmlElement(name = "PORequestHead", required = true)
        protected List<MATPORequest.DoHPORequest.PORequestHead> poRequestHead;
        @XmlElement(name = "PORequestItem", required = true)
        protected List<MATPORequest.DoHPORequest.PORequestItem> poRequestItem;

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
         *     {@link MATPORequest.DoHPORequest.PORequestHead }
         *     
         */
        public List<MATPORequest.DoHPORequest.PORequestHead> getPORequestHead() {
        	if (poRequestHead == null) {
        		poRequestHead = new ArrayList<MATPORequest.DoHPORequest.PORequestHead>();
            }
        	return poRequestHead;
        }

        /**
         * 設定 poRequestHead 特性的值.
         * 
         * @param value
         *     allowed object is
         *     {@link MATPORequest.DoHPORequest.PORequestHead }
         *     
         */
        public void setPORequestHead(List<MATPORequest.DoHPORequest.PORequestHead> poRequestHead) {
            this.poRequestHead = poRequestHead;
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
         * {@link MATPORequest.DoHPORequest.PORequestItem }
         * 
         * 
         */
        public List<MATPORequest.DoHPORequest.PORequestItem> getPORequestItem() {
            if (poRequestItem == null) {
                poRequestItem = new ArrayList<MATPORequest.DoHPORequest.PORequestItem>();
            }
            return this.poRequestItem;
        }

		public void setPoRequestItem(List<MATPORequest.DoHPORequest.PORequestItem> poRequestItem) {
			this.poRequestItem = poRequestItem;
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

            @XmlElement(name = "PORequestSummary", required = true)
            protected MATPORequest.DoHPORequest.PORequestHead.PORequestSummary poRequestSummary;
            @XmlElement(name = "HospitalInfo", required = true)
            protected MATPORequest.DoHPORequest.PORequestHead.HospitalInfo hospitalInfo;
            @XmlElement(name = "VendorInfo", required = true)
            protected MATPORequest.DoHPORequest.PORequestHead.VendorInfo vendorInfo;

            /**
             * 取得 poRequestSummary 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link MATPORequest.DoHPORequest.PORequestHead.PORequestSummary }
             *     
             */
            public MATPORequest.DoHPORequest.PORequestHead.PORequestSummary getPORequestSummary() {
                return poRequestSummary;
            }

            /**
             * 設定 poRequestSummary 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link MATPORequest.DoHPORequest.PORequestHead.PORequestSummary }
             *     
             */
            public void setPORequestSummary(MATPORequest.DoHPORequest.PORequestHead.PORequestSummary value) {
                this.poRequestSummary = value;
            }

            /**
             * 取得 hospitalInfo 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link MATPORequest.DoHPORequest.PORequestHead.HospitalInfo }
             *     
             */
            public MATPORequest.DoHPORequest.PORequestHead.HospitalInfo getHospitalInfo() {
                return hospitalInfo;
            }

            /**
             * 設定 hospitalInfo 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link MATPORequest.DoHPORequest.PORequestHead.HospitalInfo }
             *     
             */
            public void setHospitalInfo(MATPORequest.DoHPORequest.PORequestHead.HospitalInfo value) {
                this.hospitalInfo = value;
            }

            /**
             * 取得 vendorInfo 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link MATPORequest.DoHPORequest.PORequestHead.VendorInfo }
             *     
             */
            public MATPORequest.DoHPORequest.PORequestHead.VendorInfo getVendorInfo() {
                return vendorInfo;
            }

            /**
             * 設定 vendorInfo 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link MATPORequest.DoHPORequest.PORequestHead.VendorInfo }
             *     
             */
            public void setVendorInfo(MATPORequest.DoHPORequest.PORequestHead.VendorInfo value) {
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

                @XmlElement(name = "PONo", required = true)
                protected String poNo;
                @XmlElement(name = "POSort", required = true)
                protected String poSort;
                @XmlElement(name = "PODate", required = true)
                protected String poDate;
                @XmlElement(name = "TotalAmount", required = true)
                protected String totalAmount;
                @XmlElement(name = "TotalQtyDiscountAmount", required = true)
                protected String totalQtyDiscountAmount;
                @XmlElement(name = "TotalAfterQtyDiscountAmount", required = true)
                protected String totalAfterQtyDiscountAmount;
                @XmlElement(name = "Status", required = true)
                protected String status;
                @XmlElement(name = "UpdateTime", required = true)
                protected String updateTime;
                @XmlElement(name = "Delete_User", required = true)
                protected String deleteUser;
                @XmlElement(name = "Delete_Datetime", required = true)
                protected String deleteDatetime;
                @XmlElement(name = "Delete_Reason", required = true, nillable=true)
                protected String deleteReason;
				
                public String getPoNo() {
					return poNo;
				}
				public void setPoNo(String poNo) {
					this.poNo = poNo;
				}
				
				public String getPoSort() {
					return poSort;
				}
				public void setPoSort(String poSort) {
					this.poSort = poSort;
				}
				
				public String getPoDate() {
					return poDate;
				}
				public void setPoDate(String poDate) {
					this.poDate = poDate;
				}
				
				public String getTotalAmount() {
					return totalAmount;
				}
				public void setTotalAmount(String totalAmount) {
					this.totalAmount = totalAmount;
				}
				
				public String getTotalQtyDiscountAmount() {
					return totalQtyDiscountAmount;
				}
				public void setTotalQtyDiscountAmount(String totalQtyDiscountAmount) {
					this.totalQtyDiscountAmount = totalQtyDiscountAmount;
				}
				
				public String getTotalAfterQtyDiscountAmount() {
					return totalAfterQtyDiscountAmount;
				}
				public void setTotalAfterQtyDiscountAmount(String totalAfterQtyDiscountAmount) {
					this.totalAfterQtyDiscountAmount = totalAfterQtyDiscountAmount;
				}
				
				public String getStatus() {
					return status;
				}
				public void setStatus(String status) {
					this.status = status;
				}
				
				public String getUpdateTime() {
					return updateTime;
				}
				public void setUpdateTime(String updateTime) {
					this.updateTime = updateTime;
				}
				
				public String getDeleteUser() {
					return deleteUser;
				}
				public void setDeleteUser(String deleteUser) {
					this.deleteUser = deleteUser;
				}
				
				public String getDeleteDatetime() {
					return deleteDatetime;
				}
				public void setDeleteDatetime(String deleteDatetime) {
					this.deleteDatetime = deleteDatetime;
				}
				
				public String getDeleteReason() {
					return deleteReason;
				}
				public void setDeleteReason(String deleteReason) {
					this.deleteReason = deleteReason;
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

                @XmlElement(name = "HospitalID", required = true)
                protected String hospitalID;
                @XmlElement(name = "PurchaseDept", required = true)
                protected String purchaseDept;
                @XmlElement(name = "PurchaseStaff", required = true)
                protected String purchaseStaff;
                @XmlElement(name = "ReqInvoiceDate", required = true)
                protected String reqInvoiceDate;
                @XmlElement(name = "Memo", required = true)
                protected String memo;
                
				public String getHospitalID() {
					return hospitalID;
				}
				public void setHospitalID(String hospitalID) {
					this.hospitalID = hospitalID;
				}
				
				public String getPurchaseDept() {
					return purchaseDept;
				}
				public void setPurchaseDept(String purchaseDept) {
					this.purchaseDept = purchaseDept;
				}
				
				public String getPurchaseStaff() {
					return purchaseStaff;
				}
				public void setPurchaseStaff(String purchaseStaff) {
					this.purchaseStaff = purchaseStaff;
				}
				
				public String getReqInvoiceDate() {
					return reqInvoiceDate;
				}
				public void setReqInvoiceDate(String reqInvoiceDate) {
					this.reqInvoiceDate = reqInvoiceDate;
				}
				
				public String getMemo() {
					return memo;
				}
				public void setMemo(String memo) {
					this.memo = memo;
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

                @XmlElement(name = "VendorID", required = true)
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

            @XmlElement(name = "PORequestDetail", required = true)
            protected MATPORequest.DoHPORequest.PORequestItem.PORequestDetail poRequestDetail;
            @XmlElement(name = "MaterialInfo", required = true)
            protected MaterialInfo materialInfo;

            /**
             * 取得 poRequestDetail 特性的值.
             * 
             * @return
             *     possible object is
             *     {@link MATPORequest.DoHPORequest.PORequestItem.PORequestDetail }
             *     
             */
            public MATPORequest.DoHPORequest.PORequestItem.PORequestDetail getPORequestDetail() {
                return poRequestDetail;
            }

            /**
             * 設定 poRequestDetail 特性的值.
             * 
             * @param value
             *     allowed object is
             *     {@link MATPORequest.DoHPORequest.PORequestItem.PORequestDetail }
             *     
             */
            public void setPORequestDetail(MATPORequest.DoHPORequest.PORequestItem.PORequestDetail value) {
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

                @XmlElement(name = "POItemNo", required = true)
                protected String poItemNo;
                @XmlElement(name = "RequireDate", required = true)
                protected String requireDate;
                @XmlElement(name = "Qty", required = true)
                protected String qty;
                @XmlElement(name = "UnitPrice", required = true)
                protected String unitPrice;
                @XmlElement(name = "Amount", required = true)
                protected String amount;
                @XmlElement(name = "QtyDiscountRate", required = true)
                protected String qtyDiscountRate;
                @XmlElement(name = "QtyDiscountAmount", required = true)
                protected String qtyDiscountAmount;
                @XmlElement(name = "AfterQtyDiscountAmount", required = true)
                protected String afterQtyDiscountAmount;
				
                public String getPoItemNo() {
					return poItemNo;
				}
				public void setPoItemNo(String poItemNo) {
					this.poItemNo = poItemNo;
				}
				
				public String getRequireDate() {
					return requireDate;
				}
				public void setRequireDate(String requireDate) {
					this.requireDate = requireDate;
				}
				
				public String getQty() {
					return qty;
				}
				public void setQty(String qty) {
					this.qty = qty;
				}
				
				public String getUnitPrice() {
					return unitPrice;
				}
				public void setUnitPrice(String unitPrice) {
					this.unitPrice = unitPrice;
				}
				
				public String getAmount() {
					return amount;
				}
				public void setAmount(String amount) {
					this.amount = amount;
				}
				
				public String getQtyDiscountRate() {
					return qtyDiscountRate;
				}
				public void setQtyDiscountRate(String qtyDiscountRate) {
					this.qtyDiscountRate = qtyDiscountRate;
				}
				
				public String getQtyDiscountAmount() {
					return qtyDiscountAmount;
				}
				public void setQtyDiscountAmount(String qtyDiscountAmount) {
					this.qtyDiscountAmount = qtyDiscountAmount;
				}
				
				public String getAfterQtyDiscountAmount() {
					return afterQtyDiscountAmount;
				}
				public void setAfterQtyDiscountAmount(String afterQtyDiscountAmount) {
					this.afterQtyDiscountAmount = afterQtyDiscountAmount;
				}

                

            }

        }

    }

}
