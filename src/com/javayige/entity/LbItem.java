package com.javayige.entity;


import java.io.Serializable;

/**
 * @Author : orangeCy
 * @Time : 2022/8/20 16:01
 * @desc : 猎豹养成产品源码
 */
public class LbItem implements Serializable {
    private Long itemId;
    private String itemTitle;
    private Long itemBasicPrice;
    private Long itemMarketingPrice;
    private Integer itemStockNum;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public Long getItemBasicPrice() {
        return itemBasicPrice;
    }

    public void setItemBasicPrice(Long itemBasicPrice) {
        this.itemBasicPrice = itemBasicPrice;
    }

    public Long getItemMarketingPrice() {
        return itemMarketingPrice;
    }

    public void setItemMarketingPrice(Long itemMarketingPrice) {
        this.itemMarketingPrice = itemMarketingPrice;
    }

    public Integer getItemStockNum() {
        return itemStockNum;
    }

    public void setItemStockNum(Integer itemStockNum) {
        this.itemStockNum = itemStockNum;
    }
}