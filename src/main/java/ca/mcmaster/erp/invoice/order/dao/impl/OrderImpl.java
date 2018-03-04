package ca.mcmaster.erp.invoice.order.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import ca.mcmaster.erp.invoice.order.dao.dao.OrderDao;
import ca.mcmaster.erp.invoice.order.model.OrderModel;
import ca.mcmaster.erp.invoice.order.model.OrderQueryModel;
import ca.mcmaster.erp.utils.base.BaseImpl;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 24, 2018 10:07:02 PM
 */
public class OrderImpl extends BaseImpl<OrderModel> implements OrderDao {

	@Override
	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {
		// TODO Auto-generated method stub
		OrderQueryModel oqm = (OrderQueryModel)bqm;
		if(oqm != null && oqm.getOrderType() != null && oqm.getOrderType() != -1){
			dc.add(Restrictions.eq("orderType", oqm.getOrderType()));
		}
	}
}
