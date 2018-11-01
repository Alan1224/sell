package com.imooc.sell.dao;

import com.imooc.sell.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = productCategoryDao.findById(1).get();
        System.out.println(productCategory.toString());
    }
    @Test
    public void saveTest(){
        ProductCategory productCategory  = new ProductCategory();
        productCategory.setCategoryName("热销榜");
        productCategory.setCategoryType(2);
        productCategoryDao.save(productCategory);
    }
    @Test
    public void updateTest(){
        ProductCategory productCategory  = new ProductCategory();
        productCategory.setCategoryId(1);
        productCategory.setCategoryName("热销榜");
        productCategory.setCategoryType(2);
        productCategoryDao.save(productCategory);
    }
    @Test
    public void timeTest(){
        ProductCategory productCategory = productCategoryDao.findById(1).get();
        productCategory.setCategoryType(10);
        productCategoryDao.save(productCategory);
    }
}