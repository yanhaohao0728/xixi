package com.qf.service;

import com.qf.domain.Orders;
import com.qf.response.QueryResponseResult;

import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/23 16:09
 */
public interface OrdersService {
    int addOrders(Double orderPrice,String orderTime,String orderOdd,
                                  Integer orderStatus,String userName,String userPhone,
                                  String userAddress,Integer userId);
    Orders findByOrderOdd(String orderOdd);
    QueryResponseResult findByUserId(Integer userId);
    QueryResponseResult findByStatus(Integer userId,Integer orderStatus);
    QueryResponseResult deleteOrders(Integer orderId);
    QueryResponseResult findorderCountByUserId0(Integer userId);
    QueryResponseResult findorderCountByUserId1(Integer userId);
    QueryResponseResult  updateOrderStatus(Integer orderId);
}
