package ca.mcmaster.erp.auth.emp.dao.dao;

import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.utils.base.BaseDao;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 22, 2018 12:10:07 PM
 */
public interface EmpDao extends BaseDao<EmpModel>{
	public EmpModel getUserByUsernameAndPassword(String username,
			String password);
}
