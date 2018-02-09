package ca.mcmaster.erp.auth.role.service.ebo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.role.dao.dao.RoleDao;
import ca.mcmaster.erp.auth.role.model.RoleModel;
import ca.mcmaster.erp.auth.role.service.ebi.RoleEbi;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 8, 2018 9:32:52 PM
 */
public class RoleEbo implements RoleEbi {
	@Resource(name="roleDao")
	private RoleDao roleDao;
	public void save(RoleModel t) {
		roleDao.save(t);
	}

	public void delete(RoleModel t) {
		roleDao.delete(t);
	}

	public void update(RoleModel t) {
		roleDao.update(t);
	}

	public RoleModel get(Serializable uuid) {
		RoleModel temp = roleDao.get(uuid);
		return temp;
	}

	public List<RoleModel> getAll() {
		List<RoleModel> roleList = roleDao.getAll();
		return roleList;
	}

	public List<RoleModel> getAll(BaseQueryModel bqm, Integer pageNum,
			Integer pageCount) {
		List<RoleModel> roleList = roleDao.getAll(bqm, pageNum, pageCount);
		return roleList;
	}

	public List<RoleModel> getAll(BaseQueryModel bqm) {
		List<RoleModel> roleList = roleDao.getAll(bqm);
		return roleList;
	}

	public Integer getCount(BaseQueryModel bqm) {
		Integer count = roleDao.getCount(bqm);
		return count;
	}
}
