package ca.mcmaster.erp.invoice.order.web;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.order.model.OrderModel;
import ca.mcmaster.erp.invoice.order.model.OrderQueryModel;
import ca.mcmaster.erp.invoice.order.service.ebi.OrderEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 24, 2018 10:09:15 PM
 */
@SuppressWarnings("serial")
public class OrderAction extends BaseAction {
	public OrderModel om = new OrderModel();
	public OrderQueryModel oqm = new OrderQueryModel();
	@Resource(name="orderEbi")
	private OrderEbi orderEbi;
	
	public String save(){
		orderEbi.save(om);
		return TO_LIST;
	}
	
	public String delete(){
		orderEbi.delete(om);
		return TO_LIST;
	}
	
	public String list(){
		List<OrderModel> orderList = orderEbi.getAll();
		put("orderList", orderList);
		return LIST;
	}
	
	public String input(){
		if(om.getUuid() != null){
			om = orderEbi.get(om.getUuid());
		}
		return INPUT;
	}
	
	//--------------------------------------------------------------------
	public String buyList(){
		return "buyList";
	}
	
	public String buyInput(){
		
		return "buyInput";
	}
}
