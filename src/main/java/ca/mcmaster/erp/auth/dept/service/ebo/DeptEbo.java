package ca.mcmaster.erp.auth.dept.service.ebo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.dept.dao.dao.DeptDao;
import ca.mcmaster.erp.auth.dept.model.DeptModel;
import ca.mcmaster.erp.auth.dept.model.DeptQueryModel;
import ca.mcmaster.erp.auth.dept.service.ebi.DeptEbi;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 23, 2018 3:35:13 PM
 */
public class DeptEbo implements DeptEbi {
	@Resource(name="deptDao")
	private DeptDao deptDao;

	public void save(DeptModel dm) {
		deptDao.save(dm);
	}

	public List<DeptModel> getAll() {
		List<DeptModel> deptList = deptDao.getAll();
		return deptList;
	}

	public DeptModel get(Serializable uuid) {
		DeptModel temp = deptDao.get(uuid);
		return temp;
	}

	public void update(DeptModel dm) {
		deptDao.update(dm);
	}

	public void delete(DeptModel dm) {
		deptDao.delete(dm);
	}

	public List<DeptModel> getAll(DeptQueryModel dqm) {
		List<DeptModel> deptList =deptDao.getAll(dqm);
		return deptList;
	}

	@Override
	public List<DeptModel> getAll(BaseQueryModel bqm, Integer pageNum,
			Integer pageCount) {
		List<DeptModel> deptList = deptDao.getAll(bqm, pageNum, pageCount);
		return deptList;
	}

	@Override
	public Integer getCount(BaseQueryModel bqm) {
		Integer count = deptDao.getCount(bqm);
		return count;
	}
}
