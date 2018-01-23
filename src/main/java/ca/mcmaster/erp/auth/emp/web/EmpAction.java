package ca.mcmaster.erp.auth.emp.web;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.auth.emp.service.ebi.EmpEbi;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 22, 2018 12:16:01 PM
 */
public class EmpAction extends ActionSupport implements ModelDriven<EmpModel> {
	private static final long serialVersionUID = 1L;
	public static final String LOGIN_EMP = "login_emp";
	public EmpModel em = new EmpModel();
	@Resource(name="empEbi")
	private EmpEbi empEbi;

	public String login() {
		EmpModel tmpEmp = empEbi.login(em.getUsername(), em.getPassword());
		if(null != tmpEmp){
			ActionContext.getContext().getSession().put(LOGIN_EMP, tmpEmp.getName());
		}else{
			this.addActionError("Username or password is incorrect!");
			return "loginFail";
		}
		return "loginSuccess";
	}

	public EmpModel getModel() {
		return em;
	}

}