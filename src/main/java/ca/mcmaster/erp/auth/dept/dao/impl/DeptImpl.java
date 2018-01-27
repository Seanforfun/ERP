package ca.mcmaster.erp.auth.dept.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.mcmaster.erp.auth.dept.dao.dao.DeptDao;
import ca.mcmaster.erp.auth.dept.model.DeptModel;
import ca.mcmaster.erp.auth.dept.model.DeptQueryModel;

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

	@Override
	public DeptModel get(Integer uuid) {
		DeptModel temp = this.getHibernateTemplate().get(DeptModel.class, uuid);
		return temp;
	}

	@Override
	public void update(DeptModel dm) {
		this.getHibernateTemplate().update(dm);
	}

	@Override
	public void delete(DeptModel dm) {
		this.getHibernateTemplate().delete(dm);
	}

	@Override
	public List<DeptModel> getAll(DeptQueryModel dqm) {
		DetachedCriteria dc = DetachedCriteria.forClass(DeptModel.class);
		if(dqm.getName() != null && dqm.getName().trim().length() > 0){
			dc.add(Restrictions.like("name", "%" + dqm.getName().trim() + "%"));
		}
		if(dqm.getTele() != null && dqm.getTele().trim().length() > 0){
			dc.add(Restrictions.like("tele", "%" + dqm.getTele().trim() + "%"));
		}
		return this.getHibernateTemplate().findByCriteria(dc);
	}

	@Override
	public List<DeptModel> getAll(DeptQueryModel dqm, Integer pageNum,
			Integer pageCount) {
		DetachedCriteria dc = DetachedCriteria.forClass(DeptModel.class);
		if(dqm.getName() != null && dqm.getName().trim().length() > 0){
			dc.add(Restrictions.like("name", "%" + dqm.getName().trim() + "%"));
		}
		if(dqm.getTele() != null && dqm.getTele().trim().length() > 0){
			dc.add(Restrictions.like("tele", "%" + dqm.getTele().trim() + "%"));
		}
		return this.getHibernateTemplate().findByCriteria(dc, (pageNum - 1) * pageCount, pageCount);
	}

	@Override
	public Integer getCount(DeptQueryModel dqm) {
		DetachedCriteria dc = DetachedCriteria.forClass(DeptModel.class);
		dc.setProjection(Projections.rowCount());
		if(dqm.getName() != null && dqm.getName().trim().length() > 0){
			dc.add(Restrictions.like("name", "%" + dqm.getName().trim() + "%"));
		}
		if(dqm.getTele() != null && dqm.getTele().trim().length() > 0){
			dc.add(Restrictions.like("tele", "%" + dqm.getTele().trim() + "%"));
		}
		List<Long> deptCount = this.getHibernateTemplate().findByCriteria(dc);
		return deptCount.get(0).intValue();
	}
}
