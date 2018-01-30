package ca.mcmaster.erp.auth.dept.web;

import java.util.List;

import javax.annotation.Resource;

import ca.mcmaster.erp.auth.dept.model.DeptModel;
import ca.mcmaster.erp.auth.dept.model.DeptQueryModel;
import ca.mcmaster.erp.auth.dept.service.ebi.DeptEbi;
import ca.mcmaster.erp.utils.base.BaseAction;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 23, 2018 3:37:51 PM
 */
@SuppressWarnings("serial")
public class DeptAction extends BaseAction {
	public DeptModel dm = new DeptModel();
	public DeptQueryModel dqm = new DeptQueryModel(); 
	@Resource(name="deptEbi")
	private DeptEbi deptEbi;
	
	public String list(){
		super.setDataTotal(dataTotal);
		List<DeptModel> deptList = deptEbi.getAll(dqm, pageNum, pageCount);
		super.put("deptList", deptList);
		return LIST;
	}
	
	public String input(){
		if(dm.getUuid() != null){
			dm = deptEbi.get(dm.getUuid());
		}
		return INPUT;
	}
	
	public String save(){
		if(dm.getUuid() == null){
			deptEbi.save(dm);
		}else{
			deptEbi.update(dm);
		}
		return TO_LIST;
	}
	
	public String delete(){
		deptEbi.delete(dm);
		return TO_LIST;
	}
}
