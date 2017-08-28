package jrk.shop.cart;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import jrk.shop.product.Product;
import jrk.shop.product.ProductService;

import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport {
	private Integer pid;
	private Integer count = 0;
	private ProductService productService;

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	private Cart getCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		return cart;
	}

	public String addCart() {
		Product product = productService.findByPid(pid);
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		cartItem.setProduct(product);
		HttpServletRequest request = ServletActionContext.getRequest();
		Cart cart = getCart(request);
		cart.addCartIemt(cartItem);
		return "addCart_success";
	}

	public String clearCart() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Cart cart = getCart(request);
		cart.clearCart();
		return "clearCart_success";
	}

	public String removeCart() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Cart cart = getCart(request);
		cart.removeCartItem(pid);
		return "removeCart_success";
	}
	
	
	
	
	
	public String myCart(){
		return "myCart_success";
	}
}
