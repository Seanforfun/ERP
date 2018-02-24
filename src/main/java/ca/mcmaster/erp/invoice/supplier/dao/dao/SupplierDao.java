package ca.mcmaster.erp.invoice.supplier.dao.dao;

import java.util.List;

import ca.mcmaster.erp.invoice.supplier.model.SupplierModel;
import ca.mcmaster.erp.utils.base.BaseDao;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 19, 2018 7:03:28 PM
 */
public interface SupplierDao extends BaseDao<SupplierModel> {
	List<SupplierModel> getAllUnion();
}
