package com.imooc.sell.entity;

import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 2018/11/3 11:30
 */
@Data
@Entity
@DynamicUpdate
public class OrderMaster {
    /**
     * 订单编号
     */
    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /**
     * 订单支付状态
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    /**
     * 订单创建时间
     */
    private Date createTime;

    /**
     * 订单更新时间
     */
    private Date updateTime;

    public OrderMaster() {
    }

    /**
     * 加这个注解数据库存储是自动过滤掉这个参数，防止报错
     * 但是不这样用，因为数据调用中会比较乱
     * 所以新建一共DTO类的对象
     */
//    @Transient
//    private List<OrderDetail> orderDetailList;

    public OrderMaster(String orderId, String buyerName, String buyerPhone, String buyerAddress, String buyerOpenid, BigDecimal orderAmount, Integer orderStatus, Integer payStatus) {
        this.orderId = orderId;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
        this.buyerAddress = buyerAddress;
        this.buyerOpenid = buyerOpenid;
        this.orderAmount = orderAmount;
        this.orderStatus = orderStatus;
        this.payStatus = payStatus;
    }
}