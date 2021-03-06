package ca.mcmaster.erp.invoice.order.service.ebi;

import java.util.List;

import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.invoice.order.model.OrderModel;
import ca.mcmaster.erp.invoice.order.model.OrderQueryModel;
import ca.mcmaster.erp.invoice.orderdetail.model.OrderDetailModel;
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

	int getCountBuyCheck(OrderQueryModel oqm);

	List<OrderModel> getAllBuyCheck(OrderQueryModel oqm, Integer maxPageNum,
			Integer pageCount);

	/**
	 * @Description: Pass a buy order.
	 * @param uuid: The Order uuid of the order approved
	 * @param empModel 
	 */
	void buyCheckPass(Long uuid, EmpModel checker);

	/**
	 * @Description: Reject a buy order.
	 * @param uuid: The Order uuid of the order rejected
	 * @param empModel 
	 */
	void buyCheckReject(Long uuid, EmpModel login);

	int getCountTask(OrderQueryModel oqm);

	List<OrderModel> getAllTask(OrderQueryModel oqm, Integer maxPageNum,
			Integer pageCount);

	/**
	 * @Description: Assign task to transport employees
	 * @param uuid
	 * @param completer
	 */
	void assignTask(Long uuid, EmpModel completer);

	/**
	 * @Description: Get tasks number for current login transport employee
	 * @param oqm
	 * @param empModel
	 * @return
	 */
	Integer getCountBuyLogin(OrderQueryModel oqm, EmpModel empModel);

	/**
	 * @Description: Get tasks for current login transport employee
	 * @param oqm
	 * @param maxPageNum
	 * @param pageCount
	 * @param login
	 * @return
	 */
	List<OrderModel> getAllTask(OrderQueryModel oqm, Integer maxPageNum,
			Integer pageCount, EmpModel login);

	/**
	 * @Description: End the task with given uuid
	 * @param uuid
	 */
	void endTask(Long uuid);

	Integer getCountInStore(OrderQueryModel oqm);

	List<OrderModel> getAllInStore(OrderQueryModel oqm, Integer maxPageNum,
			Integer pageCount);

	/**
	 * @Description: TODO
	 * @param storeUuid
	 * @param odmUuid
	 * @param num
	 * @param login
	 */
	OrderDetailModel inGoods(Long storeUuid, Long odmUuid, Integer num, EmpModel login);
}
