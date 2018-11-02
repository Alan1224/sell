package com.imooc.sell.service.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.imooc.sell.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    CategoryServiceImpl categoryService;
    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1) ,productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategories = categoryService.findAll();
        Assert.assertNotEquals(0,productCategories.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3));
        Assert.assertNotEquals(0,productCategories.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory =categoryService.save(new ProductCategory("serviceDemo1",7));
        Assert.assertNotNull(productCategory);

    }
}