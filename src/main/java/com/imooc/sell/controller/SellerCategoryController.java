package com.imooc.sell.controller;

import com.imooc.sell.entity.ProductCategory;
import com.imooc.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 17:23 2018/11/9
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ModelAndView list(Map<String ,Object> map){
        map.put("categoryList",categoryService.findAll());
        return new ModelAndView("category/list",map);
    }

    public ModelAndView update(@RequestParam(value = "categoryId",required= false)Integer categoryId, Map<String ,Object> map){
        if (categoryId > 0 ){
            ProductCategory productCategory = categoryService.findOne(categoryId);
            map.put("category",productCategory);
        }
        return new ModelAndView("category/update",map);
    }
}