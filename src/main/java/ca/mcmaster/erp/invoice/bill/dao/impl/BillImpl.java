package ca.mcmaster.erp.invoice.bill.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.mcmaster.erp.invoice.bill.dao.dao.BillDao;
import ca.mcmaster.erp.invoice.bill.model.BillQueryModel;
import ca.mcmaster.erp.invoice.orderdetail.model.OrderDetailModel;

public class BillImpl extends HibernateDaoSupport implements BillDao {
	@SuppressWarnings("unchecked")
	public List<Object[]> getBuyBill(BillQueryModel bqm) {
		/*select 
		od.goodsUuid,
		g.name,
		sum(od.num)
	from 
		tbl_orderdetail od,
		tbl_goods g
	where
		g.uuid = od.goodsUuid
	group by
		g.uuid*/
//		String hql = "select g.uuid, g.name, sum(od.num)from OrderDetailModel od join od.gm g group by g.uuid";
		DetachedCriteria dc = DetachedCriteria.forClass(OrderDetailModel.class);
		if(bqm.getType() != null && bqm.getType() != -1){
			dc.createAlias("om", "o");
			dc.add(Restrictions.eq("o.type", bqm.getType()));
		}
		if(bqm.getSupplierUuid() != null && bqm.getSupplierUuid() != -1){
			dc.createAlias("gm", "g");
			dc.createAlias("g.gtm", "gt");
			dc.createAlias("gt.sm", "s");
			dc.add(Restrictions.eq("s.uuid", bqm.getSupplierUuid()));
		}
		ProjectionList pList = Projections.projectionList();
		pList.add(Projections.sum("num"));
		pList.add(Projections.groupProperty("gm"));
		dc.setProjection(pList);
		return this.getHibernateTemplate().findByCriteria(dc);
	}

	@SuppressWarnings("unchecked")
	public List<OrderDetailModel> getBuyBillDetails(BillQueryModel bqm) {
		/*	select
				*
			from
				tbl_orderdetail od
			left outer join
				tbl_goods g
			on
				od.goodsuuid = g.uuid
			left outer join
				tbl_order o
			on
				od.orderuuid = o.uuid
			where
				g.uuid = ? */
		DetachedCriteria dc = DetachedCriteria.forClass(OrderDetailModel.class);
		if(bqm.getType() != null && bqm.getType() != -1){
			dc.createAlias("om", "o");
			dc.add(Restrictions.eq("o.type", bqm.getType()));
		}
		dc.add(Restrictions.eq("gm.uuid", bqm.getGoodsUuid()));
		return this.getHibernateTemplate().findByCriteria(dc);
	}
}
