package org.ssh.product.service;

import org.ssh.product.model.Cart;

import java.util.List;

public interface CartService {

    void addCartItem(Cart cart);

    List<Cart> cartItemList(int userid);

    void removeCartitem(Cart cart1);
}
