package ca.mcmaster.erp.auth.menu.dao.dao;

import java.util.List;

import ca.mcmaster.erp.auth.menu.model.MenuModel;
import ca.mcmaster.erp.utils.base.BaseDao;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 11, 2018 10:09:30 PM
 */
public interface MenuDao extends BaseDao<MenuModel> {
	public List<MenuModel> getByPuuidIsOneOrZero();
}
