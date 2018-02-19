package ca.mcmaster.erp.auth.role.web;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.menu.model.MenuModel;
import ca.mcmaster.erp.auth.menu.service.ebi.MenuEbi;
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
	@Resource(name="menuEbi")
	private MenuEbi menuEbi;
	public Long[] resUuids;
	public Long[] menuUuids;
	
	public String save(){
		if(rm.getUuid() == null){
			roleEbi.save(rm, resUuids, menuUuids);
		}else{
			roleEbi.update(rm,resUuids, menuUuids);
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
		List<MenuModel> menuList = menuEbi.getAll();
		put("menuList", menuList);
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
			menuUuids = new Long[rm.getMenuModels().size()];
			i = 0;
			for(MenuModel mm : rm.getMenuModels()){
				menuUuids[i] = mm.getUuid();
				i++;
			}
		}
		return INPUT;
	}
}
