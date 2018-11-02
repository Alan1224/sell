package com.imooc.sell.dao;

import com.imooc.sell.entity.ProductCategory;
import net.bytebuddy.implementation.bytecode.collection.ArrayAccess;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test//JpaSystemException: No default constructor for entity;需要给这个类加无参构造方法
    public void findOneTest(){
        ProductCategory productCategory = productCategoryDao.findById(1).get();
        System.out.println(productCategory.toString());
    }
    @Test
    @Transactional//测试中完全回滚
    public void saveTest(){
        ProductCategory productCategory  = new ProductCategory("hot",5);
        ProductCategory result = productCategoryDao.save(productCategory);
        result.toString();
        Assert.assertNotNull(result);
    }
    @Test
    public void updateTest(){
        ProductCategory productCategory  = new ProductCategory("热销榜",10);
        productCategoryDao.save(productCategory);
    }
    @Test
    public void timeTest(){
        ProductCategory productCategory = productCategoryDao.findById(1).get();
        productCategory.setCategoryType(10);
        productCategoryDao.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> categoryTypes = Arrays.asList(1,2,3);
        List<ProductCategory> result = productCategoryDao.findByCategoryTypeIn(categoryTypes);
        Assert.assertNotEquals(0,result);
    }
}