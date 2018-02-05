package ca.mcmaster.erp.utils.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 28, 2018 6:09:59 PM
 */
@Transactional
public interface BaseEbi<T> {
	public void save(T t);
	public void delete(T t);
	public void update(T t);
	public T get( Serializable uuid);
	public List<T> getAll();
	public List<T> getAll(BaseQueryModel bqm, Integer pageNum, Integer pageCount);
	public List<T> getAll(BaseQueryModel bqm);
	public Integer getCount(BaseQueryModel bqm);
}
