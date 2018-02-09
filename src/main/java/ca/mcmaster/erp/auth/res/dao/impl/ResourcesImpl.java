package ca.mcmaster.erp.auth.res.dao.impl;

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

}
