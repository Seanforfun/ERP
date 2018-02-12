package ca.mcmaster.erp.auth.menu.web;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.menu.model.MenuModel;
import ca.mcmaster.erp.auth.menu.model.MenuQueryModel;
import ca.mcmaster.erp.auth.menu.service.ebi.MenuEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 11, 2018 10:07:09 PM
 */
@SuppressWarnings("serial")
public class MenuAction extends BaseAction {
	public MenuModel mm = new MenuModel();
	public MenuQueryModel mqm = new MenuQueryModel();
	@Resource(name="menuEbi")
	private MenuEbi menuEbi;
	
	public String save(){
		if(mm.getUuid() == null){
			menuEbi.save(mm);
		}else{
			menuEbi.update(mm);
		}
		return TO_LIST;
	}
	
	public String delete(){
		menuEbi.delete(mm);
		return TO_LIST;
	}
	
	public String list(){
		setDataTotal(menuEbi.getCount(mqm));
		List<MenuModel> menuList = menuEbi.getAll(mqm, maxPageNum, pageCount);
		put("menuList", menuList);
		return LIST;
	}
	
	public String input(){
		if(mm.getUuid() != null){
			mm = menuEbi.get(mm.getUuid());
		}
		List<MenuModel> menuList = menuEbi.getAllLevelOne();
		put("menuList", menuList);
		return INPUT;
	}
}
