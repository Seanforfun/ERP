package ca.mcmaster.erp.auth.emp.service.ebo;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.emp.dao.dao.EmpDao;
import ca.mcmaster.erp.auth.emp.dao.impl.EmpImpl;
import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.auth.emp.service.ebi.EmpEbi;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 22, 2018 12:07:59 PM
 */
public class EmpEbo implements EmpEbi{
	@Resource(name="empDao")
	private EmpDao empDao;
	public EmpModel login(String username, String password) {
		EmpModel tmpEmp = empDao.getUserByUsernameAndPassword(username, password);
		return tmpEmp;
	}
	
}
