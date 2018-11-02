package com.imooc.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目表
 */
@Entity
@DynamicUpdate//动态更新
@Data//lombok的功能，不需要写getset方法
public class ProductCategory {
    /**
     * 类目Id
     */
    @Id
    @GeneratedValue
    private Integer categoryId;
    /**
     * 类目名称
     */
    private String categoryName;
    /**
     * 类目类型
     */
    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
//    /**
//     * 创建时间
//     * @return
//     */
//    private Date createTime;
//
//    /**
//     * 更新时间
//     * @return
//     */
//    private Date updateTime;

}