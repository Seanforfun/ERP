package ca.mcmaster.erp.invoice.order.model;

import java.util.HashMap;
import java.util.Map;

import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.invoice.supplier.model.SupplierModel;
import ca.mcmaster.erp.utils.format.FormatUtils;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 24, 2018 10:03:16 PM
 */
public class OrderModel {
	public static final Integer ORDER_ORDERTYPE_OF_BUY = 1;
	public static final Integer ORDER_ORDERTYPE_OF_SALE = 2;
	public static final Integer ORDER_ORDERTYPE_OF_RETURN_BUY = 3;
	public static final Integer ORDER_ORDERTYPE_OF_RETURN_SALE = 4;
	
	public static final String ORDER_ORDERTYPE_OF_BUY_VIEW = "²É¹º";
	public static final String ORDER_ORDERTYPE_OF_SALE_VIEW = "ÏúÊÛ";
	public static final String ORDER_ORDERTYPE_OF_RETURN_BUY_VIEW = "²É¹ºÍË»õ";
	public static final String ORDER_ORDERTYPE_OF_RETURN_SALE_VIEW = "ÏúÊÛÍË»õ";
	
	
	public static final Integer ORDER_TYPE_OF_BUY_NO_CHECK = 111;
	public static final Integer ORDER_TYPE_OF_BUY_CHECK_PASS = 121;
	public static final Integer ORDER_TYPE_OF_BUY_CHECK_REJECT = 120;
	public static final Integer ORDER_TYPE_OF_BUY_BUYING = 131;
	public static final Integer ORDER_TYPE_OF_BUY_IN_STORE = 141;
	public static final Integer ORDER_TYPE_OF_BUY_COMPLETE = 199;
	
	public static final String ORDER_TYPE_OF_BUY_NO_CHECK_VIEW = "Î´ÉóºË";
	public static final String ORDER_TYPE_OF_BUY_CHECK_PASS_VIEW = "Í¨¹ý";
	public static final String ORDER_TYPE_OF_BUY_CHECK_REJECT_VIEW = "²µ»Ø";
	public static final String ORDER_TYPE_OF_BUY_BUYING_VIEW = "²É¹ºÖÐ";
	public static final String ORDER_TYPE_OF_BUY_IN_STORE_VIEW = "Èë¿âÖÐ";
	public static final String ORDER_TYPE_OF_BUY_COMPLETE_VIEW= "½áµ¥";
	
	public static final Integer ORDER_TYPE_OF_SALE_NO_CHECK = 211;
	public static final Integer ORDER_TYPE_OF_SALE_BUY_CHECK_PASS = 221;
	
	public static final String ORDER_TYPE_OF_SALE_NO_CHECK_VIEW = "Î´ÉóºË";
	public static final String ORDER_TYPE_OF_SALE_BUY_CHECK_PASS_VIEW = "Í¨¹ý";
	
	public static final Map<Integer, String> orderTypeMap = new HashMap<Integer, String>();
	public static final Map<Integer, String> orderMap = new HashMap<Integer, String>();
	static{
		orderTypeMap.put(ORDER_ORDERTYPE_OF_BUY, ORDER_ORDERTYPE_OF_BUY_VIEW);
		orderTypeMap.put(ORDER_ORDERTYPE_OF_SALE, ORDER_ORDERTYPE_OF_SALE_VIEW);
		orderTypeMap.put(ORDER_ORDERTYPE_OF_RETURN_BUY, ORDER_ORDERTYPE_OF_RETURN_BUY_VIEW);
		orderTypeMap.put(ORDER_ORDERTYPE_OF_RETURN_SALE, ORDER_ORDERTYPE_OF_RETURN_SALE_VIEW);
		orderMap.put(ORDER_TYPE_OF_BUY_NO_CHECK, ORDER_TYPE_OF_BUY_NO_CHECK_VIEW);
		orderMap.put(ORDER_TYPE_OF_BUY_CHECK_PASS, ORDER_TYPE_OF_BUY_CHECK_PASS_VIEW);
		orderMap.put(ORDER_TYPE_OF_BUY_CHECK_REJECT, ORDER_TYPE_OF_BUY_CHECK_REJECT_VIEW);
		orderMap.put(ORDER_TYPE_OF_BUY_BUYING, ORDER_TYPE_OF_BUY_BUYING_VIEW);
		orderMap.put(ORDER_TYPE_OF_BUY_IN_STORE, ORDER_TYPE_OF_BUY_IN_STORE_VIEW);
		orderMap.put(ORDER_TYPE_OF_BUY_COMPLETE, ORDER_TYPE_OF_BUY_COMPLETE_VIEW);
		orderMap.put(ORDER_TYPE_OF_SALE_NO_CHECK, ORDER_TYPE_OF_SALE_NO_CHECK_VIEW);
		orderMap.put(ORDER_TYPE_OF_SALE_BUY_CHECK_PASS, ORDER_TYPE_OF_SALE_BUY_CHECK_PASS_VIEW);
	}
	
	
	private Long uuid;
	
	private String orderNum;
	private Integer totalNum;
	
	private Double totalPrice;
	private Long createTime;
	private Long checkTime;
	private Long endTime;
	private Integer orderType;
	private Integer type;
	
	private String createTimeView;
	private String checkTimeView;
	private String endTimeView;
	private String orderTypeView;
	private String typeView;
	private String totalPriceView;
	
	private EmpModel creator;
	private EmpModel checker;
	private EmpModel completer;
	private SupplierModel sm;
	public String getTotalPriceView() {
		return totalPriceView;
	}
	public String getTypeView() {
		return typeView;
	}
	public String getOrderTypeView() {
		return orderTypeView;
	}
	public String getCreateTimeView() {
		return createTimeView;
	}
	public String getCheckTimeView() {
		return checkTimeView;
	}
	public String getEndTimeView() {
		return endTimeView;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public EmpModel getCreator() {
		return creator;
	}
	public void setCreator(EmpModel creator) {
		this.creator = creator;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTimeView = FormatUtils.formatDateTime(createTime);
		this.createTime = createTime;
	}
	public EmpModel getChecker() {
		return checker;
	}
	public void setChecker(EmpModel checker) {
		this.checker = checker;
	}
	public Long getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Long checkTime) {
		this.checkTimeView = FormatUtils.formatDateTime(checkTime);
		this.checkTime = checkTime;
	}
	public EmpModel getCompleter() {
		return completer;
	}
	public void setCompleter(EmpModel completer) {
		this.completer = completer;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTimeView = FormatUtils.formatDateTime(endTime); 
		this.endTime = endTime;
	}
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderTypeView = orderTypeMap.get(orderType);
		this.orderType = orderType;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPriceView = FormatUtils.formatMoney(totalPrice);
		this.totalPrice = totalPrice;
	}
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public SupplierModel getSm() {
		return sm;
	}
	public void setSm(SupplierModel sm) {
		this.sm = sm;
	}
}
