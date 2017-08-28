package jrk.shop.index;

import java.util.List;

import jrk.shop.category.Category;
import jrk.shop.category.CategoryService;
import jrk.shop.product.Product;
import jrk.shop.product.ProductService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	private CategoryService categoryService;
	private ProductService productService;
	private List<Product> hotList;
	private List<Product> newList;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public List<Product> getHotList() {
		return hotList;
	}

	public List<Product> getNewList() {
		return newList;
	}

	
	@Override
	public String execute() throws Exception {
		// ��ѯһ������
		List<Category> categoryList = categoryService.findAll();
		// System.out.println(categoryList);
		ActionContext.getContext().getSession()
				.put("categoryList", categoryList);
		// ��ѯ������Ʒ
		hotList = productService.findHot();
		// ��ѯ������Ʒ
		newList = productService.findNew();
		return "index_success";
	}
}
