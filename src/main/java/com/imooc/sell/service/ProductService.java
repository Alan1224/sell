package com.imooc.sell.service;

import com.imooc.sell.dto.CartDTO;
import com.imooc.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    ProductInfo findOne(String productId);

    /**
     * 查询所有上架商品
     * @param
     * @return
     */
    List<ProductInfo> findUpAll();
    Page<ProductInfo> findAll(Pageable pageable);
    ProductInfo save(ProductInfo productInfo);
    /**
     * 加库存
     */
    void increaseStock(List<CartDTO> cartDTOList);
    /**
     * 减库存
     */
    void decreaseStock(List<CartDTO> cartDTOList);
    /**
     * 商品上架
     */
    ProductInfo onSale(String productId);
    /**
     * 商品下架
     */
    ProductInfo offSale(String productId);
}
