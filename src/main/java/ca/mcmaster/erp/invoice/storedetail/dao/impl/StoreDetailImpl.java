package ca.mcmaster.erp.invoice.storedetail.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import ca.mcmaster.erp.invoice.storedetail.dao.dao.StoreDetailDao;
import ca.mcmaster.erp.invoice.storedetail.model.StoreDetailModel;
import ca.mcmaster.erp.invoice.storedetail.model.StoreDetailQueryModel;
import ca.mcmaster.erp.utils.base.BaseImpl;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

public class StoreDetailImpl extends BaseImpl<StoreDetailModel> implements StoreDetailDao {

	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {
		StoreDetailQueryModel sqm = (StoreDetailQueryModel) bqm;
		//TODO doCriteria()
	}
}
