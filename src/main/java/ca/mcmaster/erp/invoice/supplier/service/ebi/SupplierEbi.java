package ca.mcmaster.erp.invoice.supplier.service.ebi;

import java.util.List;

import ca.mcmaster.erp.invoice.supplier.model.SupplierModel;
import ca.mcmaster.erp.utils.base.BaseEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 19, 2018 7:01:19 PM
 */
public interface SupplierEbi extends BaseEbi<SupplierModel> {
	/**
	 * @Description: Get all suppliers whose goodsType is not null
	 * @return
	 */
	public List<SupplierModel> getAllUnion();
}
