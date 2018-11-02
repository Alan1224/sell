package com.imooc.sell.service;

import com.imooc.sell.entity.ProductCategory;

import java.util.List;

public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    /**
     * 根据类目类型查询
     * @param categoryType
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);

    ProductCategory save(ProductCategory productCategory);
}
