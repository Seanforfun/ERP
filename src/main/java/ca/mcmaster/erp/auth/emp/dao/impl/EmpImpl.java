package ca.mcmaster.erp.auth.emp.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.mcmaster.erp.auth.emp.dao.dao.EmpDao;
import ca.mcmaster.erp.auth.emp.model.EmpModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 22, 2018 12:10:21 PM
 */
public class EmpImpl extends HibernateDaoSupport implements EmpDao{
	@SuppressWarnings("unchecked")
	public EmpModel getUserByUsernameAndPassword(String username, String password){
		List<EmpModel> tmpList = this.getHibernateTemplate().find("from EmpModel where username = ? and password = ?", username, password);
		return tmpList.size() > 0 ? tmpList.get(0) : null;
	}
}
