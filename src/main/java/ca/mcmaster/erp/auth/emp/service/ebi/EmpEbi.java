package ca.mcmaster.erp.auth.emp.service.ebi;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.erp.auth.emp.model.EmpModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 22, 2018 6:08:39 PM
 */
@Transactional
public interface EmpEbi {
	/**
	 * @Description: TODO User login
	 * @param username
	 * @param password
	 * @return EmpMode or null
	 */
	public EmpModel login(String username, String password);
}
