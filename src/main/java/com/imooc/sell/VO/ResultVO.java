package com.imooc.sell.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 16:46 2018/11/2
 */
@Data
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回具体内容
     */
    private T data;
}
