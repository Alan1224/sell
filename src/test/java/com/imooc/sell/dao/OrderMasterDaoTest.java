package com.imooc.sell.dao;

import com.imooc.sell.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 2018/11/3 17:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {
    @Autowired
    private OrderMasterDao orderMasterDao;

    @Test
    public void save(){
        OrderMaster orderMaster = orderMasterDao.save(new OrderMaster("123457","superHappyPolaris","1777232232","甚至小区","alan1224",new BigDecimal(1.2),0,0));
        Assert.assertNotNull(orderMaster);
    }
    @Test
    public void findByBuyerOpenid() {

        Page<OrderMaster> orderMaster = orderMasterDao.findByBuyerOpenid("alan1224",new PageRequest(0,3));
        Assert.assertNotEquals(0,orderMaster.getTotalElements());
    }
}