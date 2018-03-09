package ca.mcmaster.erp.invoice.bill.dao.dao;

import java.util.List;

import ca.mcmaster.erp.invoice.bill.model.BillQueryModel;
import ca.mcmaster.erp.invoice.orderdetail.model.OrderDetailModel;

public interface BillDao {
	public List<Object[]> getBuyBill(BillQueryModel bqm);

	public List<OrderDetailModel> getBuyBillDetails(BillQueryModel bqm);
}