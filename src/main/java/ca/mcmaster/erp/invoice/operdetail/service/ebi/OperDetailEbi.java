package ca.mcmaster.erp.invoice.operdetail.service.ebi;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.erp.invoice.operdetail.model.OperDetailModel;
import ca.mcmaster.erp.utils.base.BaseEbi;

@Transactional
public interface OperDetailEbi extends BaseEbi<OperDetailModel> {
	//TODO EmpEbi
}
