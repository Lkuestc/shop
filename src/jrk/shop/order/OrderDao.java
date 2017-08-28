package jrk.shop.order;

import java.util.List;

import jrk.shop.user.User;
import jrk.shop.utils.PageHibernateCallback;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OrderDao extends HibernateDaoSupport {

	public Integer save(Order order) {
		return (Integer) this.getHibernateTemplate().save(order);
	}

	public Order findByOid(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	public void update(Order currOrder) {
		this.getHibernateTemplate().update(currOrder);

	}

	public List<Order> findByUid(User exitUser) {
		List<Order> list = this.getHibernateTemplate().find(
				"from Order o where o.user.uid = ? order by ordertime desc",
				exitUser.getUid());
		return list;
	}

	public Integer findCount() {
		List<Long> list = this.getHibernateTemplate().find(
				"select count(*) from Order");
		if (list != null && list.size() != 0) {
			return list.get(0).intValue();
		}
		return null;
	}

	public List<Order> findByPage(Integer begin, Integer limit) {
		List<Order> list = this.getHibernateTemplate().executeFind(
				new PageHibernateCallback<Order>(
						"from Order order by ordertime desc", null, begin,
						limit));
		if (list != null && list.size() != 0) {
			return list;

		}
		return null;
	}

	public Integer findCount(Integer state) {
		List<Long> list = this.getHibernateTemplate().find(
				"select count(*) from Order where state = ?", state);
		if (list != null && list.size() != 0) {
			return list.get(0).intValue();
		}
		return null;
	}

	public List<Order> findByPage(Integer state, Integer begin, Integer limit) {
		List<Order> list = this.getHibernateTemplate().executeFind(
				new PageHibernateCallback<Order>(
						"from Order where state = ? order by ordertime desc",
						new Object[] { state }, begin, limit));
		if (list != null && list.size() != 0) {
			return list;

		}
		return null;
	}

}
