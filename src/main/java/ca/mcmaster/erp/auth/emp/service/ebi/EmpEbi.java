package ca.mcmaster.erp.auth.emp.service.ebi;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.utils.base.BaseEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 22, 2018 6:08:39 PM
 */
@Transactional
public interface EmpEbi extends BaseEbi<EmpModel> {

	/**
	 * @Description: User login service
	 * @param username
	 * @param password
	 * @param loginIp
	 * @return
	 */
	public EmpModel login(String username, String password, String loginIp);
	
	/**
	 * @Description: Change password service
	 * @param loginName
	 * @param password
	 * @param newPassword
	 * @return 
	 * True: Change password success.
	 * False:Failed to change password
	 */
	public Boolean changePwd(String loginName, String password, String newPassword);
}
