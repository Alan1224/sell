package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;

import java.util.List;

/**
 * 卖家
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 14:07 2018/11/5
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);
    //取消订单
    OrderDTO cancerOrder(String openid,String orderId);
}
