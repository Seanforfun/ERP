package ca.mcmaster.erp.invoice.goods.model;

import ca.mcmaster.erp.invoice.goodstype.model.GoodsTypeModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 21, 2018 1:12:33 PM
 */
public class GoodsModel {
	private Long uuid;
	private String name;
	private String origin;
	private String producer;
	private String unit;
	private Double inprice;
	private Double outprice;
	private GoodsTypeModel gtm;
	public GoodsTypeModel getGtm() {
		return gtm;
	}
	public void setGtm(GoodsTypeModel gtm) {
		this.gtm = gtm;
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
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Double getInprice() {
		return inprice;
	}
	public void setInprice(Double inprice) {
		this.inprice = inprice;
	}
	public Double getOutprice() {
		return outprice;
	}
	public void setOutprice(Double outprice) {
		this.outprice = outprice;
	}
}
