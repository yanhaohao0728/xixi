package com.qf.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/22 14:13
 */
@Data
public class Cart implements Serializable {
    private Integer cartId;
    private Integer proNum;
    private Integer userId;
    private Integer commodityId;

}
