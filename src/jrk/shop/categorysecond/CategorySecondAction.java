package jrk.shop.categorysecond;

import java.util.List;

import jrk.shop.category.Category;
import jrk.shop.category.CategoryService;
import jrk.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CategorySecondAction extends ActionSupport implements
		ModelDriven<CategorySecond> {
	private Integer cid;
	private Integer page;
	private CategorySecondService categorySecondService;
	private CategoryService categoryService;
	private CategorySecond categorySecond = new CategorySecond();

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Override
	public CategorySecond getModel() {
		return categorySecond;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public String adminFindAll() {
		PageBean<CategorySecond> pageBean = categorySecondService
				.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "adminFindAll_success";
	}

	public String addPage() {
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "addPage_success";
	}

	public String save() {
		Category category = new Category();
		category.setCid(cid);
		categorySecond.setCategory(category);
		categorySecondService.save(categorySecond);
		return "save_success";
	}

}
