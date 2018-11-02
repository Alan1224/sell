package com.imooc.sell.service.impl;

import com.imooc.sell.dao.ProductCategoryDao;
import com.imooc.sell.entity.ProductCategory;
import com.imooc.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类目
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryDao categoryDao;
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return categoryDao.findById(categoryId).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType) {
        return categoryDao.findByCategoryTypeIn(categoryType);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return categoryDao.save(productCategory);
    }
}
