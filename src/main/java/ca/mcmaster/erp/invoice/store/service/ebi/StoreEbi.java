package ca.mcmaster.erp.invoice.store.service.ebi;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.erp.invoice.store.model.StoreModel;
import ca.mcmaster.erp.utils.base.BaseEbi;

@Transactional
public interface StoreEbi extends BaseEbi<StoreModel> {
	//TODO EmpEbi
}
