package com.imooc.sell.dao;

import com.imooc.sell.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void save(){
        ProductInfo productInfo = productInfoDao.save(new ProductInfo("123456","fistTest",new BigDecimal(1),0,"miaoshu","fistTest",1,1));
        Assert.assertNotNull(productInfo);
    }
    @Test
    public void findOne(){
        Assert.assertNotNull(productInfoDao.findById("123456").get());
    }
    @Test
    public void findByProductStatus() {
        Assert.assertNotNull(productInfoDao.findByProductStatus(1));
    }
}