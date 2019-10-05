package com.qf.service;

import com.qf.domain.Cart;
import com.qf.domain.ShopCart;
import com.qf.response.QueryResponseResult;
import com.qf.response.QueryResult;
import com.qf.response.ResponseResult;

import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/21 19:17
 */
public interface ShopCartService {
    public ResponseResult addCart(Cart cart);

    public boolean queryByCondition(Cart cart);

    public ResponseResult updateCart(Cart cart);

    public QueryResponseResult findCart(Integer userId);

    public QueryResponseResult<ShopCart> findCartById(List<Integer> cartId);

    public ResponseResult updateNum(List<Cart> cart);

    public ResponseResult deleteCart(List<Integer> cartId);
}
