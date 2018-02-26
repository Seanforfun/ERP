package ca.mcmaster.erp.invoice.supplier.service.ebo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.supplier.dao.dao.SupplierDao;
import ca.mcmaster.erp.invoice.supplier.model.SupplierModel;
import ca.mcmaster.erp.invoice.supplier.service.ebi.SupplierEbi;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 19, 2018 7:02:43 PM
 */
public class SupplierEbo implements SupplierEbi {
	@Resource(name="supplierDao")
	private SupplierDao supplierDao;
	public void save(SupplierModel t) {
		supplierDao.save(t);
	}

	public void delete(SupplierModel t) {
		supplierDao.delete(t);
	}

	public void update(SupplierModel t) {
		supplierDao.update(t);
	}

	public SupplierModel get(Serializable uuid) {
		return supplierDao.get(uuid);
	}

	public List<SupplierModel> getAll() {
		return supplierDao.getAll();
	}

	public List<SupplierModel> getAll(BaseQueryModel bqm, Integer pageNum,
			Integer pageCount) {
		return supplierDao.getAll(bqm, pageNum, pageCount);
	}

	public List<SupplierModel> getAll(BaseQueryModel bqm) {
		return supplierDao.getAll(bqm);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return supplierDao.getCount(bqm);
	}

	public List<SupplierModel> getAllUnion() {
		return supplierDao.getAllUnion();
	}

	public List<SupplierModel> getAllUnionTwo() {
		return supplierDao.getAllUnionTwo();
	}
}
