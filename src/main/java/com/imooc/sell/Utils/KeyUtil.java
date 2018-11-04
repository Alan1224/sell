package com.imooc.sell.Utils;

import java.util.Random;

/**
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 2018/11/4 10:36
 */
public class KeyUtil {
    /**
     * 生成唯一主键
     * synchronized 多线程相关，防止订单号重复
     * @return
     */
    public static synchronized String genUniqueKey(){

        //当前毫秒数，加上随机数
        Random random = new Random();

        return System.currentTimeMillis() + String.valueOf(random.nextInt(900000) + 100000);
    }
}
