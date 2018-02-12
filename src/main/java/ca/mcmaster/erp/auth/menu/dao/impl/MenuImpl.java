package ca.mcmaster.erp.auth.menu.dao.impl;

import org.hibernate.criterion.DetachedCriteria;

import ca.mcmaster.erp.auth.menu.dao.dao.MenuDao;
import ca.mcmaster.erp.auth.menu.model.MenuModel;
import ca.mcmaster.erp.utils.base.BaseImpl;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 11, 2018 10:10:17 PM
 */
public class MenuImpl extends BaseImpl<MenuModel> implements MenuDao {
	@Override
	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {
		// TODO Auto-generated method stub
		
	}
}
