package ca.mcmaster.erp.invoice.bill.dao.dao;

import java.util.List;

import ca.mcmaster.erp.invoice.bill.model.BillQueryModel;

public interface BillDao {
	public List<Object[]> getBuyBill(BillQueryModel bqm);
}