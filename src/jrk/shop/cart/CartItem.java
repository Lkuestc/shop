package jrk.shop.cart;

import jrk.shop.product.Product;

public class CartItem {
	// ��Ʒ��Ϣ
	private Product product;
	// ��Ʒ����
	private Integer count;
	// �۸�С��
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
