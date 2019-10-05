package com.qf.client;

import com.qf.domain.Commodity;
import com.qf.response.CommonCode;
import com.qf.response.QueryResponseResult;
import com.qf.response.QueryResult;
import com.qf.response.ResponseResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/26 10:41
 */
@Component
public class MessageServiceFallback implements CommodityClientInteface{
    @Override
    public ResponseResult insertData(List<Commodity> commodities) {
        System.out.println("调用消息接口失败，对其进行降级处理！");
        QueryResult queryResult=new QueryResult();
        queryResult.setString("消息接口繁忙，请稍后重试！");
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }
}
