package com.imooc.sell.enums;

import lombok.Getter;
import org.aspectj.apache.bcel.classfile.Code;

/**
 * 商品状态
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 15:42 2018/11/2
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {
    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;

    private String massage;

    ProductStatusEnum(Integer code, String massage) {
        this.code = code;
        this.massage = massage;
    }
}
