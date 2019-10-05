package com.qf.service;

import com.qf.domain.OrderItems;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/23 15:38
 */
public interface OrderItemsService {
    public int addOrderItems(@Param("orderId") Integer orderId, @Param("commodityWeight") Double commodityWeight, @Param("commodityName") String commodityName, @Param("commodityPrice") Double commodityPrice,
                             @Param("commodityCount") Integer commodityCount, @Param("commodityId") Integer commodityId);

    public List<OrderItems> findById(@Param("orderId") Integer orderId);

    public int deleteDetail(@Param("orderId") Integer orderId);
}
