package ca.mcmaster.erp.invoice.goodstype.web;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.goodstype.model.GoodsTypeModel;
import ca.mcmaster.erp.invoice.goodstype.service.ebi.GoodsTypeEbi;
import ca.mcmaster.erp.invoice.supplier.model.SupplierModel;
import ca.mcmaster.erp.invoice.supplier.service.ebi.SupplierEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 19, 2018 7:31:24 PM
 */
@SuppressWarnings("serial")
public class GoodsTypeAction extends BaseAction {
	public GoodsTypeModel gm = new GoodsTypeModel();
	@Resource(name="goodsTypeEbi")
	private GoodsTypeEbi goodsTypeEbi;
	@Resource(name="supplierEbi")
	private SupplierEbi supplierEbi;
	
	public String save(){
		if(gm.getUuid() == null){
			goodsTypeEbi.save(gm);
		}else{
			goodsTypeEbi.update(gm);
		}
		return TO_LIST;
	}
	
	public String list(){
		List<GoodsTypeModel> goodsTypeList = goodsTypeEbi.getAll();
		put("goodsTypeList", goodsTypeList);
		return LIST;
	}
	
	public String input(){
		List<SupplierModel> supplierList = supplierEbi.getAll();
		put("supplierList", supplierList);
		if(null != gm.getUuid()){
			gm = goodsTypeEbi.get(gm.getUuid());
		}
		return INPUT;
	}
	
	public String delete(){
		goodsTypeEbi.delete(gm);
		return TO_LIST;
	}
}
