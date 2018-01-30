package ca.mcmaster.erp.auth.dept.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import ca.mcmaster.erp.auth.dept.dao.dao.DeptDao;
import ca.mcmaster.erp.auth.dept.model.DeptModel;
import ca.mcmaster.erp.auth.dept.model.DeptQueryModel;
import ca.mcmaster.erp.utils.base.BaseImpl;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 23, 2018 3:36:06 PM
 */
public class DeptImpl extends BaseImpl<DeptModel> implements DeptDao {
	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {
		DeptQueryModel dqm = (DeptQueryModel) bqm;
		if(dqm.getName() != null && dqm.getName().trim().length() > 0){
			dc.add(Restrictions.like("name", "%" + dqm.getName().trim() + "%"));
		}
		if(dqm.getTele() != null && dqm.getTele().trim().length() > 0){
			dc.add(Restrictions.like("tele", "%" + dqm.getTele().trim() + "%"));
		}
	}
}
