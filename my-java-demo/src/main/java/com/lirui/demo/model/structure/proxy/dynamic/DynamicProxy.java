package com.lirui.demo.model.structure.proxy.dynamic;

import org.springframework.util.CollectionUtils;

import java.lang.reflect.Proxy;

public class DynamicProxy {

    private Object target;

    public DynamicProxy(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        Class<?>[] interfaces = target.getClass().getInterfaces().length == 0 ?
                target.getClass().getSuperclass().getInterfaces() : target.getClass().getInterfaces();
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), interfaces,
                (proxy, method, args) -> {
                    System.out.println("动态代理开始前置检查");
                    Object result = method.invoke(target, args);
                    System.out.println("动态代理开始后置行为");
                    return result;
                });
    }
}
