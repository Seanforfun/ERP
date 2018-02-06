package ca.mcmaster.erp.auth.emp.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

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
		if(eqm.getUsername() != null && eqm.getUsername().trim().length() > 0){
			dc.add(Restrictions.like("username", "%" + eqm.getUsername().trim() + "%"));
		}
		if(eqm.getName() != null && eqm.getName().trim().length() > 0){
			dc.add(Restrictions.like("name", "%" + eqm.getName().trim() + "%"));
		}
		if(eqm.getEmail() != null && eqm.getEmail().trim().length() > 0){
			dc.add(Restrictions.like("email", "%" +eqm.getEmail().trim()+ "%"));
		}
		if(eqm.getTele() != null && eqm.getTele().trim().length() > 0){
			dc.add(Restrictions.like("tele", "%" +eqm.getTele().trim()+ "%"));
		}
		if(eqm.getGender() != null && eqm.getGender() != null){
			if(eqm.getGender() != -1)
				dc.add(Restrictions.eq("gender", eqm.getGender()));
		}
		if(eqm.getDm() != null && eqm.getDm().getUuid() != null){
			if(eqm.getDm().getUuid() != -1)
				dc.add(Restrictions.eq("dm", eqm.getDm()));
		}
		if(eqm.getBirthday() != null){
			dc.add(Restrictions.ge("birthday", eqm.getBirthday()));
		}
		if(eqm.getBirthdayMax() != null){
			dc.add(Restrictions.le("birthday", eqm.getBirthdayMax() + 86400000 - 1));
		}
	}

	public Boolean changePwdByNameAndPassword(String loginName, String md5Pwd,
			String md5NewPwd) {
		String hql = "update EmpModel set password = ? where name = ? and password = ?";
		int row = this.getHibernateTemplate().bulkUpdate(hql, md5NewPwd, loginName, md5Pwd);
		return row > 0;
	}
}
