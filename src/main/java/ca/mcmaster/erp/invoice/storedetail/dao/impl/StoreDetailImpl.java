package ca.mcmaster.erp.invoice.storedetail.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ca.mcmaster.erp.invoice.storedetail.dao.dao.StoreDetailDao;
import ca.mcmaster.erp.invoice.storedetail.model.StoreDetailModel;
import ca.mcmaster.erp.invoice.storedetail.model.StoreDetailQueryModel;
import ca.mcmaster.erp.utils.base.BaseImpl;
import ca.mcmaster.erp.utils.base.BaseQueryModel;

public class StoreDetailImpl extends BaseImpl<StoreDetailModel> implements StoreDetailDao {

	public void doCriteria(BaseQueryModel bqm, DetachedCriteria dc) {
		//TODO doCriteria()
	}

	@SuppressWarnings("unchecked")
	public StoreDetailModel getBySmAndGm(Long storeUuid, Long goodsUuid) {
		String hql = "from StoreDetailModel sdm where sdm.sm.uuid = ? and sdm.gm.uuid = ?";
		List<StoreDetailModel> tempList = this.getHibernateTemplate().find(hql, storeUuid, goodsUuid);
		return tempList.size() > 0 ? tempList.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getWarningInfo() {
		/*select
		g.name,
		(sum(sd.num) < g.minNum) as rmin,
		(sum(sd.num) > g.maxNum) as rmax
		from
			tbl_storedetail sd
		left outer join
			tbl_goods g
		on
			g.uuid = sd.goodsUuid
		group by
			sd.goodsUuid*/
//		String hql = "select g.name, sum(sd.num) < g.minNum, sum(sd.num) > g.maxNum from StoreDetailModel sdm join sdm.gm g group by g.uuid";
//		return this.getHibernateTemplate().find(hql);
		String sql = "select g.name, sum(sd.num) < g.minNum, sum(sd.num) > g.maxNum from tbl_storedetail sd left outer join tbl_goods g on g.uuid = sd.goodsUuid group by sd.goodsUuid";
		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		return sqlQuery.list();
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml", "applicationContext-storeDetail.xml"); 
		StoreDetailDao dao = (StoreDetailDao) ctx.getBean("storeDetailDao");
		System.out.println(dao.getWarningInfo());
	}
}
