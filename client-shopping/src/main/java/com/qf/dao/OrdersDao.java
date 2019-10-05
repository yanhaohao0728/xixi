package com.qf.dao;

import com.qf.domain.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/23 15:55
 */
@Mapper
public interface OrdersDao {
    int addOrders(@Param("orderPrice")Double orderPrice,@Param("orderTime")String orderTime,
                  @Param("orderOdd")String orderOdd,@Param("orderStatus")Integer orderStatus,
                  @Param("userName")String userName,@Param("userPhone")String userPhone,
                  @Param("userAddress") String userAddress,@Param("userId")Integer userId);
    Orders findByOrderOdd(@Param("orderOdd") String orderOdd);
    List<Orders> findByUserId(@Param("userId") Integer userId);
    List<Orders> findByStatus(@Param("userId") Integer userId,@Param("orderStatus") Integer orderStatus);
    int deleteOrders(@Param("orderId") Integer orderId);
    int findorderCountByUserId0(@Param("userId") Integer userId);
    int findorderCountByUserId1(@Param("userId") Integer userId);
    int  updateOrderStatus(@Param("orderId") Integer orderId);
}
