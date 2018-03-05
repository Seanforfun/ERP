package ca.mcmaster.erp.invoice.order.dao.dao;

import java.util.List;

import ca.mcmaster.erp.invoice.order.model.OrderModel;
import ca.mcmaster.erp.invoice.order.model.OrderQueryModel;
import ca.mcmaster.erp.utils.base.BaseDao;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 24, 2018 10:06:17 PM
 */
public interface OrderDao extends BaseDao<OrderModel> {

	List<OrderModel> getAllOrderTypes(OrderQueryModel oqm, Integer maxPageNum,
			Integer pageCount, Integer[] orderTypes);

	int getCountOrderTypes(OrderQueryModel oqm, Integer[] buyCheckOrderTypes);

	int getCountTypes(OrderQueryModel oqm, Integer[] taskTypes);

	List<OrderModel> getAllTypes(OrderQueryModel oqm, Integer maxPageNum,
			Integer pageCount, Integer[] taskTypes);

}
