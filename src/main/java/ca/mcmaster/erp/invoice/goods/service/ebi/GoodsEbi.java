package ca.mcmaster.erp.invoice.goods.service.ebi;

import java.util.List;

import ca.mcmaster.erp.invoice.goods.model.GoodsModel;
import ca.mcmaster.erp.utils.base.BaseEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 21, 2018 1:24:29 PM
 */
public interface GoodsEbi extends BaseEbi<GoodsModel> {
	/**
	 * @Description: Get all goods according to goodsType uuid
	 * @param uuid: uuid of goodsType
	 * @return
	 */
	List<GoodsModel> getAllByGtm(Long uuid);

	/**
	 * @Description: Update the useNum in Quartz.
	 */
	void goodUseNumUpdate();
}
