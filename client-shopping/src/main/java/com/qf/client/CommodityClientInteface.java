package com.qf.client;

import com.qf.domain.Commodity;
import com.qf.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/26 10:37
 */
@FeignClient(value = "spring-search-service",fallback = MessageServiceFallback.class)
public interface CommodityClientInteface {
    @PostMapping("/es/insertData")
    public ResponseResult insertData(@RequestBody List<Commodity> commodities);
}
