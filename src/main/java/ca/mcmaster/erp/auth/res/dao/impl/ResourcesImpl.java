package ca.mcmaster.erp.auth.res.dao.impl;

import java.util.List;

import javax.persistence.criteria.From;

import org.hibernate.criterion.DetachedCriteria;

import ca.mcmaster.erp.auth.res.dao.dao.ResourcesDao;
import ca.mcmaster.erp.auth.res.model.ResourcesModel;
import ca.mcmaster.erp.utils.base.BaseImpl;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 8, 2018 10:18:41 PM
 */
public class ResourcesImpl extends BaseImpl<ResourcesModel> implements ResourcesDao {

	@Override
	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {
		// TODO Auto-generated method stub
		
	}

	public List<ResourcesModel> getAllByEmpUuid(Integer uuid) {
		String hql = "select distinct res from EmpModel em join em.roleModels role join role.resourcesModels res where em.uuid = ?";
		List<ResourcesModel> resList = this.getHibernateTemplate().find(hql, uuid);
		return resList;
	}

}
