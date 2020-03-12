//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 所產生 
// 請參閱 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2020.03.09 於 05:11:34 PM CST 
//


package test;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the test package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RecOrderInformationOrderUnit_QNAME = new QName("", "OrderUnit");
    private final static QName _RecOrderInformationQuantity_QNAME = new QName("", "Quantity");
    private final static QName _RecOrderInformationUnitPrice_QNAME = new QName("", "UnitPrice");
    private final static QName _RecOrderInformationPOLineAmount_QNAME = new QName("", "POLineAmount");
    private final static QName _MedicineInformationMedCode_QNAME = new QName("", "MedCode");
    private final static QName _MedicineInformationBatchNo_QNAME = new QName("", "BatchNo");
    private final static QName _MedicineInformationCompNo_QNAME = new QName("", "CompNo");
    private final static QName _MedicineInformationBrand_QNAME = new QName("", "Brand");
    private final static QName _MedicineInformationName_QNAME = new QName("", "Name");
    private final static QName _MedicineInformationSpec_QNAME = new QName("", "Spec");
    private final static QName _MedicineInformationType_QNAME = new QName("", "Type");
    private final static QName _MedicineInformationBidNo_QNAME = new QName("", "BidNo");
    private final static QName _MedicineInformationDiscRate_QNAME = new QName("", "DiscRate");
    private final static QName _MedicineInformationDiscAmt_QNAME = new QName("", "DiscAmt");
    private final static QName _RecItemInformationRequestDateTime_QNAME = new QName("", "RequestDateTime");
    private final static QName _RecItemInformationInvoiceDate_QNAME = new QName("", "InvoiceDate");
    private final static QName _StatusInformationUpdateDateTime_QNAME = new QName("", "UpdateDateTime");
    private final static QName _VendorInformationUePPVendor_QNAME = new QName("", "UePPVendor");
    private final static QName _HospitalInformationPurchasingDept_QNAME = new QName("", "PurchasingDept");
    private final static QName _HospitalInformationPurchaser_QNAME = new QName("", "Purchaser");
    private final static QName _HospitalInformationReceiptDept_QNAME = new QName("", "ReceiptDept");
    private final static QName _HospitalInformationReceiptStaff_QNAME = new QName("", "ReceiptStaff");
    private final static QName _RecDocumentInformationAllianceID_QNAME = new QName("", "AllianceID");
    private final static QName _RecDocumentInformationDate_QNAME = new QName("", "Date");
    private final static QName _RecDocumentInformationPOType_QNAME = new QName("", "POType");
    private final static QName _RecDocumentInformationTotalAmount_QNAME = new QName("", "TotalAmount");
    private final static QName _RecDocumentInformationMemo_QNAME = new QName("", "Memo");
    private final static QName _RecDocumentInformationDeleteUser_QNAME = new QName("", "Delete_User");
    private final static QName _RecDocumentInformationDeleteDatetime_QNAME = new QName("", "Delete_Datetime");
    private final static QName _RecDocumentInformationDeleteReason_QNAME = new QName("", "Delete_Reason");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: test
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link test.PurchaseOrder }
     * 
     */
    public test.PurchaseOrder createPurchaseOrder() {
        return new test.PurchaseOrder();
    }

    /**
     * Create an instance of {@link MEDPORequest }
     * 
     */
    public MEDPORequest createMEDPORequest() {
        return new MEDPORequest();
    }

    /**
     * Create an instance of {@link MEDPORequest.PurchaseOrder }
     * 
     */
    public MEDPORequest.PurchaseOrder createMEDPORequestPurchaseOrder() {
        return new MEDPORequest.PurchaseOrder();
    }

    /**
     * Create an instance of {@link MessageInformation }
     * 
     */
    public MessageInformation createMessageInformation() {
        return new MessageInformation();
    }

    /**
     * Create an instance of {@link test.PurchaseOrder.Header }
     * 
     */
    public test.PurchaseOrder.Header createPurchaseOrderHeader() {
        return new test.PurchaseOrder.Header();
    }

    /**
     * Create an instance of {@link test.PurchaseOrder.Items }
     * 
     */
    public test.PurchaseOrder.Items createPurchaseOrderItems() {
        return new test.PurchaseOrder.Items();
    }

    /**
     * Create an instance of {@link RecDocumentInformation }
     * 
     */
    public RecDocumentInformation createRecDocumentInformation() {
        return new RecDocumentInformation();
    }

    /**
     * Create an instance of {@link HospitalInformation }
     * 
     */
    public HospitalInformation createHospitalInformation() {
        return new HospitalInformation();
    }

    /**
     * Create an instance of {@link VendorInformation }
     * 
     */
    public VendorInformation createVendorInformation() {
        return new VendorInformation();
    }

    /**
     * Create an instance of {@link StatusInformation }
     * 
     */
    public StatusInformation createStatusInformation() {
        return new StatusInformation();
    }

    /**
     * Create an instance of {@link RecItemInformation }
     * 
     */
    public RecItemInformation createRecItemInformation() {
        return new RecItemInformation();
    }

    /**
     * Create an instance of {@link MedicineInformation }
     * 
     */
    public MedicineInformation createMedicineInformation() {
        return new MedicineInformation();
    }

    /**
     * Create an instance of {@link RecOrderInformation }
     * 
     */
    public RecOrderInformation createRecOrderInformation() {
        return new RecOrderInformation();
    }

    /**
     * Create an instance of {@link MEDPORequest.PurchaseOrder.Header }
     * 
     */
    public MEDPORequest.PurchaseOrder.Header createMEDPORequestPurchaseOrderHeader() {
        return new MEDPORequest.PurchaseOrder.Header();
    }

    /**
     * Create an instance of {@link MEDPORequest.PurchaseOrder.Items }
     * 
     */
    public MEDPORequest.PurchaseOrder.Items createMEDPORequestPurchaseOrderItems() {
        return new MEDPORequest.PurchaseOrder.Items();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "OrderUnit", scope = RecOrderInformation.class)
    public JAXBElement<String> createRecOrderInformationOrderUnit(String value) {
        return new JAXBElement<String>(_RecOrderInformationOrderUnit_QNAME, String.class, RecOrderInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Quantity", scope = RecOrderInformation.class)
    public JAXBElement<Float> createRecOrderInformationQuantity(Float value) {
        return new JAXBElement<Float>(_RecOrderInformationQuantity_QNAME, Float.class, RecOrderInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "UnitPrice", scope = RecOrderInformation.class)
    public JAXBElement<Float> createRecOrderInformationUnitPrice(Float value) {
        return new JAXBElement<Float>(_RecOrderInformationUnitPrice_QNAME, Float.class, RecOrderInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "POLineAmount", scope = RecOrderInformation.class)
    public JAXBElement<Float> createRecOrderInformationPOLineAmount(Float value) {
        return new JAXBElement<Float>(_RecOrderInformationPOLineAmount_QNAME, Float.class, RecOrderInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "MedCode", scope = MedicineInformation.class)
    public JAXBElement<String> createMedicineInformationMedCode(String value) {
        return new JAXBElement<String>(_MedicineInformationMedCode_QNAME, String.class, MedicineInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "BatchNo", scope = MedicineInformation.class)
    public JAXBElement<String> createMedicineInformationBatchNo(String value) {
        return new JAXBElement<String>(_MedicineInformationBatchNo_QNAME, String.class, MedicineInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "CompNo", scope = MedicineInformation.class)
    public JAXBElement<String> createMedicineInformationCompNo(String value) {
        return new JAXBElement<String>(_MedicineInformationCompNo_QNAME, String.class, MedicineInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Brand", scope = MedicineInformation.class)
    public JAXBElement<String> createMedicineInformationBrand(String value) {
        return new JAXBElement<String>(_MedicineInformationBrand_QNAME, String.class, MedicineInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Name", scope = MedicineInformation.class)
    public JAXBElement<String> createMedicineInformationName(String value) {
        return new JAXBElement<String>(_MedicineInformationName_QNAME, String.class, MedicineInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Spec", scope = MedicineInformation.class)
    public JAXBElement<String> createMedicineInformationSpec(String value) {
        return new JAXBElement<String>(_MedicineInformationSpec_QNAME, String.class, MedicineInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Type", scope = MedicineInformation.class)
    public JAXBElement<String> createMedicineInformationType(String value) {
        return new JAXBElement<String>(_MedicineInformationType_QNAME, String.class, MedicineInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "BidNo", scope = MedicineInformation.class)
    public JAXBElement<String> createMedicineInformationBidNo(String value) {
        return new JAXBElement<String>(_MedicineInformationBidNo_QNAME, String.class, MedicineInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "DiscRate", scope = MedicineInformation.class)
    public JAXBElement<String> createMedicineInformationDiscRate(String value) {
        return new JAXBElement<String>(_MedicineInformationDiscRate_QNAME, String.class, MedicineInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "DiscAmt", scope = MedicineInformation.class)
    public JAXBElement<String> createMedicineInformationDiscAmt(String value) {
        return new JAXBElement<String>(_MedicineInformationDiscAmt_QNAME, String.class, MedicineInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "RequestDateTime", scope = RecItemInformation.class)
    public JAXBElement<String> createRecItemInformationRequestDateTime(String value) {
        return new JAXBElement<String>(_RecItemInformationRequestDateTime_QNAME, String.class, RecItemInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "InvoiceDate", scope = RecItemInformation.class)
    public JAXBElement<String> createRecItemInformationInvoiceDate(String value) {
        return new JAXBElement<String>(_RecItemInformationInvoiceDate_QNAME, String.class, RecItemInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "UpdateDateTime", scope = StatusInformation.class)
    public JAXBElement<String> createStatusInformationUpdateDateTime(String value) {
        return new JAXBElement<String>(_StatusInformationUpdateDateTime_QNAME, String.class, StatusInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "UePPVendor", scope = VendorInformation.class)
    public JAXBElement<String> createVendorInformationUePPVendor(String value) {
        return new JAXBElement<String>(_VendorInformationUePPVendor_QNAME, String.class, VendorInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "PurchasingDept", scope = HospitalInformation.class)
    public JAXBElement<String> createHospitalInformationPurchasingDept(String value) {
        return new JAXBElement<String>(_HospitalInformationPurchasingDept_QNAME, String.class, HospitalInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Purchaser", scope = HospitalInformation.class)
    public JAXBElement<String> createHospitalInformationPurchaser(String value) {
        return new JAXBElement<String>(_HospitalInformationPurchaser_QNAME, String.class, HospitalInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "ReceiptDept", scope = HospitalInformation.class)
    public JAXBElement<String> createHospitalInformationReceiptDept(String value) {
        return new JAXBElement<String>(_HospitalInformationReceiptDept_QNAME, String.class, HospitalInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "ReceiptStaff", scope = HospitalInformation.class)
    public JAXBElement<String> createHospitalInformationReceiptStaff(String value) {
        return new JAXBElement<String>(_HospitalInformationReceiptStaff_QNAME, String.class, HospitalInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "AllianceID", scope = RecDocumentInformation.class)
    public JAXBElement<String> createRecDocumentInformationAllianceID(String value) {
        return new JAXBElement<String>(_RecDocumentInformationAllianceID_QNAME, String.class, RecDocumentInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Date", scope = RecDocumentInformation.class)
    public JAXBElement<String> createRecDocumentInformationDate(String value) {
        return new JAXBElement<String>(_RecDocumentInformationDate_QNAME, String.class, RecDocumentInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "POType", scope = RecDocumentInformation.class)
    public JAXBElement<String> createRecDocumentInformationPOType(String value) {
        return new JAXBElement<String>(_RecDocumentInformationPOType_QNAME, String.class, RecDocumentInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "TotalAmount", scope = RecDocumentInformation.class)
    public JAXBElement<Float> createRecDocumentInformationTotalAmount(Float value) {
        return new JAXBElement<Float>(_RecDocumentInformationTotalAmount_QNAME, Float.class, RecDocumentInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Memo", scope = RecDocumentInformation.class)
    public JAXBElement<String> createRecDocumentInformationMemo(String value) {
        return new JAXBElement<String>(_RecDocumentInformationMemo_QNAME, String.class, RecDocumentInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Delete_User", scope = RecDocumentInformation.class)
    public JAXBElement<String> createRecDocumentInformationDeleteUser(String value) {
        return new JAXBElement<String>(_RecDocumentInformationDeleteUser_QNAME, String.class, RecDocumentInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Delete_Datetime", scope = RecDocumentInformation.class)
    public JAXBElement<String> createRecDocumentInformationDeleteDatetime(String value) {
        return new JAXBElement<String>(_RecDocumentInformationDeleteDatetime_QNAME, String.class, RecDocumentInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "Delete_Reason", scope = RecDocumentInformation.class)
    public JAXBElement<String> createRecDocumentInformationDeleteReason(String value) {
        return new JAXBElement<String>(_RecDocumentInformationDeleteReason_QNAME, String.class, RecDocumentInformation.class, value);
    }

}
