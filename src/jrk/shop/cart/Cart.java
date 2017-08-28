package jrk.shop.cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	// ���ﳵ��map���ϴ洢���еĹ�����,ʹ����Ʒ��id��Ϊmap���ϵ�key����������Ϊvalue
	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();

	public Collection<CartItem> getCartItems() {
		return map.values();
	}

	// �ܼ�
	private Double total = 0d;

	public Double getTotal() {
		return total;
	}

	public void addCartIemt(CartItem cartItem) {
		Integer pid = cartItem.getProduct().getPid();
		if (map.containsKey(pid)) {
			// ���ﳵ�ڰ���Ҫ��ӵĹ�����
			CartItem oldCartItem = map.get(pid);
			oldCartItem.setCount(oldCartItem.getCount() + cartItem.getCount());
		} else {
			// ���ﳵ�ڲ�����Ҫ��ӵĹ�����
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
