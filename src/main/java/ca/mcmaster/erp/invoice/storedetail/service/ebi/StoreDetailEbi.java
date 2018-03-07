package ca.mcmaster.erp.invoice.storedetail.service.ebi;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.erp.invoice.storedetail.model.StoreDetailModel;
import ca.mcmaster.erp.utils.base.BaseEbi;

@Transactional
public interface StoreDetailEbi extends BaseEbi<StoreDetailModel> {
	//TODO EmpEbi
}
