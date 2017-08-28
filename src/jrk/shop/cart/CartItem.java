package jrk.shop.cart;

import jrk.shop.product.Product;

public class CartItem {
	// 商品信息
	private Product product;
	// 商品数量
	private Integer count;
	// 价格小计
	private Double subtotal;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return count * product.getShop_price();
	}

}
