package service.purchaseOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import doc.xml.common.MessageInfo;
import doc.xml.purchaseOrder.MEDPORequest;
import doc.xml.purchaseOrder.HpTodd;
import doc.xml.util.XmlUtil;
import internal.db.util.DBUtil;
import internal.server.util.DataSourceManager;
import internal.tn.ReceiveFlow;
import internal.tn.module.BizDoc;
import internal.tn.module.BizDocContent;
import service.IService;

public class HISPurchaseOrderXML implements IService {
	
	
	
	public static void main(String[] args) throws Exception {
		HISPurchaseOrderXML h = new HISPurchaseOrderXML();
		h.execute(null, null);
		
	}
	
	@Override
	public void execute(BizDoc bizDoc, BizDocContent bizDocContent) throws Exception {
		
		
			List<HashMap<String, String>> dataList = new ArrayList<>();
			
			String sql = "" ;
			String xml = "" ;
			//ObjectFactory o = new ObjectFactory();
			
			//sql = " Set Rowcount;";
			//sql = "Select * From dbo.hp_todd Where odd_acp_id = '0' ";
			sql = "Select TOP 2 * From dbo.hp_todd ";
			dataList = QueryString(sql);
			
			for (HashMap<String, String> map : dataList) {
				
				MEDPORequest his = new MEDPORequest();
				MessageInfo msg = new MessageInfo();	
				HpTodd hpt = new HpTodd();				
				msg.setProcessID("WeiShengShu2-20030220182615830");
				msg.setSenderID(map.get("odd_hospid"));
				msg.setReceiverID("baird");
				msg.setDocumentType("MED");
				his.setMesgInfo(msg);
				
				hpt = setHpTodd(map);
				his.getHISPO().add(hpt);
				xml = XmlUtil.jaxbObjectToXML(his);
				
				ReceiveFlow flow = new ReceiveFlow();
				flow.startWithoutRule(xml, "text/xml");
			}
	}
	
	public static List<HashMap<String, String>> QueryString(String sql) throws Exception {
		
		List<HashMap<String, String>> dataList = new ArrayList<>();
		
		//DataSourceManager.enable("Sybase");
		Connection conn = DataSourceManager.getConnection("HIS");
		
		
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		/*for(int s = 1; s <= prepare.size(); s++) {
			ps.setString(s, prepare.get(s));
		}*/
		Statement stmt = conn.createStatement();
		
		ResultSet rs = ps.executeQuery();

		ResultSetMetaData rsmd = rs.getMetaData();
		
		List<String> columnNames = new ArrayList<>();
		for (int i = 1; i < rsmd.getColumnCount() +1; i++) {
			columnNames.add(rsmd.getColumnName(i));
		}
		
		while (rs.next()) {
			HashMap<String, String> map = new HashMap<String, String>();
			for (String columnName : columnNames) {
				map.put(columnName, rs.getString(columnName));				
			}
			dataList.add(map);
		}
		
		DBUtil.closeConnection(conn);
		
		return dataList;
	}
	
	public static HpTodd setHpTodd(HashMap<String, String> map) {
		
		HpTodd hpt = new HpTodd();
		
		hpt.setOddNo(map.get("odd_no"));
		hpt.setOddItem(map.get("odd_item"));
		hpt.setOddAllyId(map.get("odd_ally_id"));
		hpt.setOddHospid(map.get("odd_hospid"));
		hpt.setOddAcpId(map.get("odd_acp_id"));
		hpt.setOddIdWay(map.get("odd_id_way"));
		hpt.setOddLab(map.get("odd_lab"));
		hpt.setOddSort(map.get("odd_sort"));
		hpt.setOddPurDt(map.get("odd_pur_dt"));
		hpt.setOddGpNm(map.get("odd_gp_nm"));
		hpt.setOddCtr(map.get("odd_ctr"));
		hpt.setOddCtrId(map.get("odd_ctr_id"));
		hpt.setOddBatItem(map.get("odd_bat_item"));
		hpt.setOddReqDt(map.get("odd_req_dt"));
		hpt.setOddStatus(map.get("odd_status"));
		hpt.setOddOStatus(map.get("odd_o_status"));
		hpt.setOddB2BYn(map.get("odd_b2b_yn"));
		hpt.setOddVdrNo(map.get("odd_vdr_no"));
		hpt.setOddDBrand(map.get("odd_d_brand"));
		hpt.setOddMtr(map.get("odd_mtr"));
		hpt.setOddDesc(map.get("odd_desc"));
		hpt.setOddSpec(map.get("odd_spec"));
		hpt.setOddQty(map.get("odd_qty"));
		hpt.setOddUm(map.get("odd_um"));
		hpt.setOddPrice(map.get("odd_price"));
		hpt.setOddAmt(map.get("odd_amt"));
		hpt.setOddInvDt(map.get("odd_inv_dt"));
		hpt.setOddEmgYn(map.get("odd_emg_yn"));
		hpt.setOddLabYn(map.get("odd_lab_yn"));
		hpt.setOddChefNm(map.get("odd_chef_nm"));
		hpt.setOddSDt(map.get("odd_s_dt"));
		hpt.setOddSTime(map.get("odd_s_time"));
		hpt.setOddRemark(map.get("odd_remark"));
		hpt.setOddAltDt(map.get("odd_alt_dt"));
		hpt.setOddAltTime(map.get("odd_alt_time"));
		hpt.setOddDisRte(map.get("odd_dis_rte"));
		hpt.setOddDisAmt(map.get("odd_dis_amt"));
		hpt.setOddPayAmt(map.get("odd_pay_amt"));
		hpt.setOddDisamt(map.get("odd_disamt"));
		hpt.setOddComNo(map.get("odd_com_no"));
		hpt.setOddBatRemark(map.get("odd_bat_remark"));
		return hpt;
	}

	

}
