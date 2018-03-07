package ca.mcmaster.erp.invoice.operdetail.service.ebo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.operdetail.dao.dao.OperDetailDao;
import ca.mcmaster.erp.invoice.operdetail.model.OperDetailModel;
import ca.mcmaster.erp.invoice.operdetail.model.OperDetailQueryModel;
import ca.mcmaster.erp.invoice.operdetail.service.ebi.OperDetailEbi;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

public class OperDetailEbo implements OperDetailEbi {
	@Resource(name="operDetailDao")
	private OperDetailDao operDetailDao;

	public void save(OperDetailModel om) {
		operDetailDao.save(om);
	}

	public List<OperDetailModel> getAll() {
		List<OperDetailModel> operDetailList = operDetailDao.getAll();
		return operDetailList;
	}

	public OperDetailModel get(Serializable uuid) {
		OperDetailModel temp = operDetailDao.get(uuid);
		return temp;
	}

	public void update(OperDetailModel om) {
		operDetailDao.update(om);
	}

	public void delete(OperDetailModel om) {
		operDetailDao.delete(om);
	}

	public List<OperDetailModel> getAll(OperDetailQueryModel oqm) {
		List<OperDetailModel> operDetailList =operDetailDao.getAll(oqm);
		return operDetailList;
	}

	public List<OperDetailModel> getAll(BaseQueryModel bqm, Integer pageNum,
			Integer pageCount) {
		List<OperDetailModel> operDetailList = operDetailDao.getAll(bqm, pageNum, pageCount);
		return operDetailList;
	}

	public Integer getCount(BaseQueryModel bqm) {
		Integer count = operDetailDao.getCount(bqm);
		return count;
	}

	public List<OperDetailModel> getAll(BaseQueryModel bqm) {
		return null;
	}
}
