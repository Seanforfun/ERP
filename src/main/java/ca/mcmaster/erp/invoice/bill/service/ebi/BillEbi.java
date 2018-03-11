package ca.mcmaster.erp.invoice.bill.service.ebi;

import java.io.IOException;
import java.io.OutputStream;
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

	/**
	 * @Description: Create the pie chart and write the image into output stream
	 * @param os
	 * @param bqm
	 * @throws IOException 
	 */
	public void writeJChartToOs(OutputStream os, BillQueryModel bqm) throws IOException;
}
