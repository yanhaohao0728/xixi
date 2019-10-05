package com.qf.vo;

import com.qf.domain.ShopCart;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2019/8/23 21:19
 */
public class OrderData {
    private Double orderPrice;
    private  String userName;
    private String userPhone;
    private String userAddress;
    private Integer userId;
    private Integer orderStatus;
    private List<ShopCart> product = new ArrayList<>();
    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }



    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<ShopCart> getProduct() {
        return product;
    }

    public void setProduct(List<ShopCart> product) {
        this.product = product;
    }


}
