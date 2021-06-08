package com.lirui.demo.model.action.observer.simple;

public interface Subject {

    void attach(Observer observer);

    void remove(Observer observer);

    void notify(String message);
}
