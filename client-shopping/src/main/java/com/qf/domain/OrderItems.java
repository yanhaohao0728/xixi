package com.qf.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/23 10:52
 */
@Data
public class OrderItems implements Serializable {
    private Integer id;
    private String commodityName;
    private Double commodityPrice;
    private Double commodityWeight;
    private Integer commodityCount;
    private Integer commodityId;
    private Integer orderId;
}
