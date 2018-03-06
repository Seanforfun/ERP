package ca.mcmaster.erp.invoice.store.service.ebo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.store.dao.dao.StoreDao;
import ca.mcmaster.erp.invoice.store.model.StoreModel;
import ca.mcmaster.erp.invoice.store.model.StoreQueryModel;
import ca.mcmaster.erp.invoice.store.service.ebi.StoreEbi;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

public class StoreEbo implements StoreEbi {
	@Resource(name="storeDao")
	private StoreDao storeDao;

	public void save(StoreModel sm) {
		storeDao.save(sm);
	}

	public List<StoreModel> getAll() {
		List<StoreModel> storeList = storeDao.getAll();
		return storeList;
	}

	public StoreModel get(Serializable uuid) {
		StoreModel temp = storeDao.get(uuid);
		return temp;
	}

	public void update(StoreModel sm) {
		storeDao.update(sm);
	}

	public void delete(StoreModel sm) {
		storeDao.delete(sm);
	}

	public List<StoreModel> getAll(StoreQueryModel sqm) {
		List<StoreModel> storeList =storeDao.getAll(sqm);
		return storeList;
	}

	public List<StoreModel> getAll(BaseQueryModel bqm, Integer pageNum,
			Integer pageCount) {
		List<StoreModel> storeList = storeDao.getAll(bqm, pageNum, pageCount);
		return storeList;
	}

	public Integer getCount(BaseQueryModel bqm) {
		Integer count = storeDao.getCount(bqm);
		return count;
	}

	public List<StoreModel> getAll(BaseQueryModel bqm) {
		return null;
	}
}
