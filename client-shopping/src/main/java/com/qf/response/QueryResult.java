package com.qf.response;

//import com.qf.domain.User;
import com.qf.domain.Commodity;
import com.qf.domain.Orders;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;


@Data
@ToString
public class QueryResult<T> {
    //数据列表
    private List<T> list;
    //数据总数
    private long total;
//    private User user;
    private int anInt;
    private Double aDouble;
    private Commodity commodity;
    private Integer page;
    private Integer maxpage;
    private Orders orders;
    private String string;
    private Map map;
}
