package ca.mcmaster.erp.auth.res.web;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.res.model.ResourcesModel;
import ca.mcmaster.erp.auth.res.service.ebi.ResourcesEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 8, 2018 10:14:25 PM
 */
@SuppressWarnings("serial")
public class ResourcesAction extends BaseAction {
	public ResourcesModel rm = new ResourcesModel();
	@Resource(name="resourcesEbi")
	private ResourcesEbi resourcesEbi;
	public String save(){
		if(rm.getUuid() == null){
			resourcesEbi.save(rm);
		}else{
			resourcesEbi.update(rm);
		}
		return TO_LIST;
	}
	
	public String delete(){
		resourcesEbi.delete(rm);
		return TO_LIST;
	}
	
	public String list(){
		List<ResourcesModel> resourcesList = resourcesEbi.getAll();
		put("resourcesList", resourcesList);
		return LIST;
	}
	
	public String input(){
		if(rm.getUuid() != null){
			rm = resourcesEbi.get(rm.getUuid());
		}
		return INPUT;
	}
}
