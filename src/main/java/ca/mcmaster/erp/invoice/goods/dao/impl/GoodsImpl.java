package ca.mcmaster.erp.invoice.goods.dao.impl;

import org.hibernate.criterion.DetachedCriteria;

import ca.mcmaster.erp.invoice.goods.dao.dao.GoodsDao;
import ca.mcmaster.erp.invoice.goods.model.GoodsModel;
import ca.mcmaster.erp.utils.base.BaseImpl;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 21, 2018 1:26:42 PM
 */
public class GoodsImpl extends BaseImpl<GoodsModel> implements GoodsDao {
	@Override
	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {
		
	}
}
