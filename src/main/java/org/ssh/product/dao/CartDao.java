package org.ssh.product.dao;

import org.ssh.product.model.Cart;

import java.util.List;

public interface CartDao {
    void addCartItem(Cart cart);

    List<Cart> cartItemList(int userid);

    void removeCartItem(Cart cart1);
}
