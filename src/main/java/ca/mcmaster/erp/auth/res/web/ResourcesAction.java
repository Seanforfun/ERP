package ca.mcmaster.erp.auth.res.web;

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
