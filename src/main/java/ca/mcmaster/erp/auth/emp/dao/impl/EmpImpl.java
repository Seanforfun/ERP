package ca.mcmaster.erp.auth.emp.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import ca.mcmaster.erp.auth.emp.dao.dao.EmpDao;
import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.auth.emp.model.EmpQueryModel;
import ca.mcmaster.erp.utils.base.BaseImpl;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 22, 2018 12:10:21 PM
 */
public class EmpImpl extends BaseImpl<EmpModel> implements EmpDao{
	@SuppressWarnings("unchecked")
	public EmpModel getUserByUsernameAndPassword(String username, String password){
		List<EmpModel> tmpList = this.getHibernateTemplate().find("from EmpModel where username = ? and password = ?", username, password);
		return tmpList.size() > 0 ? tmpList.get(0) : null;
	}

	@Override
	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {
		EmpQueryModel eqm = (EmpQueryModel)bqm;
		// TODO Need to add bqm to database operations
	}
}
