package ca.mcmaster.erp.auth.res.service.ebo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.res.dao.dao.ResourcesDao;
import ca.mcmaster.erp.auth.res.model.ResourcesModel;
import ca.mcmaster.erp.auth.res.service.ebi.ResourcesEbi;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 8, 2018 10:16:45 PM
 */
public class ResourcesEbo implements ResourcesEbi {
	@Resource(name="resourcesDao")
	private ResourcesDao resourcesDao;
	public void save(ResourcesModel t) {
		resourcesDao.save(t);
	}

	public void delete(ResourcesModel t) {
		resourcesDao.delete(t);
	}

	public void update(ResourcesModel t) {
		resourcesDao.update(t);
	}

	public ResourcesModel get(Serializable uuid) {
		ResourcesModel temp = resourcesDao.get(uuid);
		return temp;
	}

	public List<ResourcesModel> getAll() {
		List<ResourcesModel> resourcesList = resourcesDao.getAll();
		return resourcesList;
	}

	public List<ResourcesModel> getAll(BaseQueryModel bqm, Integer pageNum,
			Integer pageCount) {
		List<ResourcesModel> resourcesList = resourcesDao.getAll(bqm, pageNum, pageCount);
		return resourcesList;
	}

	public List<ResourcesModel> getAll(BaseQueryModel bqm) {
		List<ResourcesModel> resourcesList = resourcesDao.getAll(bqm);
		return resourcesList;
	}

	public Integer getCount(BaseQueryModel bqm) {
		Integer count = resourcesDao.getCount(bqm);
		return count;
	}
}
