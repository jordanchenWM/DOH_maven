package internal.service.frame;

import internal.tn.module.BizDoc;
import internal.tn.module.BizDocContent;

public interface IService {

	public void execute(BizDoc bizDoc, BizDocContent bizDocContent) throws Exception;
}
