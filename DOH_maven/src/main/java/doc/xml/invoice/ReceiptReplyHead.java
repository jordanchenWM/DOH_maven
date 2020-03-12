package doc.xml.invoice;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "receiptReplySummary",
    "hospitalInfo",
    "vendorInfo"
})
public class ReceiptReplyHead {

    @XmlElement(name = "ReceiptReplySummary", required = true, nillable = true)
    protected ReceiptReplyHead.ReceiptReplySummary receiptReplySummary;
    @XmlElement(name = "HospitalInfo", required = true, nillable = true)
    protected ReceiptReplyHead.HospitalInfo hospitalInfo;
    @XmlElement(name = "VendorInfo", required = true, nillable = true)
    protected ReceiptReplyHead.VendorInfo vendorInfo;

    /**
     *  receiptReplySummary
     */
    public ReceiptReplyHead.ReceiptReplySummary getReceiptReplySummary() {
        return receiptReplySummary;
    }
    public void setReceiptReplySummary(ReceiptReplyHead.ReceiptReplySummary value) {
        this.receiptReplySummary = value;
    }

    /**
     *  hospitalInfo 
     */
    public ReceiptReplyHead.HospitalInfo getHospitalInfo() {
        return hospitalInfo;
    }
    public void setHospitalInfo(ReceiptReplyHead.HospitalInfo value) {
        this.hospitalInfo = value;
    }

    /**
     *  vendorInfo 
     */
    public ReceiptReplyHead.VendorInfo getVendorInfo() {
        return vendorInfo;
    }
    public void setVendorInfo(ReceiptReplyHead.VendorInfo value) {
        this.vendorInfo = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "hospitalID"
    })
    public static class HospitalInfo {

        @XmlElement(name = "HospitalID", required = true, nillable = true)
        protected String hospitalID;

        /**
         *  hospitalID
         */ 
        public String getHospitalID() {
            return hospitalID;
        }
        public void setHospitalID(String value) {
            this.hospitalID = value;
        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "receiptNo",
        "status",
        "updateTime"
    })
    public static class ReceiptReplySummary {

    	@XmlElement(name = "ReceiptNo", required = false)
        protected String receiptNo;
        @XmlElement(name = "Status", required = false)
        protected String status;
        @XmlElement(name = "UpdateTime", required = false)
        protected String updateTime;

        /**
         *  receiptNo
         */
        public String getReceiptNo() {
            return receiptNo;
        }
        public void setReceiptNo(String value) {
            this.receiptNo = value;
        }

        /**
         *  status
         */
        public String getStatus() {
            return status;
        }
        public void setStatus(String value) {
            this.status = value;
        }

        /**
         *  updateTime
         */
        public String getUpdateTime() {
            return updateTime;
        }
        public void setUpdateTime(String value) {
            this.updateTime = value;
        }

    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "vendorID",
        "replyTime",
        "memo"
    })
    public static class VendorInfo {

        @XmlElement(name = "VendorID", required = true, nillable = true)
        protected String vendorID;
        @XmlElement(name = "ReplyTime", required = true, nillable = true)
        protected String replyTime;
        @XmlElement(name = "Memo", required = false)
        protected String memo;

        /**
         *  vendorID  
         */
        public String getVendorID() {
            return vendorID;
        }
        public void setVendorID(String value) {
            this.vendorID = value;
        }

        /**
         * 取得 replyTime
         */
        public String getReplyTime() {
            return replyTime;
        }
        public void setReplyTime(String value) {
            this.replyTime = value;
        }

        /**
         *  memo 
         */
        public String getMemo() {
            return memo;
        }
        public void setMemo(String value) {
            this.memo = value;
        }

    }

}