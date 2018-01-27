package ca.mcmaster.erp.auth.dept.dao.dao;

import java.util.List;

import ca.mcmaster.erp.auth.dept.model.DeptModel;
import ca.mcmaster.erp.auth.dept.model.DeptQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 23, 2018 3:35:42 PM
 */
public interface DeptDao {
	public void save(DeptModel dm);
	public List<DeptModel> getAll();
	public DeptModel get(Integer uuid);
	public void update(DeptModel dm);
	public void delete(DeptModel dm);
	public List<DeptModel> getAll(DeptQueryModel dqm);
	public List<DeptModel> getAll(DeptQueryModel dqm, Integer pageNum, Integer pageCount);
	public Integer getCount(DeptQueryModel dqm);
}
