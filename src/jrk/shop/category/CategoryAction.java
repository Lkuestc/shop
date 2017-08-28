package jrk.shop.category;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CategoryAction extends ActionSupport implements
		ModelDriven<Category> {
	private Category category = new Category();
	private CategoryService categoryService;

	@Override
	public Category getModel() {
		return category;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public String adminFindAll() {
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "adminFindAll_success";
	}

	public String save() {
		categoryService.save(category);
		return "save_success";
	}

	public String delete() {
		categoryService.delete(category);
		return "delete_success";
	}

	public String edit() {
		category = categoryService.findByCid(category.getCid());
		return "edit_success";
	}
	public String update(){
		categoryService.update(category);
		return "update_success";
	}

}
