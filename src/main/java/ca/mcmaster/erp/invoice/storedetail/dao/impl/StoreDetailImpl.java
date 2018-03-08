package ca.mcmaster.erp.invoice.storedetail.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import ca.mcmaster.erp.invoice.storedetail.dao.dao.StoreDetailDao;
import ca.mcmaster.erp.invoice.storedetail.model.StoreDetailModel;
import ca.mcmaster.erp.invoice.storedetail.model.StoreDetailQueryModel;
import ca.mcmaster.erp.utils.base.BaseImpl;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

public class StoreDetailImpl extends BaseImpl<StoreDetailModel> implements StoreDetailDao {

	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {
		//TODO doCriteria()
	}

	@SuppressWarnings("unchecked")
	public StoreDetailModel getBySmAndGm(Long storeUuid, Long goodsUuid) {
		String hql = "from StoreDetailModel sdm where sdm.sm.uuid = ? and sdm.gm.uuid = ?";
		List<StoreDetailModel> tempList = this.getHibernateTemplate().find(hql, storeUuid, goodsUuid);
		return tempList.size() > 0 ? tempList.get(0) : null;
	}
}
