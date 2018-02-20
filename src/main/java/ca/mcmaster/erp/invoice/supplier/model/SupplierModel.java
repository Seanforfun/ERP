package ca.mcmaster.erp.invoice.supplier.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 19, 2018 6:47:24 PM
 */
public class SupplierModel {
	public static final Integer SUPPLIER_NEEDS_IS_YES = 1;
	public static final Integer SUPPLIER_NEEDS_IS_NO = 0;
	
	public static final String SUPPLIER_NEEDS_IS_YES_VIEW = "ËÍ»õ";
	public static final String SUPPLIER_NEEDS_IS_NO_VIEW = "×ÔÌá";
	
	public static final Map<Integer, String> needsMap = new HashMap<Integer, String>();
	
	static{
		needsMap.put(SUPPLIER_NEEDS_IS_YES, SUPPLIER_NEEDS_IS_YES_VIEW);
		needsMap.put(SUPPLIER_NEEDS_IS_NO, SUPPLIER_NEEDS_IS_NO_VIEW);
	}
	
	private Long uuid;
	private String name;
	private String address;
	private String contact;
	private String phone;
	private Integer needs;
	private String needsView;
	public String getNeedsView() {
		return needsView;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getNeeds() {
		return needs;
	}
	public void setNeeds(Integer needs) {
		this.needs = needs;
		this.needsView = needsMap.get(needs);
	}
}
