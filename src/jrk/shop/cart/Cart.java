package jrk.shop.cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	// 购物车内map集合存储所有的购物项,使用商品的id作为map集合的key，购物项作为value
	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();

	public Collection<CartItem> getCartItems() {
		return map.values();
	}

	// 总计
	private Double total = 0d;

	public Double getTotal() {
		return total;
	}

	public void addCartIemt(CartItem cartItem) {
		Integer pid = cartItem.getProduct().getPid();
		if (map.containsKey(pid)) {
			// 购物车内包含要添加的购物项
			CartItem oldCartItem = map.get(pid);
			oldCartItem.setCount(oldCartItem.getCount() + cartItem.getCount());
		} else {
			// 购物车内不包含要添加的购物项
			map.put(pid, cartItem);
		}
		total += cartItem.getSubtotal();
	}

	public void removeCartItem(Integer pid) {
		CartItem removedCartItem = map.remove(pid);
		total -= removedCartItem.getSubtotal();
	}

	public void clearCart() {
		map.clear();
		total = 0d;
	}
}
