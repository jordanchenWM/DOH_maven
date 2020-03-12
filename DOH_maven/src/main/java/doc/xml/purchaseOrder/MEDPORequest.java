//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 所產生 
// 請參閱 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2019.05.02 於 05:27:30 PM CST 
//


package doc.xml.purchaseOrder;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import doc.xml.common.MessageInfo;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mesgInfo",
    "hispo"
})
@XmlRootElement(name = "HISPurchaseOrderUpdateRequest")
public class MEDPORequest {

    @XmlElement(name = "MesgInfo", required = true, nillable = true)
    protected MessageInfo mesgInfo;
    @XmlElement(name = "HIS_PO", required = true, nillable = true)
    protected List<HpTodd> hispo;

    /*
     * mesgInfo
     */
    public MessageInfo getMesgInfo() {
        return mesgInfo;
    }
    public void setMesgInfo(MessageInfo value) {
        this.mesgInfo = value;
    }

    public List<HpTodd> getHISPO() {
        if (hispo == null) {
            hispo = new ArrayList<HpTodd>();
        }
        return this.hispo;
    }

}
