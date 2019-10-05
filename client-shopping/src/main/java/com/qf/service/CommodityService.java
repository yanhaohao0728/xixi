package com.qf.service;

import com.qf.domain.Commodity;
import com.qf.response.QueryResponseResult;

import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/21 11:13
 */
public interface CommodityService {
    List<Commodity> loadAllProduct(Integer page, Integer rows);
    List<Commodity> loadAllProductByPrice();
    QueryResponseResult findByProductId(Integer commodityId);
    public int selectRows(Integer rows);//查询总行数
}
