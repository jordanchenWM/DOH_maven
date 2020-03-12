package internal.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Throwables;

import internal.db.dao.frame.IBizDoc;
import internal.db.util.DBInjector;
import internal.server.util.DefaultValues;
import internal.service.frame.IService;
import internal.tn.module.BizDoc;
import internal.tn.module.BizDocContent;

public class DefaultProcess implements IService {

	Logger logger = LogManager.getLogger(DefaultValues.serverLog);


	@Override
	public void execute(BizDoc bizDoc, BizDocContent bizDocContent) {
		// TODO Auto-generated method stub
		Map<String, String> dataMap = new HashMap<>();
		dataMap.put(IBizDoc.RoutingStatus, "Done");
		dataMap.put(IBizDoc.UserStatus, "Ignored");
		
		IBizDoc bizDocDao = DBInjector.getInstance(IBizDoc.class);		
		try {
			bizDocDao.update(bizDoc.getDocID(), dataMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(Throwables.getStackTraceAsString(e));
		}
	}

	
	

}
