package ca.mcmaster.erp.invoice.order.service.ebo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.erp.invoice.order.dao.dao.OrderDao;
import ca.mcmaster.erp.invoice.order.model.OrderModel;
import ca.mcmaster.erp.invoice.order.service.ebi.OrderEbi;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 24, 2018 10:08:32 PM
 */
@Transactional
public class OrderEbo implements OrderEbi {
	@Resource(name="orderDao")
	private OrderDao orderDao;
	public void save(OrderModel t) {
		orderDao.save(t);
	}

	public void delete(OrderModel t) {
		orderDao.delete(t);
	}

	public void update(OrderModel t) {
		orderDao.update(t);
	}

	public OrderModel get(Serializable uuid) {
		return orderDao.get(uuid);
	}

	public List<OrderModel> getAll() {
		return orderDao.getAll();
	}

	public List<OrderModel> getAll(BaseQueryModel bqm, Integer pageNum,
			Integer pageCount) {
		return orderDao.getAll(bqm, pageNum, pageCount);
	}

	public List<OrderModel> getAll(BaseQueryModel bqm) {
		return orderDao.getAll(bqm);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return orderDao.getCount(bqm);
	}
}
