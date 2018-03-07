package ca.mcmaster.erp.invoice.operdetail.model;

import java.util.HashMap;
import java.util.Map;

import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.invoice.goods.model.GoodsModel;
import ca.mcmaster.erp.invoice.store.model.StoreModel;
import ca.mcmaster.erp.utils.format.FormatUtils;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 7, 2018 4:37:06 PM
 */
public class OperDetailModel {
	private Long uuid;
	private Long operTime;
	private Integer type; 
	private Integer num;
	
	private String operTimeView;
	private String typeView;
	
	private EmpModel em;
	private GoodsModel gm;
	private StoreModel sm;
	
	public static final Map<Integer, String> typeMap = new HashMap<Integer, String>();
	private static final Integer OPER_TYPE_OF_IN = 1;
	private static final Integer OPER_TYPE_OF_OUT = 2;
	private static final String OPER_TYPE_OF_IN_VIEW = "Èë¿â";
	private static final String OPER_TYPE_OF_OUT_VIEW = "³ö¿â";
	static{
		typeMap.put(OPER_TYPE_OF_IN, OPER_TYPE_OF_IN_VIEW);
		typeMap.put(OPER_TYPE_OF_OUT, OPER_TYPE_OF_OUT_VIEW);
	}
	
	public String getOperTimeView() {
		return operTimeView;
	}
	public String getTypeView() {
		return typeView;
	}
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public Long getOperTime() {
		return operTime;
	}
	public void setOperTime(Long operTime) {
		this.operTimeView = FormatUtils.formatDateTime(operTime);
		this.operTime = operTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
		this.typeView = typeMap.get(type);
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public EmpModel getEm() {
		return em;
	}
	public void setEm(EmpModel em) {
		this.em = em;
	}
	public GoodsModel getGm() {
		return gm;
	}
	public void setGm(GoodsModel gm) {
		this.gm = gm;
	}
	public StoreModel getSm() {
		return sm;
	}
	public void setSm(StoreModel sm) {
		this.sm = sm;
	}
}
