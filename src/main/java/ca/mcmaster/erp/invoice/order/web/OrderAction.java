package ca.mcmaster.erp.invoice.order.web;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.invoice.goods.model.GoodsModel;
import ca.mcmaster.erp.invoice.goods.service.ebi.GoodsEbi;
import ca.mcmaster.erp.invoice.goodstype.model.GoodsTypeModel;
import ca.mcmaster.erp.invoice.goodstype.service.ebi.GoodsTypeEbi;
import ca.mcmaster.erp.invoice.order.model.OrderModel;
import ca.mcmaster.erp.invoice.order.model.OrderQueryModel;
import ca.mcmaster.erp.invoice.order.service.ebi.OrderEbi;
import ca.mcmaster.erp.invoice.supplier.model.SupplierModel;
import ca.mcmaster.erp.invoice.supplier.service.ebi.SupplierEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 24, 2018 10:09:15 PM
 */
@SuppressWarnings("serial")
public class OrderAction extends BaseAction {
	public OrderModel om = new OrderModel();
	public OrderQueryModel oqm = new OrderQueryModel();
	@Resource(name="orderEbi")
	private OrderEbi orderEbi;
	@Resource(name="supplierEbi")
	private SupplierEbi supplierEbi;
	@Resource(name="goodsTypeEbi")
	private GoodsTypeEbi goodsTypeEbi;
	@Resource(name="goodsEbi")
	private GoodsEbi goodsEbi;
	
	public String save(){
		orderEbi.save(om);
		return TO_LIST;
	}
	
	public String delete(){
		orderEbi.delete(om);
		return TO_LIST;
	}
	
	public String list(){
		List<OrderModel> orderList = orderEbi.getAll();
		put("orderList", orderList);
		return LIST;
	}
	
	public String input(){
		if(om.getUuid() != null){
			om = orderEbi.get(om.getUuid());
		}
		return INPUT;
	}
	
	//--------------------------------------------------------------------
	public String buyList(){
		setDataTotal(orderEbi.getCount(oqm));
		List<OrderModel> orderList = orderEbi.getAllBuy(oqm, maxPageNum, pageCount);
		put("orderList", orderList);
		return "buyList";
	}
	
	public String buyInput(){
		List<SupplierModel> supplierList = supplierEbi.getAllUnionTwo();
		put("supplierList", supplierList);
		List<GoodsTypeModel> goodsTypeList = goodsTypeEbi.getAllUnionBySm(supplierList.get(0).getUuid());
		put("goodsTypeList", goodsTypeList);
		List<GoodsModel> goodsList = goodsEbi.getAllByGtm(goodsTypeList.get(0).getUuid());
		put("goodsList", goodsList);
		return "buyInput";
	}
	
	public Long[] goodsUuids;
	public Integer[] nums;
	public Double[] prices;
	public String buySave(){
		EmpModel currentUser = getLogin();
		orderEbi.saveBuyOrder(om, goodsUuids, nums, prices, currentUser);
		return "toBuyList"; 
	}
	
	//-------------------------------------------------------------------
	public Long supplierUuid;
	public Long gtmUuid;
	public Long gmUuid;
	private List<GoodsTypeModel> gtmList;
	private List<GoodsModel> goodsList;
	private GoodsModel gm;
	
	public GoodsModel getGm() {
		return gm;
	}

	public List<GoodsTypeModel> getGtmList() {
		return gtmList;
	}
	public List<GoodsModel> getGoodsList() {
		return goodsList;
	}

	public String ajaxGetGtmAndGm(){
		gtmList = goodsTypeEbi.getAllUnionBySm(supplierUuid);
		goodsList = goodsEbi.getAllByGtm(gtmList.get(0).getUuid());
		return "ajaxGetGtmAndGm";
	}
	
	public String used;
	public String ajaxGetGtmAndGm2(){
		gtmList = goodsTypeEbi.getAllUnionBySm(supplierUuid);
		Goods:
			for (int i = gtmList.size() - 1; i >= 0; i--) {
				List<GoodsModel> goodsListTemp = goodsEbi.getAllByGtm(gtmList.get(i).getUuid());
				for(int j = 0; j < goodsListTemp.size(); j++){
					Long goodsUuidTemp = goodsListTemp.get(j).getUuid();
					if(!used.contains("'" + goodsUuidTemp + "'")){
						continue Goods;
					}
				}
				gtmList.remove(i);
			}
		goodsList = goodsEbi.getAllByGtm(gtmList.get(0).getUuid());
		for(int i = goodsList.size() - 1; i >= 0; i--){
			Long uuid = goodsList.get(i).getUuid();
			if (used.contains("'" + uuid.toString() + "'")) {
				goodsList.remove(i);
			}
		}
		return "ajaxGetGtmAndGm";
	}
	
	public String ajaxGetGm(){
		goodsList = goodsEbi.getAllByGtm(gtmUuid);
		for(int i = goodsList.size() - 1; i >= 0; i--){
			Long uuid = goodsList.get(i).getUuid();
			if (used.contains("'" + uuid.toString() + "'")) {
				goodsList.remove(i);
			}
		}
		return "ajaxGetGm";
	}
	
	public String ajaxGetPrice(){
		gm = goodsEbi.get(gmUuid);
		return "ajaxGetPrice";
	}
}
