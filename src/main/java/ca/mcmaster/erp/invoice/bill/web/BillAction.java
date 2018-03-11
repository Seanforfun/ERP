package ca.mcmaster.erp.invoice.bill.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import ca.mcmaster.erp.invoice.bill.model.BillQueryModel;
import ca.mcmaster.erp.invoice.bill.service.ebi.BillEbi;
import ca.mcmaster.erp.invoice.order.service.ebi.OrderEbi;
import ca.mcmaster.erp.invoice.orderdetail.model.OrderDetailModel;
import ca.mcmaster.erp.invoice.supplier.model.SupplierModel;
import ca.mcmaster.erp.invoice.supplier.service.ebi.SupplierEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

@SuppressWarnings("serial")
public class BillAction extends BaseAction {
	public BillQueryModel bqm = new BillQueryModel(); 
	@Resource(name="billEbi")
	private BillEbi billEbi;
	@Resource(name="orderEbi")
	private OrderEbi orderEbi;
	@Resource(name="supplierEbi")
	private SupplierEbi supplierEbi;
	public String buyBillList(){
		/*select 
			od.goodsUuid,
			g.name,
			sum(od.num)
		from 
			tbl_orderdetail od,
			tbl_goods g
		where
			g.uuid = od.goodsUuid
		group by
			g.uuid*/
		List<Object[]> billList = billEbi.getBuyBillList(bqm);
		put("billList", billList);
		List<SupplierModel> supplierList = supplierEbi.getAll();
		put("supplierList", supplierList);
		return "buyBillList";
	}
	
	public void pieBill() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		ServletOutputStream os = response.getOutputStream();
		billEbi.writeJChartToOs(os, bqm);
	}
	
	//----------------------------ajax-------------------------------------------
	public List<OrderDetailModel> odmList;
	public String ajaxGetBillByGood(){
		odmList = billEbi.getBillByGoods(bqm);
		return "ajaxGetBillByGood";
	}
}