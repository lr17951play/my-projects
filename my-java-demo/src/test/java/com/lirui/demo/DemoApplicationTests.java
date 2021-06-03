package com.lirui.demo;

import com.lirui.demo.spring.thread.AsyncExecutor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    AsyncExecutor asyncExecutor;

    @Test
    void contextLoads() {
    }

    @SneakyThrows
    @Test
    void testThread(){
        long time = System.currentTimeMillis();
        System.out.println("task started!");
        for (int i = 0; i < 100; i++) {
            asyncExecutor.asyncOperate(i);
        }
        Thread.sleep(30000);
        System.out.println("task done!");
    }

}
