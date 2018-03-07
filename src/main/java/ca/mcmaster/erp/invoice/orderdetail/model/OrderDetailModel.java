package ca.mcmaster.erp.invoice.orderdetail.model;

import ca.mcmaster.erp.invoice.goods.model.GoodsModel;
import ca.mcmaster.erp.invoice.order.model.OrderModel;
import ca.mcmaster.erp.utils.format.FormatUtils;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 3, 2018 4:56:04 PM
 */
public class OrderDetailModel {
	private Long uuid;
	private Integer num;
	private Double price;
	private Integer surplus;
	
	private String priceView;
	private String totalPriceView;
	
	private GoodsModel gm;
	private OrderModel om;
	
	public Integer getSurplus() {
		return surplus;
	}
	public void setSurplus(Integer surplus) {
		this.surplus = surplus;
	}
	public String getTotalPriceView() {
		return totalPriceView;
	}
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.priceView = FormatUtils.formatMoney(price);
		this.totalPriceView = FormatUtils.formatMoney(price * this.num);
		this.price = price;
	}
	public GoodsModel getGm() {
		return gm;
	}
	public void setGm(GoodsModel gm) {
		this.gm = gm;
	}
	public OrderModel getOm() {
		return om;
	}
	public void setOm(OrderModel om) {
		this.om = om;
	}
	public String getPriceView() {
		return priceView;
	}
}
