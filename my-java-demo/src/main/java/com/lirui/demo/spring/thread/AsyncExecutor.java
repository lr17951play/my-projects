package com.lirui.demo.spring.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AsyncExecutor {

    @Async()
    public void asyncOperate(Integer id){
        System.out.println(Thread.currentThread().getName() + "=====================" + id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
