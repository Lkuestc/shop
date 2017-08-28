package jrk.shop.product;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import jrk.shop.category.Category;
import jrk.shop.category.CategoryService;
import jrk.shop.categorysecond.CategorySecond;
import jrk.shop.categorysecond.CategorySecondService;
import jrk.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {
	private ProductService productService;
	private CategoryService categoryService;
	private CategorySecondService categorySecondService;
	private Integer cid;
	private Integer csid;
	private Integer page;
	private PageBean<Product> pageBean;
	private Product product = new Product();
	private File upload;
	private String uploadContentType;
	private String uploadFileName;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCid() {
		return cid;
	}

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public PageBean<Product> getPageBean() {
		return pageBean;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	@Override
	public Product getModel() {
		return product;
	}

	public String findByCid() {
		List<Category> categoryList = categoryService.findAll();
		ActionContext.getContext().getValueStack()
				.set("categoryList", categoryList);
		pageBean = productService.findByPage(cid, page);
		return "findByCid_success";
	}

	public String findByPid() {
		List<Category> categoryList = categoryService.findAll();
		ActionContext.getContext().getValueStack()
				.set("categoryList", categoryList);
		product = productService.findByPid(product.getPid());
		return "findByPid_success";
	}

	public String findByCsid() {
		List<Category> categoryList = categoryService.findAll();
		ActionContext.getContext().getValueStack()
				.set("categoryList", categoryList);
		pageBean = productService.findByCsid(csid, page);

		return "findByCsid_success";
	}

	public String adminFindAll() {
		pageBean = productService.findByPage(page);
		return "adminFindAll_success";
	}

	public String addPage() {
		List<CategorySecond> csList = categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "addPage_success";
	}

	public String save() throws IOException {
		String path = ServletActionContext.getServletContext().getRealPath(
				"/product");
		String realPath = path + "/" + csid + "/" + uploadFileName;
		File diskFile = new File(realPath);
		FileUtils.copyFile(upload, diskFile);
		product.setPdate(new Date());
		CategorySecond categorySecond = new CategorySecond();
		categorySecond.setCsid(csid);
		product.setCategorySecond(categorySecond);
		product.setImage("product/" + csid + "/" + uploadFileName);
		productService.save(product);

		return "save_success";
	}
}
