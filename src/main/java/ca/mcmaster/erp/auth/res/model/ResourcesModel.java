package ca.mcmaster.erp.auth.res.model;

import java.util.Set;

import ca.mcmaster.erp.auth.role.model.RoleModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 8, 2018 9:24:24 PM
 */
public class ResourcesModel {
	private Long uuid;
	private String name;
	private String url;
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
