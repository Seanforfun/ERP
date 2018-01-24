package ca.mcmaster.erp.auth.dept.service.ebi;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.erp.auth.dept.model.DeptModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 23, 2018 3:34:37 PM
 */
@Transactional
public interface DeptEbi {

	public void save(DeptModel dm);
	public List<DeptModel> getAll();
	public DeptModel get(Integer uuid);
	public void update(DeptModel dm);
	
}