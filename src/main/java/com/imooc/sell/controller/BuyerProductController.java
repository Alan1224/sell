package com.imooc.sell.controller;

import com.imooc.sell.VO.ProductInfoVO;
import com.imooc.sell.VO.ProductVO;
import com.imooc.sell.VO.ResultVO;
import com.imooc.sell.entity.ProductCategory;
import com.imooc.sell.entity.ProductInfo;
import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 16:37 2018/11/2
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResultVO list(){
        //1、查询所有上架商品
        List<ProductInfo> productInfos = productService.findUpAll();
        //2、查询类目
        List<Integer> categoryTypes = productInfos.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> categories = categoryService.findByCategoryTypeIn(categoryTypes);
        //3、数据拼装
        List<ProductInfoVO> productInfoVOS = new ArrayList<>();
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory c :categories) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(c.getCategoryType());
            productVO.setCategoryName(c.getCategoryName());
            for (ProductInfo productInfo:productInfos) {
                if (c.getCategoryType().equals(productInfo.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOS.add(productInfoVO);
                }
            }
            productVO.setProductVOS(productInfoVOS);
            productVOList.add(productVO);
        }
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("success");
        resultVO.setData(productVOList);
        return resultVO;
    }
}
