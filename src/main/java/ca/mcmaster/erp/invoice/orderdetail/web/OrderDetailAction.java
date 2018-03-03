package ca.mcmaster.erp.invoice.orderdetail.web;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.orderdetail.model.OrderDetailModel;
import ca.mcmaster.erp.invoice.orderdetail.service.ebi.OrderDetailEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 3, 2018 6:22:49 PM
 */
@SuppressWarnings("serial")
public class OrderDetailAction extends BaseAction {
	@Resource(name="orderDetailEbi")
	private OrderDetailEbi orderDetailEbi;
	public OrderDetailModel odm  = new OrderDetailModel();
	
	public String save(){
		orderDetailEbi.save(odm);
		return TO_LIST;
	}
	
	public String delete(){
		orderDetailEbi.delete(odm);
		return TO_LIST;
	}
	
	public String list(){
		List<OrderDetailModel> orderDetailList = orderDetailEbi.getAll();
		put("orderDetailList", orderDetailList);
		return LIST;
	}
	
	public String input(){
		if(odm.getUuid() != null){
			odm = orderDetailEbi.get(odm.getUuid());
		}
		return INPUT;
	}
}
