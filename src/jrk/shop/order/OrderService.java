package jrk.shop.order;

import java.util.List;

import jrk.shop.user.User;
import jrk.shop.utils.PageBean;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class OrderService {
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public Integer save(Order order) {
		return orderDao.save(order);
	}

	public Order findByOid(Integer oid) {
		return orderDao.findByOid(oid);
	}

	public void update(Order currOrder) {
		orderDao.update(currOrder);
	}

	public List<Order> findByUid(User exitUser) {

		return orderDao.findByUid(exitUser);
	}

	public PageBean<Order> findByPage(Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		pageBean.setPage(page);
		Integer limit = 10;
		pageBean.setLimit(limit);
		Integer totalCount = orderDao.findCount();
		pageBean.setTotalCount(totalCount);
		Integer totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;

		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		Integer begin =(page -1)*limit;
		List<Order> list = orderDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	public PageBean<Order> findByPage(Integer page, Integer state) {
		PageBean<Order> pageBean = new PageBean<Order>();
		pageBean.setPage(page);
		Integer limit = 10;
		pageBean.setLimit(limit);
		Integer totalCount = orderDao.findCount(state);
		pageBean.setTotalCount(totalCount);
		Integer totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;

		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		Integer begin =(page -1)*limit;
		List<Order> list = orderDao.findByPage(state,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

}
