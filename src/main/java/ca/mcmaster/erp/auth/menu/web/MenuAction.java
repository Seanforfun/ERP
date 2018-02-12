package ca.mcmaster.erp.auth.menu.web;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.menu.service.ebi.MenuEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 11, 2018 10:07:09 PM
 */
@SuppressWarnings("serial")
public class MenuAction extends BaseAction {
	@Resource(name="menuEbi")
	private MenuEbi menuEbi;
	
	public String save(){
		return TO_LIST;
	}
	
	public String delete(){
		return TO_LIST;
	}
	
	public String list(){
		return LIST;
	}
	
	public String input(){
		return INPUT;
	}
}
