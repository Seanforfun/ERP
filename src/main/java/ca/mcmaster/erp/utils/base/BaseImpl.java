package ca.mcmaster.erp.utils.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Jan 28, 2018 5:34:50 PM
 */
public abstract class BaseImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class<T> entityClass; 
	
	public BaseImpl(){
		Type genType = getClass().getGenericSuperclass();   
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();   
		entityClass =  (Class)params[0];  
	}
	
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}
	
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	public T get(Serializable uuid) {
		return this.getHibernateTemplate().get(entityClass, uuid);
	}

	public List<T> getAll() {
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		return this.getHibernateTemplate().findByCriteria(dc);
	}
	
	public List<T> getAll(BaseQueryModel bqm){
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		doCriteria(bqm, dc);
		return this.getHibernateTemplate().findByCriteria(dc);
	}
	
	public List<T> getAll(BaseQueryModel bqm, Integer pageNum, Integer pageCount) {
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		doCriteria(bqm, dc);
		return this.getHibernateTemplate().findByCriteria(dc, (pageNum - 1) * pageCount, pageCount);
	}

	public Integer getCount(BaseQueryModel bqm) {
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		dc.setProjection(Projections.rowCount());
		doCriteria(bqm, dc);
		List<Long> deptCount = this.getHibernateTemplate().findByCriteria(dc);
		return deptCount.get(0).intValue();

	}

	public abstract void doCriteria(BaseQueryModel bqm, DetachedCriteria dc);
}
