package ca.mcmaster.erp.invoice.goodstype.service.ebi;

import java.util.List;

import ca.mcmaster.erp.invoice.goodstype.model.GoodsTypeModel;
import ca.mcmaster.erp.utils.base.BaseEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 19, 2018 7:28:26 PM
 */
public interface GoodsTypeEbi extends BaseEbi<GoodsTypeModel> {
	/**
	 * @Description: Get all goodsTypeModel according to supplier's uuid
	 * @param uuid
	 * @return
	 */
	public List<GoodsTypeModel> getAllBySm(Long uuid);
}
