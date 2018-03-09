package ca.mcmaster.erp.invoice.bill.service.ebi;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.erp.invoice.bill.model.BillQueryModel;
import ca.mcmaster.erp.invoice.orderdetail.model.OrderDetailModel;

@Transactional
public interface BillEbi {
	public List<Object[]> getBuyBillList(BillQueryModel bqm);

	/**
	 * @Description: Get the orderDetailModel by the information saved in bqm
	 * @param bqm
	 * @return
	 */
	public List<OrderDetailModel> getBillByGoods(BillQueryModel bqm);
}
