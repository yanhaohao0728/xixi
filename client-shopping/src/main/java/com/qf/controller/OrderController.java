package com.qf.controller;

import com.qf.domain.Orders;
import com.qf.domain.ShopCart;
import com.qf.response.CommonCode;
import com.qf.response.QueryResponseResult;
import com.qf.response.QueryResult;
import com.qf.response.ResponseResult;
import com.qf.service.OrderItemsService;
import com.qf.service.OrdersService;
import com.qf.service.ShopCartService;
import com.qf.utils.OddUtils;
import com.qf.utils.TimeUtils;
import com.qf.vo.IntegerData;
import com.qf.vo.OrderData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/23 15:44
 */
@RestController
public class OrderController {
    @Autowired
    private OrderItemsService orderItemsService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ShopCartService shopCartService;
    @RequestMapping(value = "/addOrders", method = RequestMethod.POST)
    @ApiOperation(value = "生成订单", notes = "生成订单")
    public QueryResponseResult addOrders(@RequestBody OrderData data){
        Double orderPrice = data.getOrderPrice();
        String userName = data.getUserName();
        String userPhone = data.getUserPhone();
        String userAddress = data.getUserAddress();
        Integer userId = data.getUserId();
        Integer orderStatus = data.getOrderStatus();
        List<ShopCart> product = data.getProduct();
        String orderTime = TimeUtils.getOrderTime();
        String orderOdd = OddUtils.getOrderOdd();
        int result= ordersService.addOrders(orderPrice, orderTime, orderOdd,
                orderStatus, userName, userPhone, userAddress, userId);
        Orders byOrderOdd = ordersService.findByOrderOdd(orderOdd);
        List<Integer> ids = new ArrayList<>();
        for (ShopCart m:product){
            orderItemsService.addOrderItems(byOrderOdd.getOrderId(),m.getCommodity().getCommodityWeight(),m.getCommodity().getCommodityName(),
                    m.getCommodity().getCommodityPrice(),m.getCommodity().getCommodityCount(),m.getCommodity().getCommodityId());
            Integer cartId = m.getCartId();
            ids.add(cartId);
        }
         shopCartService.deleteCart(ids);
        QueryResult queryResult=new QueryResult();
        queryResult.setOrders(byOrderOdd);
        return new QueryResponseResult<>(CommonCode.SUCCESS, queryResult) ;
    }


    @RequestMapping(value = "/findByOrderOdd", method = RequestMethod.GET)
    @ApiOperation(value = "通过订单号查询订单", notes = "通过订单号查询订单")
    public QueryResponseResult findByOrderOdd (@RequestParam("orderOdd")String orderOdd){
        Orders byOrderOdd = ordersService.findByOrderOdd(orderOdd);
        QueryResult queryResult=new QueryResult();
        queryResult.setOrders(byOrderOdd);
        return  new QueryResponseResult<>(CommonCode.SUCCESS, queryResult);
    }



    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有订单", notes = "查询所有订单")
    public QueryResponseResult<Orders> findByUserId(@RequestParam("userId") Integer userId) {
        QueryResponseResult<Orders> byUserId = ordersService.findByUserId(userId);
        return byUserId;
    }

    @RequestMapping(value = "/deleteOrders", method = RequestMethod.POST)
    @ApiOperation(value = "删除订单", notes = "删除订单")
    public QueryResponseResult deleteOrders(@RequestParam("orderId") Integer orderId) {
        int i = orderItemsService.deleteDetail(orderId);
        QueryResponseResult queryResponseResult =null;
        if (i>0){
        queryResponseResult = ordersService.deleteOrders(orderId);
        }

        return queryResponseResult;
    }

    @RequestMapping(value = "/findByStatus", method = RequestMethod.POST)
    @ApiOperation(value = "查询不同状态的订单", notes = "查询不同状态的订单")
    public QueryResponseResult<Orders> findByStatus(@RequestParam("userId") Integer userId, @RequestParam("orderStatus")Integer orderStatus) {
        QueryResponseResult<Orders> byUserId = ordersService.findByStatus(userId, orderStatus);
        return byUserId;
    }

    @RequestMapping(value = "/findorderCountByUserId0", method = RequestMethod.POST)
    @ApiOperation(value = "查询订单数量", notes = "查询订单数量")
    public QueryResponseResult findorderCountByUserId0(@RequestParam("userId") Integer userId) {
        return ordersService.findorderCountByUserId0(userId);
    }

    @RequestMapping(value = "/findorderCountByUserId1", method = RequestMethod.POST)
    @ApiOperation(value = "查询订单数量", notes = "查询订单数量")
    public QueryResponseResult findorderCountByUserId1(@RequestParam("userId") Integer userId) {
        return ordersService.findorderCountByUserId1(userId);
    }

    @RequestMapping(value = "/updateOrderStatus", method = RequestMethod.POST)
    @ApiOperation(value = "修改订单状态", notes = "修改订单状态")
    public QueryResponseResult updateOrderStatus(@RequestParam("orderId") Integer orderId) {
        return ordersService.updateOrderStatus(orderId);
    }


}
