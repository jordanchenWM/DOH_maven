//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 所產生 
// 請參閱 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2020.03.03 於 04:11:52 PM CST 
//


package doc.xml.invoice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import doc.xml.common.MessageInfo;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mesgInfo",
    "receiptReplyHead",
    "unitPriceInfo",
    "mccdRecoveredInfo"
})

@XmlRootElement(name = "DoHReceiptReply")
public class DoHReceiptReply {

    @XmlElement(name = "MesgInfo", required = true, nillable = true)
    protected MessageInfo mesgInfo;
    @XmlElement(name = "ReceiptReplyHead", required = true, nillable = true)
    protected ReceiptReplyHead receiptReplyHead;
    @XmlElement(name = "UnitPriceInfo", required = true, nillable = true)
    protected UnitPriceInfo unitPriceInfo;
    @XmlElement(name = "MCCDRecoveredInfo", required = true, nillable = true)
    protected RecCCDReocvered mccdRecoveredInfo;

    /**
     * mesgInfo .
     */ 
    public MessageInfo getMesgInfo() {
        return mesgInfo;
    }
    public void setMesgInfo(MessageInfo value) {
        this.mesgInfo = value;
    }

    /**
     *  receiptReplyHead .     * 
     */
    public ReceiptReplyHead getReceiptReplyHead() {
        return receiptReplyHead;
    }
    public void setReceiptReplyHead(ReceiptReplyHead value) {
        this.receiptReplyHead = value;
    }

    /**
     *  unitPriceInfo      *   
     */
    public UnitPriceInfo getUnitPriceInfo() {
        return unitPriceInfo;
    }
    public void setUnitPriceInfo(UnitPriceInfo value) {
        this.unitPriceInfo = value;
    }

    /**
     *  mccdRecoveredInfo     *     
     */
    public RecCCDReocvered getMCCDRecoveredInfo() {
        return mccdRecoveredInfo;
    }
    public void setMCCDRecoveredInfo(RecCCDReocvered value) {
        this.mccdRecoveredInfo = value;
    }


}
