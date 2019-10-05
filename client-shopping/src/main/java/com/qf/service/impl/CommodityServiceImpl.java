package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.client.CommodityClientInteface;
import com.qf.dao.CommodityDao;
import com.qf.domain.Commodity;
import com.qf.response.CommonCode;
import com.qf.response.QueryResponseResult;
import com.qf.response.QueryResult;
import com.qf.response.ResponseResult;
import com.qf.service.CommodityService;
import com.qf.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/21 11:14
 */
@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityDao commodityDao;
    @Autowired
    private CommodityClientInteface commodityClientInteface;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public List<Commodity> loadAllProduct(Integer page,Integer rows) {
            PageHelper.startPage(page,rows);
            List<Commodity> commodities  = commodityDao.loadAllProduct(page, rows);
            commodityClientInteface.insertData(commodities);
            return commodities;
//        List<Object> list = redisUtils.lGet("loadAllProduct"+page, 0, -1);
//        List<Commodity> commodities = null;
//        List<Commodity> commodityList=new ArrayList<>();
//        if (list==null||list.size()<=0) {
//            commodities = commodityDao.loadAllProduct(page,rows);
//            redisUtils.lSet("loadAllProduct"+page,commodities);
//        }
//        if (list!=null&&list.size()>0) {
//            for (Object a : list) {
//                commodityList = (List<Commodity>) a;
//            }
//            System.out.println("从redis中拿数据");
//            return commodityList;
//        }else {
//            return commodities;
//        }

    }

    @Override
    public List<Commodity> loadAllProductByPrice() {
        List<Object> list = redisUtils.lGet("loadAllProductByPrice", 0, -1);
        List<Commodity> commodities = null;
        List<Commodity> commodityList=new ArrayList<>();
        if (list==null||list.size()<=0) {
            commodities = commodityDao.loadAllProductByPrice();
            redisUtils.lSet("loadAllProductByPrice",commodities,86400);
        }
        if (list!=null&&list.size()>0) {
            for (Object a : list) {
                commodityList = (List<Commodity>) a;
            }
            System.out.println("从redis中拿数据");
            return commodityList;
        }else {
            return commodities;
        }
    }

    @Override
    public QueryResponseResult findByProductId(Integer commodityId) {
        Commodity byProductId = commodityDao.findByProductId(commodityId);
        QueryResult queryResult=new QueryResult();
        queryResult.setCommodity(byProductId);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }


    @Override
    //查询总行数
    public int selectRows(Integer rows) {
        int i = commodityDao.selectRows();
        return i%rows>0?i/rows+1:i/rows;
    }
}
