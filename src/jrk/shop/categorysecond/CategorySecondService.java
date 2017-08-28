package jrk.shop.categorysecond;

import java.util.List;

import jrk.shop.utils.PageBean;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CategorySecondService {
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	public PageBean<CategorySecond> findByPage(Integer page) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		pageBean.setPage(page);
		Integer limit = 10;
		pageBean.setLimit(limit);
		Integer totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		Integer totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		Integer begin = (page - 1) * limit;
		List<CategorySecond> list = categorySecondDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
	}

	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}
}
