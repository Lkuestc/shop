package jrk.shop.product;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import jrk.shop.utils.PageBean;

@Transactional
public class ProductService {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public List<Product> findHot() {
		return productDao.findHot();
	}

	public List<Product> findNew() {
		return productDao.findNew();
	}

	public PageBean<Product> findByPage(Integer cid, Integer page) {
		int limit = 12;
		int totalPage = 0;
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		Integer totalCount = productDao.findCountByCid(cid);
		// System.out.println(totalCount);
		pageBean.setTotalCount(totalCount);
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPage(cid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}

	public PageBean<Product> findByCsid(Integer csid, Integer page) {
		int limit = 8;
		int totalPage = 0;
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		Integer totalCount = productDao.findCountByCsid(csid);
		pageBean.setTotalCount(totalCount);
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByCsidAndPage(csid, begin, limit);
		pageBean.setList(list);

		return pageBean;
	}

	public PageBean<Product> findByPage(Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		int limit = 10;
		pageBean.setLimit(limit);
		pageBean.setPage(page);
		Integer totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;

		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPage(begin, limit);
		pageBean.setList(list);

		return pageBean;
	}

	public void save(Product product) {
		productDao.save(product);
	}
}
