package ca.mcmaster.erp.invoice.bill.service.ebo;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.bill.dao.dao.BillDao;
import ca.mcmaster.erp.invoice.bill.model.BillQueryModel;
import ca.mcmaster.erp.invoice.bill.service.ebi.BillEbi;
import ca.mcmaster.erp.invoice.goods.model.GoodsModel;
import ca.mcmaster.erp.invoice.orderdetail.model.OrderDetailModel;
import ca.mcmaster.erp.utils.jchart.JChartUtils;

public class BillEbo implements BillEbi {
	@Resource(name="billDao")
	private BillDao billDao;

	public List<Object[]> getBuyBillList(BillQueryModel bqm) {
		return billDao.getBuyBill(bqm);
	}

	public List<OrderDetailModel> getBillByGoods(BillQueryModel bqm) {
		return billDao.getBuyBillDetails(bqm);
	}

	public void writeJChartToOs(OutputStream os, BillQueryModel bqm) throws IOException {
		//通?dao?取?据
		List<Object[]> billList = billDao.getBuyBill(bqm);
		List<Object[]> dataSetList = new ArrayList<Object[]>();
		//objs[1]存?商品的名?，objs[0]存?商品的?量
		for(Object[] objs : billList){
			dataSetList.add(new Object[]{objs[0], ((GoodsModel)objs[1]).getName()});
		}
		JChartUtils.createChart(dataSetList, os);
	}
}
