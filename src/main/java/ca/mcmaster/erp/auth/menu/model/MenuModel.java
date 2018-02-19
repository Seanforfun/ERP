package ca.mcmaster.erp.auth.menu.model;

import java.util.Set;

import ca.mcmaster.erp.auth.role.model.RoleModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 11, 2018 10:01:05 PM
 */
public class MenuModel {
	public static final Long MENU_SYSTEM_MENU_UUID = 1L;
	private Long uuid;
	private String name;
	private String url;
	private MenuModel parent;
	private Set<MenuModel> children;
	private Set<RoleModel> roleModels;
 	public Set<RoleModel> getRoleModels() {
		return roleModels;
	}
	public void setRoleModels(Set<RoleModel> roleModels) {
		this.roleModels = roleModels;
	}
	public Set<MenuModel> getChildren() {
		return children;
	}
	public void setChildren(Set<MenuModel> children) {
		this.children = children;
	}
	public MenuModel getParent() {
		return parent;
	}
	public void setParent(MenuModel parent) {
		this.parent = parent;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
