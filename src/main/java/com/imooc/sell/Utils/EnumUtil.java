package com.imooc.sell.Utils;

import com.imooc.sell.enums.CodeEnum;

/**
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 11:39 2018/11/7
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){

        for (T each: enumClass.getEnumConstants()){
            if (each.getCode().equals(code))
            return each;
        }
        return null;
    }
}