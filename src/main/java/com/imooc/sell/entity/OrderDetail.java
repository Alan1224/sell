package com.imooc.sell.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 2018/11/3 12:19
 */
@Entity
@Data
public class OrderDetail {
    /**
     *
     */
    @Id
    private String detailId;
    private String orderId;
    private String productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品当前价格,单位分
     */
    private BigDecimal productPrice;
    /**
     * 商品数量
     */
    private Integer productQuantity;
    /**
     * 商品小图
     */
    private String productIcon;

    public OrderDetail() {
    }

    public OrderDetail(String detailId, String orderId, String productId, String productName, BigDecimal productPrice, Integer productQuantity, String productIcon) {
        this.detailId = detailId;
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productIcon = productIcon;
    }
    //    /**
//     * 商品创建时间
//     */
//    private Date createTime;
//    /**
//     * 修改时间
//     */
//    private Date updateTime;
}
