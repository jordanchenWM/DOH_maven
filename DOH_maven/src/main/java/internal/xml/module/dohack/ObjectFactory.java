//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 所產生 
// 請參閱 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2020.02.26 於 06:03:55 PM CST 
//


package internal.xml.module.dohack;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the internal.xml.module.dohack package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: internal.xml.module.dohack
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DoHAck }
     * 
     */
    public DoHAck createDoHAck() {
        return new DoHAck();
    }

    /**
     * Create an instance of {@link MessageInfo }
     * 
     */
    public MessageInfo createMessageInfo() {
        return new MessageInfo();
    }

    /**
     * Create an instance of {@link DoHAck.DocumentInfo }
     * 
     */
    public DoHAck.DocumentInfo createDoHAckDocumentInfo() {
        return new DoHAck.DocumentInfo();
    }

    /**
     * Create an instance of {@link DoHAck.ItemInfo }
     * 
     */
    public DoHAck.ItemInfo createDoHAckItemInfo() {
        return new DoHAck.ItemInfo();
    }

}
