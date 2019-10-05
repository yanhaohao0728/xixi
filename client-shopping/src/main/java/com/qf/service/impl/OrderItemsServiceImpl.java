package com.qf.service.impl;

import com.qf.dao.OrderItemsDao;
import com.qf.domain.OrderItems;
import com.qf.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/23 15:40
 */
@Service
public class OrderItemsServiceImpl implements OrderItemsService {
    @Autowired
    private OrderItemsDao orderItemsDao;

    @Override
    public int addOrderItems(Integer orderId, Double commodityWeight, String commodityName, Double commodityPrice, Integer commodityCount, Integer commodityId) {
        return orderItemsDao.addOrderItems(orderId,commodityWeight,commodityName,commodityPrice,commodityCount,commodityId);
    }

    @Override
    public List<OrderItems> findById(Integer orderId) {
        return orderItemsDao.findById(orderId);
    }

    @Override
    public int deleteDetail(Integer orderId) {
        return orderItemsDao.deleteDetail(orderId);
    }
}
