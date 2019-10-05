package com.qf.service.impl;

import com.qf.dao.OrderItemsDao;
import com.qf.dao.OrdersDao;
import com.qf.domain.OrderItems;
import com.qf.domain.Orders;
import com.qf.response.CommonCode;
import com.qf.response.QueryResponseResult;
import com.qf.response.QueryResult;
import com.qf.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/23 16:09
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private OrderItemsDao orderItemsDao;
    @Override
    public int addOrders(Double orderPrice,String orderTime,String orderOdd,
                                         Integer orderStatus,String userName,String userPhone,
                                         String userAddress,Integer userId) {
        int i = ordersDao.addOrders(orderPrice,orderTime,orderOdd,orderStatus,userName,userPhone,userAddress,userId);

        return i;
    }

    @Override
    public Orders findByOrderOdd(String orderOdd) {
        Orders byOrderOdd = ordersDao.findByOrderOdd(orderOdd);

        return byOrderOdd;
    }

    @Override
    public QueryResponseResult findByUserId(Integer userId) {
        List<Orders> byUserId = ordersDao.findByUserId(userId);
//        List<OrderItems> byId =null;
//        for (Orders y:byUserId){
//            Integer orderId = y.getOrderId();
//            byId = orderItemsDao.findById(orderId);
//        }
        QueryResult queryResult=new QueryResult();
        queryResult.setList(byUserId);
//        System.out.println(queryResult);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public QueryResponseResult findByStatus(Integer userId, Integer orderStatus) {
        List<Orders> byStatus = ordersDao.findByStatus(userId, orderStatus);
//        List<OrderItems> byId =null;
//        for (Orders m:byStatus){
//            Integer orderId = m.getOrderId();
//            byId = orderItemsDao.findById(orderId);
//        }
        QueryResult queryResult=new QueryResult();
        queryResult.setList(byStatus);
//        queryResult.setList(byId);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public QueryResponseResult deleteOrders(Integer orderId) {
        int i = ordersDao.deleteOrders(orderId);
        QueryResult queryResult=new QueryResult();
        queryResult.setAnInt(i);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public QueryResponseResult findorderCountByUserId0(Integer userId) {
        int i = ordersDao.findorderCountByUserId0(userId);
        QueryResult queryResult=new QueryResult();
        queryResult.setAnInt(i);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
    @Override
    public QueryResponseResult findorderCountByUserId1(Integer userId) {
        int i = ordersDao.findorderCountByUserId1(userId);
        QueryResult queryResult=new QueryResult();
        System.out.println(queryResult);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
    @Override
    public QueryResponseResult updateOrderStatus(Integer orderId) {
        int i = ordersDao.updateOrderStatus(orderId);
        QueryResult queryResult=new QueryResult();
        queryResult.setAnInt(i);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}
