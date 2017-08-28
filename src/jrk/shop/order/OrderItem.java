package jrk.shop.order;

import jrk.shop.product.Product;

/**
 * CREATE TABLE `orderitem` ( `itemid` INT(11) NOT NULL AUTO_INCREMENT, `count`
 * INT(11) DEFAULT NULL, `subtotal` DOUBLE DEFAULT NULL, `pid` INT(11) DEFAULT
 * NULL, `oid` INT(11) DEFAULT NULL, PRIMARY KEY (`itemid`), KEY
 * `FKE8B2AB6166C01961` (`oid`), KEY `FKE8B2AB6171DB7AE4` (`pid`), CONSTRAINT
 * `FKE8B2AB6166C01961` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`),
 * CONSTRAINT `FKE8B2AB6171DB7AE4` FOREIGN KEY (`pid`) REFERENCES `product`
 * (`pid`) ) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 * 
 * @author 梁恺
 * 
 */

public class OrderItem {
	private Integer itemid;
	private Integer count;
	private Double subtotal;
	// 订单项包含的商品信息
	private Product product;
	// 订单项所属的订单
	private Order order;

	public Integer getItemid() {
		return itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
