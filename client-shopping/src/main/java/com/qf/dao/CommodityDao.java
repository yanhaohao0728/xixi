package com.qf.dao;

import com.qf.domain.Commodity;
import com.qf.response.QueryResponseResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CommodityDao {
    List<Commodity> loadAllProduct(Integer page, Integer rows);
    List<Commodity> loadAllProductByPrice();
    Commodity findByProductId(Integer commodityId);
     int selectRows();//查询总行数；
}
