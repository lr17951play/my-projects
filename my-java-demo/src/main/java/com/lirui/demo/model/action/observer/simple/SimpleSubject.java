package com.lirui.demo.model.action.observer.simple;

import java.util.ArrayList;
import java.util.List;

public class SimpleSubject implements Subject{

    List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notify(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
