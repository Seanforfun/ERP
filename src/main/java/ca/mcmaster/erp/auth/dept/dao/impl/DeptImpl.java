package ca.mcmaster.erp.auth.dept.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.mcmaster.erp.auth.dept.dao.dao.DeptDao;
import ca.mcmaster.erp.auth.dept.model.DeptModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 23, 2018 3:36:06 PM
 */
public class DeptImpl extends HibernateDaoSupport implements DeptDao {

	@Override
	public void save(DeptModel dm) {
		this.getHibernateTemplate().save(dm);
	}

	@Override
	public List<DeptModel> getAll() {
		String hql = "from DeptModel";
		return this.getHibernateTemplate().find(hql);
	}

}
