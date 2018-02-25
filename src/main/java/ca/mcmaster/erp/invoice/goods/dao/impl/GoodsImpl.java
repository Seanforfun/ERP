package ca.mcmaster.erp.invoice.goods.dao.impl;

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
}
