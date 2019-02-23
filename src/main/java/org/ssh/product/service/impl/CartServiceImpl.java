package org.ssh.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssh.product.dao.CartDao;
import org.ssh.product.model.Cart;
import org.ssh.product.service.CartService;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public void addCartItem(Cart cart) {
        cartDao.addCartItem(cart);
    }

    @Override
    public List<Cart> cartItemList(int userid) {
        return cartDao.cartItemList(userid);
    }

    @Override
    public void removeCartitem(Cart cart1) {
        cartDao.removeCartItem(cart1);
    }
}
