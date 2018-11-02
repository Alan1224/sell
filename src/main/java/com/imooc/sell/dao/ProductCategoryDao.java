package com.imooc.sell.dao;

import com.imooc.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 无法自动注入，需要把启动类放在这些类的上一级目录，否侧扫描会冲突。
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}