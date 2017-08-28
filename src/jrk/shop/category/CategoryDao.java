package jrk.shop.category;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CategoryDao extends HibernateDaoSupport {

	public List<Category> findAll() {
		return this.getHibernateTemplate().find("from Category");
	}

	public void save(Category category) {
		this.getHibernateTemplate().save(category);
	}

	public void delete(Category category) {
		category = this.getHibernateTemplate().get(Category.class,
				category.getCid());
		this.getHibernateTemplate().delete(category);
	}

	public Category findByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	public void update(Category category) {
		this.getHibernateTemplate().update(category);

	}

}
