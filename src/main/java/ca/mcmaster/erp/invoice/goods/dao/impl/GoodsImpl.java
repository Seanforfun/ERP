package ca.mcmaster.erp.invoice.goods.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import ca.mcmaster.erp.invoice.goods.dao.dao.GoodsDao;
import ca.mcmaster.erp.invoice.goods.model.GoodsModel;
import ca.mcmaster.erp.invoice.goods.model.GoodsQueryModel;
import ca.mcmaster.erp.utils.base.BaseImpl;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 21, 2018 1:26:42 PM
 */
public class GoodsImpl extends BaseImpl<GoodsModel> implements GoodsDao {
	@Override
	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {
		GoodsQueryModel gqm = (GoodsQueryModel)bqm;
		if(gqm != null && gqm.getUnit() != null && gqm.getUnit().trim().length() > 0){
			dc.add(Restrictions.eq("unit", gqm.getUnit().trim()));
		}
		if(gqm != null && gqm.getGtm()!= null&&gqm.getGtm().getSm()!=null&&gqm.getGtm().getSm().getUuid() != null && gqm.getGtm().getSm().getUuid() != -1){
			dc.createAlias("gtm", "g");			
			dc.add(Restrictions.eq("g.sm", gqm.getGtm().getSm()));
		}
	}

	@SuppressWarnings("unchecked")
	public List<GoodsModel> getAllByGtmUuid(Long uuid) {
		String hql = "select distinct gm from GoodsModel gm where gtm.uuid = ?";
		return this.getHibernateTemplate().find(hql, uuid);
	}

	public void goodUseNumUpdate() {
		/*update
		tbl_goods g
		set
			useNum = 
		(
		select
			count(uuid)
		from
			tbl_orderdetail
		where
			goodsuuid = g.uuid
		)*/
		String hql = "update GoodsModel g set useNum = (select count(odm.uuid) from OrderDetailModel odm where g.uuid = odm.gm.uuid)";
		this.getHibernateTemplate().bulkUpdate(hql);
	}
}
