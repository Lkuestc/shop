package jrk.shop.user;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDao extends HibernateDaoSupport {

	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	public User findByCode(String code) {
		List<User> list = this.getHibernateTemplate().find(
				"from User where code = ?", code);
		if (list.size() != 0) {
			return list.get(0);
		}
		return null;
	}

	public void update(User exitUser) {
		this.getHibernateTemplate().update(exitUser);
	}

	public User login(User user) {
		List<User> list = this.getHibernateTemplate().find(
				"from User where userName = ? and password = ? and state = ?",
				user.getUserName(), user.getPassword(), 1);
		if (list.size() != 0) {
			return list.get(0);
		}
		return null;
	}

	public User findByUserName(String userName) {
		List<User> list = this.getHibernateTemplate().find(
				"from User where userName = ?", userName);
		if (list.size() != 0) {
			return list.get(0);
		}
		return null;
	}

}
