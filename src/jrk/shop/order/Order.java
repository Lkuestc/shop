package jrk.shop.order;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jrk.shop.user.User;

/**
 * CREATE TABLE `orders` ( `oid` INT(11) NOT NULL AUTO_INCREMENT, `total` DOUBLE
 * DEFAULT NULL, `ordertime` DATETIME DEFAULT NULL, `state` INT(11) DEFAULT
 * NULL, `addr` VARCHAR(50) DEFAULT NULL, `phone` VARCHAR(20) DEFAULT NULL,
 * `uid` INT(11) DEFAULT NULL, PRIMARY KEY (`oid`), KEY `FKC3DF62E5AA3D9C7`
 * (`uid`), CONSTRAINT `FKC3DF62E5AA3D9C7` FOREIGN KEY (`uid`) REFERENCES `user`
 * (`uid`) ) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 * 
 * @author 梁恺
 * 
 */

public class Order {
	private Integer oid;
	private Double total;
	private Date ordertime;
	private Integer state;
	private String addr;
	private String phone;
	private String name;
	// 订单的所属的用户
	private User user;
	// 放的是订单项的集合.
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
