package com.imooc.sell.exception;

import com.imooc.sell.enums.ResultEnum;

/**
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 2018/11/3 22:09
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
