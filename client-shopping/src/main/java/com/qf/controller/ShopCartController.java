package com.qf.controller;

import com.qf.domain.Cart;
import com.qf.domain.ShopCart;
import com.qf.response.QueryResponseResult;
import com.qf.response.QueryResult;
import com.qf.response.ResponseResult;
import com.qf.service.ShopCartService;
import com.qf.utils.RedisUtils;
import com.qf.vo.IntegerData;
import com.qf.vo.ObjectData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/22 14:59
 */
@RestController
public class ShopCartController {
    @Autowired
    private ShopCartService shopCartService;


    @RequestMapping(value = "/addCart", method = RequestMethod.POST)
    @ApiOperation(value = "添加商品至购物车", notes = "添加商品至购物车")
    public ResponseResult addCart(@RequestBody Cart cart) {
        boolean flag = shopCartService.queryByCondition(cart);

        if (flag) {
            return shopCartService.addCart(cart);
        } else {
            return shopCartService.updateCart(cart);
        }
    }

    @RequestMapping(value = "/findCart", method = RequestMethod.GET)
    @ApiOperation(value = "查看购物车中所有商品", notes = "查看购物车中所有商品")
    public QueryResponseResult findCart(@RequestParam("userId") Integer userId) {
        return shopCartService.findCart(userId);
    }

    @RequestMapping(value = "/updateCart", method = RequestMethod.POST)
    @ApiOperation(value = "修改购物车中的商品数量", notes = "修改购物车中的商品数量")
    public ResponseResult updateCart(@RequestBody ObjectData data) {
        System.out.println(data.getCart());
        return shopCartService.updateNum(data.getCart());
    }

    @RequestMapping(value = "/deleteCart", method = RequestMethod.POST)
    @ApiOperation(value = "删除购物车中的商品", notes = "删除购物车中的商品")
    public ResponseResult deleteCart(@RequestBody IntegerData data) {
        return shopCartService.deleteCart(data.getIds());
    }

    @RequestMapping(value = "/findCartById", method = RequestMethod.POST)
    @ApiOperation(value = "结算购物车中选中的商品", notes = "结算购物车中选中的商品")
    public QueryResponseResult<ShopCart> findCartById(@RequestBody IntegerData data) {
        return shopCartService.findCartById(data.getIds());
    }
}
