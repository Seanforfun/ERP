package ca.mcmaster.erp.invoice.goods.service.ebo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.invoice.goods.dao.dao.GoodsDao;
import ca.mcmaster.erp.invoice.goods.model.GoodsModel;
import ca.mcmaster.erp.invoice.goods.service.ebi.GoodsEbi;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 21, 2018 1:25:12 PM
 */
public class GoodsEbo implements GoodsEbi {
	@Resource(name="goodsDao")
	private GoodsDao goodsDao;
	public void save(GoodsModel t) {
		goodsDao.save(t);
	}

	public void delete(GoodsModel t) {
		goodsDao.delete(t);
	}

	public void update(GoodsModel t) {
		goodsDao.update(t);
	}

	public GoodsModel get(Serializable uuid) {
		return goodsDao.get(uuid);
	}

	public List<GoodsModel> getAll() {
		return goodsDao.getAll();
	}

	public List<GoodsModel> getAll(BaseQueryModel bqm, Integer pageNum,
			Integer pageCount) {
		return goodsDao.getAll(bqm, pageNum, pageCount);
	}

	public List<GoodsModel> getAll(BaseQueryModel bqm) {
		return goodsDao.getAll(bqm);
	}

	public Integer getCount(BaseQueryModel bqm) {
		return goodsDao.getCount(bqm);
	}
}
