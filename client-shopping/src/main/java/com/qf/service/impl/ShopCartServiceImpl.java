package com.qf.service.impl;

import com.qf.dao.CommodityDao;
import com.qf.dao.ShopCartDao;
import com.qf.domain.Cart;
import com.qf.domain.Commodity;
import com.qf.domain.ShopCart;
import com.qf.response.CommonCode;
import com.qf.response.QueryResponseResult;
import com.qf.response.QueryResult;
import com.qf.response.ResponseResult;
import com.qf.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/21 19:20
 */
@Service
public class ShopCartServiceImpl implements ShopCartService {
    @Autowired
    private ShopCartDao shopCartDao;
    @Autowired
    private CommodityDao commodityDao;
    @Override
    public ResponseResult addCart(Cart cart) {

        int result = shopCartDao.addCart(cart);

        if(result > 0) {
            return ResponseResult.SUCCESS();
        }else {
            return ResponseResult.FAIL();
        }
    }

    @Override
    public ResponseResult updateCart(Cart cart) {
        int result = shopCartDao.updateCart(cart);

        if(result > 0) {
            return ResponseResult.SUCCESS();
        }else {
            return ResponseResult.FAIL();
        }
    }

    @Override
    public QueryResponseResult findCart(Integer userId) {
        List<ShopCart> cart = shopCartDao.findCart(userId);
        Integer proNum =0;
        Double commodityPrice =null;
        Double v =null;
        List<Double> doubles=new ArrayList<>();
        for (ShopCart m:cart){
            proNum = m.getProNum();
            commodityPrice = m.getCommodity().getCommodityPrice();
           v = proNum * commodityPrice;
          doubles.add(v);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("cart",cart);
        map.put("doubles",doubles);
        QueryResult queryResult = new QueryResult<>();
        queryResult.setMap(map);
//        queryResult.setList(cart);
//        queryResult.setList(doubles);
        return new QueryResponseResult<>(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public QueryResponseResult<ShopCart> findCartById(List<Integer> cartId) {
        List<ShopCart> cart = new ArrayList<>();
        QueryResult<ShopCart> queryResult = new QueryResult<>();

        for(Integer t:cartId) {
            ShopCart cartById = shopCartDao.findCartById(t);
            cart.add(cartById);
        }
        queryResult.setList(cart);
        return new QueryResponseResult<>(CommonCode.SUCCESS, queryResult);
    }

    @Override
    public ResponseResult updateNum(List<Cart> cart) {
        int result = 0;

        for(Cart t:cart) {
            shopCartDao.updateNum(t.getCartId(), t.getProNum());
            result++;
        }

        if(result == cart.size()) {
            return ResponseResult.SUCCESS();
        }else {
            return ResponseResult.FAIL();
        }
    }

    @Override
    public ResponseResult deleteCart(List<Integer> cartId) {
        int result = 0;
        for(Integer t:cartId) {
            shopCartDao.deleteCart(t);
            result++;
        }

        if(result == cartId.size()) {
            return ResponseResult.SUCCESS();
        }else {
            return ResponseResult.FAIL();
        }
    }

    @Override
    public boolean queryByCondition(Cart cart) {
        ShopCart shopCart = shopCartDao.queryByCondition(cart);
        return shopCart==null?true:false;
    }
}
