package com.imooc.sell.dao;

import com.imooc.sell.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 2018/11/3 19:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;
    @Test
    public void save(){
        OrderDetail orderDetail = orderDetailDao.save(new OrderDetail("123457","123456","123456","alan1224",new BigDecimal(1.2),2,"http://www.baidu.com"));
        Assert.assertNotNull(orderDetail);
    }
    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetails =orderDetailDao.findByOrderId("123456");
        Assert.assertNotEquals(0,orderDetails.size());
    }
}