package ca.mcmaster.erp.auth.role.web;

import java.util.List;

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
		if(rm.getUuid() == null){
			roleEbi.save(rm);
		}else{
			roleEbi.update(rm);
		}
		return TO_LIST;
	}
	
	public String delete(){
		roleEbi.delete(rm);
		return TO_LIST;
	}
	
	
	public String list(){
		List<RoleModel> roleList = roleEbi.getAll();
		put("roleList", roleList);
		return LIST;
	}
	
	public String input(){
		if(rm.getUuid() != null){
			rm = roleEbi.get(rm.getUuid());
		}
		return INPUT;
	}
}
