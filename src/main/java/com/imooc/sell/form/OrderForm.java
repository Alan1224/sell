package com.imooc.sell.form;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;

/**
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 2018/11/4 19:16
 */
@Data
public class OrderForm {
    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;
    /**
     * 买家电话
     */
    @NotEmpty(message = "手机号必填")
    private String phone;
    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;
    /**
     * 买家微信openId
     */
    @NotEmpty(message = "openId必填")
    private String openid;
    /**
     * 购物车
     */
    @NotEmpty(message = "购物车")
    private String items;
}
