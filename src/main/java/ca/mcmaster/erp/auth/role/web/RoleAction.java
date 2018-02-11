package ca.mcmaster.erp.auth.role.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.res.model.ResourcesModel;
import ca.mcmaster.erp.auth.res.service.ebi.ResourcesEbi;
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
	@Resource(name="resourcesEbi")
	private ResourcesEbi resourcesEbi;
	public Long[] resUuids;
	
	public String save(){
		if(rm.getUuid() == null){
			roleEbi.save(rm, resUuids);
		}else{
			roleEbi.update(rm,resUuids);
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
		List<ResourcesModel> resList = resourcesEbi.getAll();
		put("resList", resList);
		if(rm.getUuid() != null){
			rm = roleEbi.get(rm.getUuid());
			resUuids = new Long[rm.getResourcesModels().size()];
			int i = 0;
			for(ResourcesModel temp:rm.getResourcesModels()){
				resUuids[i] = temp.getUuid();
				i ++;
			}
		}
		return INPUT;
	}
}
