package ca.mcmaster.erp.invoice.goods.web;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.goods.model.GoodsModel;
import ca.mcmaster.erp.invoice.goods.service.ebi.GoodsEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 21, 2018 1:30:12 PM
 */
@SuppressWarnings("serial")
public class GoodsAction extends BaseAction {
	public GoodsModel gm = new GoodsModel();
	@Resource(name="goodsEbi")
	private GoodsEbi goodsEbi;
	
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
		List<GoodsModel> goodsList = goodsEbi.getAll();
		put("goodsList", goodsList);
		return LIST;
	}
	
	public String input(){
		if(gm.getUuid() != null){
			goodsEbi.get(gm.getUuid());
		}
		return INPUT;
	}
}
