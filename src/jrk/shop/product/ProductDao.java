package jrk.shop.product;

import java.util.List;

import jrk.shop.utils.PageHibernateCallback;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ProductDao extends HibernateDaoSupport {

	public List<Product> findHot() {
		/*
		 * DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		 * criteria.add(Restrictions.eq("is_hot", 1)); List<Product> list =
		 * this.getHibernateTemplate().findByCriteria(criteria,0,10);
		 */
		List<Product> list = this.getHibernateTemplate().executeFind(
				new PageHibernateCallback<Product>(
						"from Product where is_hot = ?", new Object[] { 1 }, 0,
						10));
		return list;
	}

	public List<Product> findNew() {
		List<Product> list = this.getHibernateTemplate().executeFind(
				new PageHibernateCallback<>("from Product order by pdate desc",
						null, 0, 10));
		return list;
	}

	public Integer findCountByCid(Integer cid) {
		String hql = "select count(*) from Product p join p.categorySecond cs join cs.category c where c.cid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, cid);

		return list.get(0).intValue();
	}

	public List<Product> findByPage(Integer cid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?";
		List<Product> list = this.getHibernateTemplate().executeFind(
				new PageHibernateCallback<Product>(hql, new Object[] { cid },
						begin, limit));

		return list;
	}

	public Product findByPid(Integer pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}

	public Integer findCountByCsid(Integer csid) {
		String hql = "select count(*) from Product p join p.categorySecond cs where cs.csid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, csid);
		return list.get(0).intValue();
	}

	public List<Product> findByCsidAndPage(Integer csid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?";
		List<Product> list = this.getHibernateTemplate().executeFind(
				new PageHibernateCallback<Product>(hql, new Object[] { csid },
						begin, limit));
		return list;
	}

	public Integer findCount() {
		List<Long> list = this.getHibernateTemplate().find(
				"select count(*) from Product");
		if (list != null && list.size() != 0) {
			return list.get(0).intValue();

		}
		return null;
	}

	public List<Product> findByPage(int begin, int limit) {
		List<Product> list = this.getHibernateTemplate().executeFind(
				new PageHibernateCallback<Product>("from Product", null, begin,
						limit));
		if (list != null && list.size() != 0) {
			return list;
		}
		return null;
	}

	public void save(Product product) {
		this.getHibernateTemplate().save(product);
	}

}
