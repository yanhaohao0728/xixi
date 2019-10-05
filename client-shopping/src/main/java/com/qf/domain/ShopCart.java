package com.qf.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/20 21:06
 */
@Data
public class ShopCart implements Serializable {
    private Integer cartId;
    private Integer userId;
    private Integer proNum;
    private Commodity commodity;
}
