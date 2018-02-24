package ca.mcmaster.erp.invoice.goodstype.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import ca.mcmaster.erp.invoice.goodstype.dao.dao.GoodsTypeDao;
import ca.mcmaster.erp.invoice.goodstype.model.GoodsTypeModel;
import ca.mcmaster.erp.utils.base.BaseImpl;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 19, 2018 7:30:26 PM
 */
public class GoodsTypeImpl extends BaseImpl<GoodsTypeModel> implements
		GoodsTypeDao {
	@Override
	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {
		
	}

	@SuppressWarnings("unchecked")
	public List<GoodsTypeModel> getAllBySmUuid(Long uuid) {
		String hql = "from GoodsTypeModel gtm where gtm.sm.uuid = ?";
		return this.getHibernateTemplate().find(hql, uuid);
	}
}
