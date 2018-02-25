package ca.mcmaster.erp.invoice.goods.dao.dao;

import java.util.List;

import ca.mcmaster.erp.invoice.goods.model.GoodsModel;
import ca.mcmaster.erp.utils.base.BaseDao;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 21, 2018 1:26:11 PM
 */
public interface GoodsDao extends BaseDao<GoodsModel> {
	List<GoodsModel> getAllByGtmUuid(Long uuid);
}
