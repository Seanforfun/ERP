package ca.mcmaster.erp.invoice.storedetail.service.ebo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.storedetail.dao.dao.StoreDetailDao;
import ca.mcmaster.erp.invoice.storedetail.model.StoreDetailModel;
import ca.mcmaster.erp.invoice.storedetail.model.StoreDetailQueryModel;
import ca.mcmaster.erp.invoice.storedetail.service.ebi.StoreDetailEbi;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

public class StoreDetailEbo implements StoreDetailEbi {
	@Resource(name="storeDetailDao")
	private StoreDetailDao storeDetailDao;

	public void save(StoreDetailModel sm) {
		storeDetailDao.save(sm);
	}

	public List<StoreDetailModel> getAll() {
		List<StoreDetailModel> storeDetailList = storeDetailDao.getAll();
		return storeDetailList;
	}

	public StoreDetailModel get(Serializable uuid) {
		StoreDetailModel temp = storeDetailDao.get(uuid);
		return temp;
	}

	public void update(StoreDetailModel sm) {
		storeDetailDao.update(sm);
	}

	public void delete(StoreDetailModel sm) {
		storeDetailDao.delete(sm);
	}

	public List<StoreDetailModel> getAll(StoreDetailQueryModel sqm) {
		List<StoreDetailModel> storeDetailList =storeDetailDao.getAll(sqm);
		return storeDetailList;
	}

	public List<StoreDetailModel> getAll(BaseQueryModel bqm, Integer pageNum,
			Integer pageCount) {
		List<StoreDetailModel> storeDetailList = storeDetailDao.getAll(bqm, pageNum, pageCount);
		return storeDetailList;
	}

	public Integer getCount(BaseQueryModel bqm) {
		Integer count = storeDetailDao.getCount(bqm);
		return count;
	}

	public List<StoreDetailModel> getAll(BaseQueryModel bqm) {
		return null;
	}
}
