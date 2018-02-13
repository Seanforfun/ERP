package ca.mcmaster.erp.auth.menu.service.ebo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.menu.dao.dao.MenuDao;
import ca.mcmaster.erp.auth.menu.model.MenuModel;
import ca.mcmaster.erp.auth.menu.service.ebi.MenuEbi;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 11, 2018 10:08:32 PM
 */
public class MenuEbo implements MenuEbi {
	@Resource(name="menuDao")
	private MenuDao menuDao;
	public void save(MenuModel t) {
		menuDao.save(t);
	}

	public void delete(MenuModel t) {
		MenuModel temp = menuDao.get(t.getUuid());
		menuDao.delete(temp);
	}

	public void update(MenuModel t) {
		MenuModel tempMenu = menuDao.get(t.getUuid());
		tempMenu.setName(t.getName());
		tempMenu.setUrl(t.getUrl());
		menuDao.update(tempMenu);
	}

	public MenuModel get(Serializable uuid) {
		return menuDao.get(uuid);
	}

	public List<MenuModel> getAll() {
		return menuDao.getAll();
	}

	public List<MenuModel> getAll(BaseQueryModel bqm, Integer pageNum,
			Integer pageCount) {
		List<MenuModel> menuList = menuDao.getAll(bqm, pageNum, pageCount);
		return menuList;
	}

	public List<MenuModel> getAll(BaseQueryModel bqm) {
		List<MenuModel> menuList = menuDao.getAll(bqm);
		return menuList;
	}

	public Integer getCount(BaseQueryModel bqm) {
		Integer count = menuDao.getCount(bqm);
		return count;
	}

	public List<MenuModel> getAllLevelOne() {
		return menuDao.getByPuuidIsOneOrZero();
	}
}
