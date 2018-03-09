package ca.mcmaster.erp.invoice.bill.service.ebo;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.bill.dao.dao.BillDao;
import ca.mcmaster.erp.invoice.bill.model.BillQueryModel;
import ca.mcmaster.erp.invoice.bill.service.ebi.BillEbi;
import ca.mcmaster.erp.invoice.orderdetail.model.OrderDetailModel;

public class BillEbo implements BillEbi {
	@Resource(name="billDao")
	private BillDao billDao;

	public List<Object[]> getBuyBillList(BillQueryModel bqm) {
		return billDao.getBuyBill(bqm);
	}

	public List<OrderDetailModel> getBillByGoods(BillQueryModel bqm) {
		return billDao.getBuyBillDetails(bqm);
	}

}
