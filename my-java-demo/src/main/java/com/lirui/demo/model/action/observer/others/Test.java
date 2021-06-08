package com.lirui.demo.model.action.observer.others;

import com.google.common.eventbus.EventBus;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.util.Observable;

public class Test {

    public static void main(String[] args) {

        //1. Observable
        Observable observable = new Observable();

        //2. ApplicationListener
        ApplicationListener listener = new ApplicationListener() {
            @Override
            public void onApplicationEvent(ApplicationEvent applicationEvent) {
                System.out.println(applicationEvent.getSource());
            }
        };

        //3. EventBus
        EventBus eventBus = new EventBus();
    }
}
