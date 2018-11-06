package com.imooc.sell.Utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * 可以运用到date类型上面的注解
 * Created by SuperHappyPolaris
 *
 * @Date:Create in 11:59 2018/11/5
 */
public class Date2LongSerializer extends JsonSerializer<Date> {

    //这个方法的作用是吧格式除以1000毫秒
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(date.getTime() / 1000);
    }
}
