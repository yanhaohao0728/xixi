package com.qf.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Commodity implements Serializable {
    private Integer commodityId;
    private String commodityName;
    private Double commodityPrice;
    private String commodityBrand;
    private  Double commodityWeight;
    private String commodityStandard;
    private String commodityFirm;
    private String commodityApprovalNum;
    private String commodityPhotoOne;
    private String commodityPhotoTwo;
    private String commodityPhotoThere;
    private String commodityPhotoFour;
    private String commodityIntroduce;
    private String commodityType;
    private Integer commodityCount;
    private String commodityForm;
    private Integer catalogId;

}
