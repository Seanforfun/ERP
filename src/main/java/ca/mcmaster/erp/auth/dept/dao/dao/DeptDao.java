package ca.mcmaster.erp.auth.dept.dao.dao;

import java.util.List;

import ca.mcmaster.erp.auth.dept.model.DeptModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 23, 2018 3:35:42 PM
 */
public interface DeptDao {
	public void save(DeptModel dm);
	public List<DeptModel> getAll();
	public DeptModel get(Integer uuid);
	public void update(DeptModel dm);
}
