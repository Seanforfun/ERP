package ca.mcmaster.erp.invoice.storedetail.dao.dao;

import java.util.List;

import ca.mcmaster.erp.invoice.storedetail.model.StoreDetailModel;
import ca.mcmaster.erp.invoice.storedetail.model.StoreDetailQueryModel;
import ca.mcmaster.erp.utils.base.BaseDao;

public interface StoreDetailDao extends BaseDao<StoreDetailModel> {
	//TODO StoreDetailDao
		StoreDetailModel getBySmAndGm(Long storeUuid, Long goodsUuid);

		List<Object[]> getWarningInfo();
}