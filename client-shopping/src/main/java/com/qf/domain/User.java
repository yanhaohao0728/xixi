package com.qf.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer userId;
    private String userName;
    private String userPhone;
    private String userPwd;
    private String userEmail;
    private String userAddress;
    private Integer userCode;
    private Integer userStart;
}
