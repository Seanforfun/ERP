package ca.mcmaster.erp.auth.emp.service.ebo;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.emp.dao.dao.EmpDao;
import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.auth.emp.service.ebi.EmpEbi;
import ca.mcmaster.erp.utils.format.MD5Utils;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 22, 2018 12:07:59 PM
 */
public class EmpEbo implements EmpEbi{
	@Resource(name="empDao")
	private EmpDao empDao;
	public EmpModel login(String username, String password) {
		String md5Pwd = MD5Utils.md5(password);
		EmpModel tmpEmp = empDao.getUserByUsernameAndPassword(username, md5Pwd);
		return tmpEmp;
	}
	
}
