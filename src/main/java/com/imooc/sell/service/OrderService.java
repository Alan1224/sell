package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 2018/11/3 20:14
 */
public interface OrderService {
    /**
     * 创建订单
     */
    OrderDTO create(OrderDTO orderDTO);
    /**
     * 查询单个订单
     */
    OrderDTO findOne(String orderId);
    /**
     * 查询订单列表
     */
    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);
    /**
     * 取消订单
     */
    OrderDTO cancel(OrderDTO orderDTO);
    /**
     * 完结订单
     */
    OrderDTO finish(OrderDTO orderDTO);
    /**
     * 支付订单
     */
    OrderDTO paid(OrderDTO orderDTO);
}