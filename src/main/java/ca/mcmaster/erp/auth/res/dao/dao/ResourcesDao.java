package ca.mcmaster.erp.auth.res.dao.dao;

import java.util.List;

import ca.mcmaster.erp.auth.res.model.ResourcesModel;
import ca.mcmaster.erp.utils.base.BaseDao;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Feb 8, 2018 10:17:40 PM
 */
public interface ResourcesDao extends BaseDao<ResourcesModel> {
	public List<ResourcesModel> getAllByEmpUuid(Integer uuid);
}
