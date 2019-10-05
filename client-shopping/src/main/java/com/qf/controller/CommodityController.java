package com.qf.controller;

import com.qf.domain.Commodity;
import com.qf.response.QueryResponseResult;
import com.qf.response.QueryResult;
import com.qf.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/21 11:22
 */
@RestController
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @RequestMapping(value = "loadAllProduct",method = RequestMethod.GET)
    public QueryResult loadAllProduct(Model model, @RequestParam(required = false,defaultValue = "1")Integer page,
                                              @RequestParam(required = false,defaultValue = "8")Integer rows){
        int maxpage = commodityService.selectRows(rows);
        if (page<1){page=1;}
        if(page>maxpage){page=maxpage;}
        QueryResult queryResult=new QueryResult();
        List<Commodity> commodities = commodityService.loadAllProduct(page, rows);
        model.addAttribute("maxpage",maxpage);
        model.addAttribute("page",page);
        model.addAttribute("userList",commodities);
        queryResult.setList(commodities);
        queryResult.setPage(page);
        queryResult.setMaxpage(maxpage);
        return queryResult;
    }
    @RequestMapping(value = "loadAllProductByPrice",method = RequestMethod.GET)
    public QueryResult loadAllProductByPrice(Model model){
        QueryResult queryResult=new QueryResult();
        List<Commodity> commodities = commodityService.loadAllProductByPrice();
        model.addAttribute("commodities",commodities);
        queryResult.setList(commodities);
        return queryResult;
    }

    @RequestMapping(value = "findByProductId",method = RequestMethod.POST)
    public QueryResponseResult findByProductId(@RequestParam Integer commodityId){
        QueryResponseResult byProductId = commodityService.findByProductId(commodityId);
        return byProductId;
    }
}
