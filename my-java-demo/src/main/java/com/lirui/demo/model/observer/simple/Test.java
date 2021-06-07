package com.lirui.demo.model.observer.simple;

public class Test {

    public static void main(String[] args) {
        Subject subject = new SimpleSubject();
        Observer ob1 = new SimpleObserver("aaa");
        Observer ob2 = new SimpleObserver("bbb");

        subject.attach(ob1);
        subject.attach(ob2);

        subject.notify("Hello Message1");

        subject.remove(ob2);

        subject.notify("Hello Message2");
    }
}
