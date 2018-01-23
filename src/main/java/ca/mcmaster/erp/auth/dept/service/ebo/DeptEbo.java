package ca.mcmaster.erp.auth.dept.service.ebo;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.dept.dao.dao.DeptDao;
import ca.mcmaster.erp.auth.dept.model.DeptModel;
import ca.mcmaster.erp.auth.dept.service.ebi.DeptEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 23, 2018 3:35:13 PM
 */
public class DeptEbo implements DeptEbi {
	@Resource(name="deptDao")
	private DeptDao deptDao;

	@Override
	public void save(DeptModel dm) {
		deptDao.save(dm);
	}

	@Override
	public List<DeptModel> getAll() {
		List<DeptModel> deptList = deptDao.getAll();
		return deptList;
	}
}
