package com.imooc.sell.form;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 15:53 2018/11/9
 */
@Data
public class ProductForm {

    private String productId;
    /**
     * 商品名称
     *
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;
    /**
     * 描述
     */
    private String productDescription;
    /**
     * 小图
     */
    private String productIcon;
    /**
     * 类目编号
     */
    private Integer categoryType;
}
