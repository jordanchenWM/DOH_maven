package internal.db.dao.frame;

import com.google.inject.AbstractModule;

import internal.db.dao.*;



public class DbModule extends AbstractModule{

	//private String className = "";
	
	public DbModule() {
		//System.out.println("new....");
	}
	/*
	public MyModule(String className) {
		this.className = className;
	}*/
	
	@Override
    protected void configure() {     	
		bind(IActivityLog.class).to(ActivityLogDao.class);	
		bind(IBizDoc.class).to(BizDocDao.class);	
		bind(IBizDocContent.class).to(BizDocContentDao.class);		
		bind(IBizDocType.class).to(BizDocTypeDao.class);	
		bind(IPartnerField.class).to(PartnerFieldDao.class);
		bind(IPartnerDelivery.class).to(PartnerDeliveryDao.class);
		bind(IProcessingRule.class).to(ProcessingRuleDao.class);	
		bind(IDB_Info.class).to(DB_InfoDao.class);	
		bind(ITask.class).to(UserTaskDao.class);	
    }
}
