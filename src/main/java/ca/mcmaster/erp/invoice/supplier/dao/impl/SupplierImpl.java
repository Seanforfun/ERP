package ca.mcmaster.erp.invoice.supplier.dao.impl;

import org.hibernate.criterion.DetachedCriteria;

import ca.mcmaster.erp.invoice.supplier.dao.dao.SupplierDao;
import ca.mcmaster.erp.invoice.supplier.model.SupplierModel;
import ca.mcmaster.erp.utils.base.BaseImpl;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 19, 2018 7:04:06 PM
 */
public class SupplierImpl extends BaseImpl<SupplierModel> implements
		SupplierDao {

	@Override
	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {
		
	}

}
