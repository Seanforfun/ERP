package ca.mcmaster.erp.invoice.goods.web;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.goods.model.GoodsModel;
import ca.mcmaster.erp.invoice.goods.model.GoodsQueryModel;
import ca.mcmaster.erp.invoice.goods.service.ebi.GoodsEbi;
import ca.mcmaster.erp.invoice.goodstype.model.GoodsTypeModel;
import ca.mcmaster.erp.invoice.goodstype.service.ebi.GoodsTypeEbi;
import ca.mcmaster.erp.invoice.supplier.model.SupplierModel;
import ca.mcmaster.erp.invoice.supplier.service.ebi.SupplierEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 21, 2018 1:30:12 PM
 */
@SuppressWarnings("serial")
public class GoodsAction extends BaseAction {
	public GoodsModel gm = new GoodsModel();
	public GoodsQueryModel gqm = new GoodsQueryModel();
	@Resource(name="goodsEbi")
	private GoodsEbi goodsEbi;
	@Resource(name="supplierEbi")
	private SupplierEbi supplierEbi;
	@Resource(name="goodsTypeEbi")
	private GoodsTypeEbi goodsTypeEbi;
	
	public String save(){
		if(gm.getUuid() == null){
			goodsEbi.save(gm);
		}else{
			goodsEbi.update(gm);
		}
		return TO_LIST;
	}
	
	public String delete(){
		goodsEbi.delete(gm);
		return TO_LIST;
	}
	
	public String list(){
		List<SupplierModel> supplierList = supplierEbi.getAll();
		put("supplierList", supplierList);
		List<GoodsModel> goodsList = goodsEbi.getAll(gqm);
		put("goodsList", goodsList);
		return LIST;
	}
	
	public String input(){
		List<SupplierModel> supplierList = supplierEbi.getAllUnion();
		put("supplierList", supplierList);
		List<GoodsTypeModel> gtmList = null;
		Long supplierUuid = null;
		if(gm.getUuid() != null){
			gm = goodsEbi.get(gm.getUuid());
			supplierUuid = gm.getGtm().getSm().getUuid();			
		}else{
			supplierUuid = supplierList.get(0).getUuid();
		}
		gtmList = goodsTypeEbi.getAllBySm(supplierUuid);
		put("gtmList", gtmList);
		return INPUT;
	}
}
