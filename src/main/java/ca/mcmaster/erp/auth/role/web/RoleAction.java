package ca.mcmaster.erp.auth.role.web;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.role.model.RoleModel;
import ca.mcmaster.erp.auth.role.service.ebi.RoleEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 8, 2018 9:29:16 PM
 */
@SuppressWarnings("serial")
public class RoleAction extends BaseAction {
	public RoleModel rm = new RoleModel();
	@Resource(name="roleEbi")
	private RoleEbi roleEbi;
	public String save(){
		return null;
	}
	
	public String delete(){
		return null;
	}
	
	public String update(){
		return null;
	}
	
	public String search(){
		return null;
	}
}
