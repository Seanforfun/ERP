package ca.mcmaster.erp.auth.role.model;

import java.util.Set;

import ca.mcmaster.erp.auth.menu.model.MenuModel;
import ca.mcmaster.erp.auth.res.model.ResourcesModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 8, 2018 9:23:00 PM
 */
public class RoleModel {
	private Long uuid;
	private String name;
	private String code;
	private Set<ResourcesModel> resourcesModels;
	private Set<MenuModel> menuModels;
	public Set<MenuModel> getMenuModels() {
		return menuModels;
	}
	public void setMenuModels(Set<MenuModel> menuModels) {
		this.menuModels = menuModels;
	}
	public Set<ResourcesModel> getResourcesModels() {
		return resourcesModels;
	}
	public void setResourcesModels(Set<ResourcesModel> resourcesModels) {
		this.resourcesModels = resourcesModels;
	}
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
