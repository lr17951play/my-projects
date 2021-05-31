package com.lirui.demo.model.factory;

/**
 * simple factory
 * */
public class SimpletFactory<T> {

    private static Product product;

    public static Product create(Class clazz) {
        try {
            product = (Product) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }
}
