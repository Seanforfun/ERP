package ca.mcmaster.erp.utils.base;

import java.io.Serializable;
import java.util.List;

import ca.mcmaster.erp.auth.dept.model.DeptModel;
import ca.mcmaster.erp.auth.dept.model.DeptQueryModel;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 28, 2018 5:24:04 PM
 */
public interface BaseDao<T> {
	public void save(T t);
	public void delete(T t);
	public void update(T t);
	public T get( Serializable uuid);
	public List<T> getAll();
	public List<T> getAll(BaseQueryModel bqm, Integer pageNum, Integer pageCount);
	public List<T> getAll(BaseQueryModel bqm);
	public Integer getCount(BaseQueryModel bqm);
}
