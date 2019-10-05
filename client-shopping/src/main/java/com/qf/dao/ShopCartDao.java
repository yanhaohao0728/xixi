package com.qf.dao;

import com.qf.domain.Cart;
import com.qf.domain.Commodity;
import com.qf.domain.ShopCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/21 10:50
 */
@Mapper
public interface ShopCartDao {
    // 添加商品至购物车
    public int addCart(Cart cart);

    // 修改购物车中该商品的数量
    public int updateCart(Cart cart);

    // 判断购物车中是否包含该商品
    public ShopCart queryByCondition(Cart cart);

    // 查看购物车
    public List<ShopCart> findCart(@Param("userId") Integer userId);

    // 根据cartId查询购物车
    public ShopCart findCartById(@Param("cartId") Integer cartId);

    // 修改购物车中商品数量
    public int updateNum(@Param("cartId") Integer cartId, @Param("proNum") Integer productNumber);

    // 删除购物车中的商品
    public int deleteCart(@Param("cartId") Integer cartId);
}
