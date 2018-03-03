package ca.mcmaster.erp.invoice.orderdetail.service.ebo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.orderdetail.dao.dao.OrderDetailDao;
import ca.mcmaster.erp.invoice.orderdetail.model.OrderDetailModel;
import ca.mcmaster.erp.invoice.orderdetail.service.ebi.OrderDetailEbi;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 3, 2018 6:22:00 PM
 */
public class OrderDetailEbo implements OrderDetailEbi {
	@Resource(name="orderDetailDao")
	private OrderDetailDao orderDetailDao;
	public void save(OrderDetailModel t) {
		orderDetailDao.save(t);
	}

	public void delete(OrderDetailModel t) {
		orderDetailDao.delete(t);
	}

	public void update(OrderDetailModel t) {
		orderDetailDao.update(t);
	}

	public OrderDetailModel get(Serializable uuid) {
		return orderDetailDao.get(uuid);
	}

	public List<OrderDetailModel> getAll() {
		return orderDetailDao.getAll();
	}

	public List<OrderDetailModel> getAll(BaseQueryModel bqm, Integer pageNum,
			Integer pageCount) {
		return orderDetailDao.getAll(bqm, pageNum, pageCount);
	}

	public List<OrderDetailModel> getAll(BaseQueryModel bqm) {
		return orderDetailDao.getAll(bqm);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return orderDetailDao.getCount(bqm);
	}
}
