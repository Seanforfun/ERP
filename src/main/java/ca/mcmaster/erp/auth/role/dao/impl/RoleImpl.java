package ca.mcmaster.erp.auth.role.dao.impl;

import org.hibernate.criterion.DetachedCriteria;

import ca.mcmaster.erp.auth.role.model.RoleModel;
import ca.mcmaster.erp.utils.base.BaseImpl;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 8, 2018 9:57:51 PM
 */
public class RoleImpl extends BaseImpl<RoleModel> {
	@Override
	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {
		
	}
}
