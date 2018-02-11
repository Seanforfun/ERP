package ca.mcmaster.erp.auth.emp.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ca.mcmaster.erp.auth.dept.model.DeptModel;
import ca.mcmaster.erp.auth.dept.service.ebi.DeptEbi;
import ca.mcmaster.erp.auth.emp.model.EmpModel;
import ca.mcmaster.erp.auth.emp.model.EmpQueryModel;
import ca.mcmaster.erp.auth.emp.service.ebi.EmpEbi;
import ca.mcmaster.erp.auth.role.model.RoleModel;
import ca.mcmaster.erp.auth.role.service.ebi.RoleEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 22, 2018 12:16:01 PM
 */
@SuppressWarnings("serial")
public class EmpAction extends BaseAction{	
	public EmpModel em = new EmpModel();
	public EmpQueryModel eqm = new EmpQueryModel();
	public String newPassword;
	@Resource(name="empEbi")
	private EmpEbi empEbi;
	@Resource(name="deptEbi")
	private DeptEbi deptEbi;
	@Resource(name="roleEbi")
	private RoleEbi roleEbi;

	public String login() {
		HttpServletRequest request = getRequest();
		String loginIp = request.getHeader("x-forwarded-for"); 
		if(loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) { 
			loginIp = request.getHeader("Proxy-Client-IP"); 
		} 
		if(loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) { 
			loginIp = request.getHeader("WL-Proxy-Client-IP"); 
		} 
		if(loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) { 
			loginIp = request.getRemoteAddr();
		}
		EmpModel tmpEmp = empEbi.login(em.getUsername(), em.getPassword(), loginIp);
		if(null != tmpEmp){
			ActionContext.getContext().getSession().put(EmpModel.LOGIN_EMP, tmpEmp);
		}else{
			this.addActionError("Username or password is incorrect!");
			return "loginFail";
		}
		return "loginSuccess";
	}
	
	public String logout(){
		putSession(EmpModel.LOGIN_EMP, null);
		return "loginFail";
	}
	
	public String toChangePwd(){
		return "toChangePwd";
	}
	
	public String changePwd(){
		String loginName = getLogin();
		Boolean flag = empEbi.changePwd(loginName, em.getPassword(), newPassword);
		if(true == flag){
			putSession(EmpModel.LOGIN_EMP, null);
			return "loginFail";
		}else {
			this.addActionError("Failed to change password!");
			return "toChangePwd";
		}
	}
	
	public String list(){
		List<DeptModel> deptList = deptEbi.getAll();
		super.put("deptList", deptList);
		super.setDataTotal(empEbi.getCount(eqm));
		List<EmpModel> empList = empEbi.getAll(eqm, pageNum, pageCount);
		super.put("empList", empList);
		return LIST;
	}
	
	public String input(){
		List<RoleModel> roleList = roleEbi.getAll();
		put("roleList", roleList);
		List<DeptModel> deptList = deptEbi.getAll();
		super.put("deptList", deptList);
		Integer i = 0;
		if(em.getUuid() != null){
			em = empEbi.get(em.getUuid());
			roleUuids = new Long[em.getRoleModels().size()];
			for(RoleModel rm : em.getRoleModels()){
				roleUuids[i++] = rm.getUuid();
			}
		}
		return INPUT;
	}
	
	public Long[] roleUuids;
	public String save(){
		if(em.getUuid() == null){
			empEbi.save(em, roleUuids);
		}else{
			empEbi.update(em, roleUuids);
		}
		return TO_LIST;
	}
	
	public String delete(){
		empEbi.delete(em);
		return TO_LIST;
	}
}
