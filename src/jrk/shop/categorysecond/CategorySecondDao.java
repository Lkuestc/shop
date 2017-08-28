package jrk.shop.categorysecond;

import java.util.List;

import jrk.shop.utils.PageHibernateCallback;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CategorySecondDao extends HibernateDaoSupport {

	public Integer findCount() {
		List<Long> list = this.getHibernateTemplate().find(
				"select count(*) from CategorySecond");
		if (list != null && list.size() != 0) {
			return list.get(0).intValue();
		}
		return null;
	}

	public List<CategorySecond> findByPage(Integer begin, Integer limit) {
		List<CategorySecond> list = this.getHibernateTemplate().executeFind(
				new PageHibernateCallback<CategorySecond>(
						"from CategorySecond", null, begin, limit));
		if (list != null && list.size() != 0) {
			return list;
		}
		return null;
	}

	public void save(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
	}

	public List<CategorySecond> findAll() {
		List<CategorySecond> list = this.getHibernateTemplate().find(
				"from CategorySecond");
		return list;
	}

}
