package com.qf.vo;

import com.qf.domain.Cart;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/22 15:17
 */
public class ObjectData {
    private List<Cart> cart = new ArrayList<>();

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }
}
