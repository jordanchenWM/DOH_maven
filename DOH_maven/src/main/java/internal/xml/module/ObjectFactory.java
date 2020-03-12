//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 所產生 
// 請參閱 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2019.05.02 於 05:27:30 PM CST 
//


package internal.xml.module;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the internal.xml.module package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: internal.xml.module
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MEDPO }
     * 
     */
    public MEDPO createMEDPO() {
        return new MEDPO();
    }

    /**
     * Create an instance of {@link internal.xml.module.HISPurchaseOrderUpdateRequest }
     * 
     */
    public internal.xml.module.HISPurchaseOrderUpdateRequest createHISPurchaseOrderUpdateRequest() {
        return new internal.xml.module.HISPurchaseOrderUpdateRequest();
    }

    /**
     * Create an instance of {@link MessageInformation }
     * 
     */
    public MessageInformation createMessageInformation() {
        return new MessageInformation();
    }

    /**
     * Create an instance of {@link HpTodd }
     * 
     */
    public HpTodd createHpTodd() {
        return new HpTodd();
    }

    /**
     * Create an instance of {@link MEDPO.HISPurchaseOrderUpdateRequest }
     * 
     */
    public MEDPO.HISPurchaseOrderUpdateRequest createMEDPOHISPurchaseOrderUpdateRequest() {
        return new MEDPO.HISPurchaseOrderUpdateRequest();
    }

}
