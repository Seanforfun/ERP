package ca.mcmaster.erp.invoice.store.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import ca.mcmaster.erp.invoice.store.dao.dao.StoreDao;
import ca.mcmaster.erp.invoice.store.model.StoreModel;
import ca.mcmaster.erp.invoice.store.model.StoreQueryModel;
import ca.mcmaster.erp.utils.base.BaseImpl;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

public class StoreImpl extends BaseImpl<StoreModel> implements StoreDao {

	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {
		StoreQueryModel sqm = (StoreQueryModel) bqm;
		//TODO doCriteria()
	}
}
