package ca.mcmaster.erp.auth.menu.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import ca.mcmaster.erp.auth.menu.dao.dao.MenuDao;
import ca.mcmaster.erp.auth.menu.model.MenuModel;
import ca.mcmaster.erp.auth.menu.model.MenuQueryModel;
import ca.mcmaster.erp.utils.base.BaseImpl;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 11, 2018 10:10:17 PM
 */
public class MenuImpl extends BaseImpl<MenuModel> implements MenuDao {
	@Override
	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {
		MenuQueryModel mqm = (MenuQueryModel) bqm;
		dc.add(Restrictions.ne("uuid", MenuModel.MENU_SYSTEM_MENU_UUID));
		if(mqm.getName() != null && mqm.getName().trim().length() > 0){
			dc.add(Restrictions.like("name", "%" +mqm.getName().trim()+ "%"));
		}
		if(mqm.getParent() != null && mqm.getParent().getUuid() != null && mqm.getParent().getUuid() != -1){
			dc.add(Restrictions.eq("parent", mqm.getParent()));
		}
	}

	public List<MenuModel> getByPuuidIsOneOrZero() {
		String hql = "from MenuModel where parent.uuid = ? or uuid = ?";
		return this.getHibernateTemplate().find(hql, MenuModel.MENU_SYSTEM_MENU_UUID, MenuModel.MENU_SYSTEM_MENU_UUID);
	}

	public List<MenuModel> getAllLevelOneByEmpUuid(Integer loginUuid) {
		String hql ="select distinct mm from MenuModel mm join mm.roleModels role join role.empModels emp where mm.parent.uuid = ? and emp.uuid = ? order by mm.uuid";
		return this.getHibernateTemplate().find(hql, MenuModel.MENU_SYSTEM_MENU_UUID, loginUuid);
	}

	public List<MenuModel> getByEmpAndPUuid(Integer loginUuid,
			Long parentUuid) {
		String hql = "select distinct mm from MenuModel mm join mm.roleModels role join role.empModels emp where mm.parent.uuid = ? and emp.uuid = ? order by mm.uuid";
		return this.getHibernateTemplate().find(hql, parentUuid, loginUuid);
	}
}
