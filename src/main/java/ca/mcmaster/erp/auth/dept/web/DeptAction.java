package ca.mcmaster.erp.auth.dept.web;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.dept.model.DeptModel;
import ca.mcmaster.erp.auth.dept.model.DeptQueryModel;
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
	public DeptQueryModel dqm = new DeptQueryModel(); 
	@Resource(name="deptEbi")
	private DeptEbi deptEbi;
	
	public Integer pageNum = 1;
	public Integer pageCount = 8;
	public Integer maxPageNum;
	public Integer dataTotal;
	
	public String list(){
		dataTotal  = deptEbi.getCount(dqm);
		maxPageNum = (dataTotal + pageCount - 1) / pageCount;
		//Add all info of all depts
		List<DeptModel> deptList = deptEbi.getAll(dqm, pageNum, pageCount);
		//put info into correct scope
		ActionContext.getContext().put("deptList", deptList);
		return "list";
	}
	
	public String queryList(){
		List<DeptModel> deptList = deptEbi.getAll(dqm);
		ActionContext.getContext().put("deptList", deptList);
		return "list";
	}
	
	public String input(){
		if(dm.getUuid() != null){
			dm = deptEbi.get(dm.getUuid());
		}
		return "input";
	}
	
	public String save(){
		if(dm.getUuid() == null){
			deptEbi.save(dm);
		}else{
			deptEbi.update(dm);
		}
		return "toList";
	}
	
	public String delete(){
		deptEbi.delete(dm);
		return "toList";
	}
}
