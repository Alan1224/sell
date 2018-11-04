package com.imooc.sell.dto;

import lombok.Data;
import lombok.Getter;

/**
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 2018/11/4 11:06
 */
@Data
public class CartDTO {
    /**
     * 商品id
     */
    private String productId;
    /**
     * 数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
