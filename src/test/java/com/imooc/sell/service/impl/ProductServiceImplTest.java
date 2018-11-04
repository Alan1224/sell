package com.imooc.sell.service.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.imooc.sell.entity.ProductInfo;
import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 16:11 2018/11/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void findOne() {
        Assert.assertNotNull(productService.findOne("123456"));
    }

    @Test
    public void findUpAll() {
        Assert.assertNotNull(productService.findUpAll());
    }

    @Test
    public void findAll() {
        Page<ProductInfo> productInfos = productService.findAll(new PageRequest(0,2));
        Assert.assertNotNull(productInfos);
    }

    @Test
    public void save() {
        ProductInfo productInfo = productService.save(new ProductInfo("123456","皮蛋粥",new BigDecimal(10.0),1000,"很麻烦的虾","http://www.baidu.com",ProductStatusEnum.UP.getCode(),1));
        Assert.assertNotNull(productInfo);
    }
}