package ca.mcmaster.erp.auth.menu.model;
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
