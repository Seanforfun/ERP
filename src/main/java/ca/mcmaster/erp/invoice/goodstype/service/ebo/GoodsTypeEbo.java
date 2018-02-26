package ca.mcmaster.erp.invoice.goodstype.service.ebo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.goodstype.dao.dao.GoodsTypeDao;
import ca.mcmaster.erp.invoice.goodstype.model.GoodsTypeModel;
import ca.mcmaster.erp.invoice.goodstype.service.ebi.GoodsTypeEbi;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 19, 2018 7:28:52 PM
 */
public class GoodsTypeEbo implements GoodsTypeEbi {
	@Resource(name="goodsTypeDao")
	private GoodsTypeDao goodsTypeDao;
	public void save(GoodsTypeModel t) {
		goodsTypeDao.save(t);
	}

	public void delete(GoodsTypeModel t) {
		goodsTypeDao.delete(t);
	}

	public void update(GoodsTypeModel t) {
		goodsTypeDao.update(t);
	}

	public GoodsTypeModel get(Serializable uuid) {
		return goodsTypeDao.get(uuid);
	}

	public List<GoodsTypeModel> getAll() {
		return goodsTypeDao.getAll();
	}

	public List<GoodsTypeModel> getAll(BaseQueryModel bqm, Integer pageNum,
			Integer pageCount) {
		return goodsTypeDao.getAll(bqm, pageNum, pageCount);
	}

	public List<GoodsTypeModel> getAll(BaseQueryModel bqm) {
		return goodsTypeDao.getAll(bqm);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return goodsTypeDao.getCount(bqm);
	}

	public List<GoodsTypeModel> getAllBySm(Long uuid) {
		return goodsTypeDao.getAllBySmUuid(uuid);
	}

	public List<GoodsTypeModel> getAllUnionBySm(Long uuid) {
		return goodsTypeDao.getAllUnionBySm(uuid);
	}
}
