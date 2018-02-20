package ca.mcmaster.erp.invoice.goodstype.model;

import ca.mcmaster.erp.invoice.supplier.model.SupplierModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 19, 2018 6:49:00 PM
 */
public class GoodsTypeModel {
	private Long uuid;
	private String name;
	private SupplierModel sm;
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
	public SupplierModel getSm() {
		return sm;
	}
	public void setSm(SupplierModel sm) {
		this.sm = sm;
	}
}
