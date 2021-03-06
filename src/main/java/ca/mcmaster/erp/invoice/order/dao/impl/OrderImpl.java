package ca.mcmaster.erp.invoice.order.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
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
		if(oqm.getCreator() != null && oqm.getCreator().getName() != null && oqm.getCreator().getName().trim().length() > 0){
			dc.createAlias("creator", "c1");
			dc.add(Restrictions.like("c1.name", "%" + oqm.getCreator().getName() + "%"));
		}
		if(oqm.getType() != null && oqm.getType() != -1){
			dc.add(Restrictions.eq("type", oqm.getType()));
		}
		if(oqm.getChecker() != null && oqm.getChecker().getName() != null && oqm.getChecker().getName().trim().length() > 0){
			dc.createAlias("checker", "c2");
			dc.add(Restrictions.like("c2.name", "%" + oqm.getChecker().getName() + "%"));
		}
		if(oqm.getCompleter() != null && oqm.getCompleter().getName() != null && oqm.getCompleter().getName().trim().length() > 0){
			dc.createAlias("completer", "c3");
			dc.add(Restrictions.like("c3.name", "%" + oqm.getCompleter().getName() + "%"));
		}
		if(oqm.getCompleter() != null && oqm.getCompleter().getUuid() != null && oqm.getCompleter().getUuid() != -1){
			dc.add(Restrictions.eq("completer", oqm.getCompleter()));
		}
		dc.createAlias("sm", "s");
		if(oqm.getSm() != null && oqm.getSm().getUuid() != null && oqm.getSm().getUuid() != -1){
			dc.add(Restrictions.eq("s.uuid", oqm.getSm().getUuid()));
		}
		if(oqm.getSm() != null && oqm.getSm().getNeeds() != null && oqm.getSm().getNeeds() != -1){
			dc.add(Restrictions.eq("s.needs", oqm.getSm().getNeeds()));
		}
	}
	
	private void doCriteria2(BaseQueryModel bqm, DetachedCriteria dc, Integer[] orderTypes){
		dc.add(Restrictions.in("orderType", orderTypes));
		doCriteria(bqm, dc);
	}
	
	private void doCriteria3(BaseQueryModel bqm, DetachedCriteria dc, Integer[] taskTypes){
		dc.add(Restrictions.in("type", taskTypes));
		doCriteria(bqm, dc);
	}

	public List<OrderModel> getAllOrderTypes(OrderQueryModel oqm,
			Integer maxPageNum, Integer pageCount, Integer[] orderTypes) {
		DetachedCriteria dc = DetachedCriteria.forClass(OrderModel.class);
		doCriteria2(oqm, dc, orderTypes);
		return this.getHibernateTemplate().findByCriteria(dc, (maxPageNum - 1) * pageCount, pageCount);
	}

	public int getCountOrderTypes(OrderQueryModel oqm,
			Integer[] orderTypes) {
		DetachedCriteria dc = DetachedCriteria.forClass(OrderModel.class);
		doCriteria2(oqm, dc, orderTypes);
		dc.setProjection(Projections.rowCount());
		List<Long> count = this.getHibernateTemplate().findByCriteria(dc);
		return count.get(0).intValue();
	}

	public int getCountTypes(OrderQueryModel oqm, Integer[] taskTypes) {
		DetachedCriteria dc = DetachedCriteria.forClass(OrderModel.class);
		doCriteria3(oqm, dc, taskTypes);
		dc.setProjection(Projections.rowCount());
		List<Long> count = this.getHibernateTemplate().findByCriteria(dc);
		return count.get(0).intValue();
	}

	public List<OrderModel> getAllTypes(OrderQueryModel oqm,
			Integer maxPageNum, Integer pageCount, Integer[] taskTypes) {
		DetachedCriteria dc = DetachedCriteria.forClass(OrderModel.class);
		doCriteria3(oqm, dc, taskTypes);
		return this.getHibernateTemplate().findByCriteria(dc);
	}
}
