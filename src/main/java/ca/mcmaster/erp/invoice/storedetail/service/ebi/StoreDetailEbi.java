package ca.mcmaster.erp.invoice.storedetail.service.ebi;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.erp.invoice.storedetail.model.StoreDetailModel;
import ca.mcmaster.erp.utils.base.BaseEbi;

@Transactional
public interface StoreDetailEbi extends BaseEbi<StoreDetailModel> {

	/**
	 * @Description: Get warning information of all goods.
	 * @return
	 */
	public List<Object[]> getWarningInfo();
}
