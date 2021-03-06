package com.imooc.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.sell.Utils.EnumUtil;
import com.imooc.sell.Utils.serializer.Date2LongSerializer;
import com.imooc.sell.entity.OrderDetail;
import com.imooc.sell.entity.OrderMaster;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 2018/11/3 20:21
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /**
     * 订单编号
     */
    private String orderId;
    /**
     *买家名字
     */
    private String buyerName;
    /**
     * 买家电话
     */
    private String buyerPhone;
    /**
     * 买家地址
     */
    private String buyerAddress;
    /**
     * 买家微信openid
     */
    private String buyerOpenid;
    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态, 默认为新下单0
     */
    private Integer orderStatus;
    /**
     * 订单支付状态
     */
    private Integer payStatus;
    /**
     * 订单创建时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**
     * 订单更新时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetailList;



    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}