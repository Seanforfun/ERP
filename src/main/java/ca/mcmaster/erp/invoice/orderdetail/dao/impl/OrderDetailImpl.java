package ca.mcmaster.erp.invoice.orderdetail.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import ca.mcmaster.erp.invoice.orderdetail.dao.dao.OrderDetailDao;
import ca.mcmaster.erp.invoice.orderdetail.model.OrderDetailModel;
import ca.mcmaster.erp.utils.base.BaseImpl;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Mar 3, 2018 6:19:50 PM
 */
public class OrderDetailImpl extends BaseImpl<OrderDetailModel> implements
		OrderDetailDao {
	@Override
	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {
		// TODO Auto-generated method stub
		
	}
}
