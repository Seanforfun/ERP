package ca.mcmaster.erp.invoice.order.service.ebi;

import java.util.List;

import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.invoice.order.model.OrderModel;
import ca.mcmaster.erp.invoice.order.model.OrderQueryModel;
import ca.mcmaster.erp.utils.base.BaseEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 24, 2018 10:08:02 PM
 */
public interface OrderEbi extends BaseEbi<OrderModel> {

	/**
	 * @Description: Create order
	 * @param om
	 * @param goodsUuids
	 * @param nums
	 * @param prices
	 * @param currentUser
	 */
	void saveBuyOrder(OrderModel om, Long[] goodsUuids, Integer[] nums,
			Double[] prices, EmpModel currentUser);

	/**
	 * @Description: Get all Buying orders
	 * @param oqm
	 * @param maxPageNum
	 * @param pageCount
	 * @return
	 */
	List<OrderModel> getAllBuy(OrderQueryModel oqm, Integer maxPageNum,
			Integer pageCount);

}
