package com.qf.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Orders  implements Serializable {
    private Integer orderId;
    private Double orderPrice;
    private String orderTime;
    private String orderOdd;
    private Integer orderStatus;
    private  String userName;
    private String userPhone;
    private String userAddress;
    private Integer userId;
    private OrderItems orderItems;
}
