package ca.mcmaster.erp.invoice.bill.service.ebi;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.erp.invoice.bill.model.BillQueryModel;

@Transactional
public interface BillEbi {
	List<Object[]> getBuyBillList(BillQueryModel bqm);
}
