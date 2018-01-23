package ca.mcmaster.erp.auth.dept.web;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.dept.model.DeptModel;
import ca.mcmaster.erp.auth.dept.service.ebi.DeptEbi;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 23, 2018 3:37:51 PM
 */
@SuppressWarnings("serial")
public class DeptAction extends ActionSupport {
	public DeptModel dm = new DeptModel();
	@Resource(name="deptEbi")
	private DeptEbi deptEbi;
	
	public String list(){
		//Add all info of all depts
		List<DeptModel> deptList = deptEbi.getAll();
		//put info into correct scope
		ActionContext.getContext().put("deptList", deptList);
		return "list";
	}
	
	public String input(){
		return "input";
	}
	
	public String save(){
		deptEbi.save(dm);
		return list();
	}
}
