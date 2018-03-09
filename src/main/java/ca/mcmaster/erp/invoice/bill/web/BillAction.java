package ca.mcmaster.erp.invoice.bill.web;

import java.util.List;

import javax.annotation.Resource;

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
	
	//----------------------------ajax-------------------------------------------
	public List<OrderDetailModel> odmList;
	public String ajaxGetBillByGood(){
		odmList = billEbi.getBillByGoods(bqm);
		return "ajaxGetBillByGood";
	}
}