package com.imooc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.sun.activation.registries.LogSupport.log;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LoggerTest.class)
@Slf4j
public class LoggerTest {

    String a="a";
    @Test
    public void test1(){
        log.debug("debug........{}",a);
        log.info("info.........");
        log.error("error........");
    }
}