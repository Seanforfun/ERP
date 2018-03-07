package ca.mcmaster.erp.invoice.operdetail.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import ca.mcmaster.erp.invoice.operdetail.dao.dao.OperDetailDao;
import ca.mcmaster.erp.invoice.operdetail.model.OperDetailModel;
import ca.mcmaster.erp.invoice.operdetail.model.OperDetailQueryModel;
import ca.mcmaster.erp.utils.base.BaseImpl;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

public class OperDetailImpl extends BaseImpl<OperDetailModel> implements OperDetailDao {

	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {
		OperDetailQueryModel oqm = (OperDetailQueryModel) bqm;
		//TODO doCriteria()
	}
}
