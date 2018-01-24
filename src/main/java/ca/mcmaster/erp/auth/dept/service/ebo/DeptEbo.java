package ca.mcmaster.erp.auth.dept.service.ebo;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.dept.dao.dao.DeptDao;
import ca.mcmaster.erp.auth.dept.model.DeptModel;
import ca.mcmaster.erp.auth.dept.model.DeptQueryModel;
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

	@Override
	public DeptModel get(Integer uuid) {
		DeptModel temp = deptDao.get(uuid);
		return temp;
	}

	@Override
	public void update(DeptModel dm) {
		deptDao.update(dm);
	}

	@Override
	public void delete(DeptModel dm) {
		deptDao.delete(dm);
	}

	@Override
	public List<DeptModel> getAll(DeptQueryModel dqm) {
		List<DeptModel> deptList =deptDao.getAll(dqm);
		return deptList;
	}
}
