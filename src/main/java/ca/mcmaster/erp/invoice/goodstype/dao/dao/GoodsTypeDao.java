package ca.mcmaster.erp.invoice.goodstype.dao.dao;

import java.util.List;

import ca.mcmaster.erp.invoice.goodstype.model.GoodsTypeModel;
import ca.mcmaster.erp.utils.base.BaseDao;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 19, 2018 7:29:41 PM
 */
public interface GoodsTypeDao extends BaseDao<GoodsTypeModel> {
	public List<GoodsTypeModel> getAllBySmUuid(Long uuid);

	public List<GoodsTypeModel> getAllUnionBySm(Long uuid);
}
