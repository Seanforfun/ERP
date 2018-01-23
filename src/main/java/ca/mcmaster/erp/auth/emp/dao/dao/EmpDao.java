package ca.mcmaster.erp.auth.emp.dao.dao;

import ca.mcmaster.erp.auth.emp.model.EmpModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 22, 2018 12:10:07 PM
 */
public interface EmpDao {
	public EmpModel getUserByUsernameAndPassword(String username,
			String password);

}
