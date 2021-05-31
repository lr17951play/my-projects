package com.lirui.demo.model.factory;

public class ProductFactory<T> extends AbstractFactory<T> {

    private T product;

    @Override
    public T create(Class clazz) {
        try {
            product = (T) Class.forName(clazz.getName()).newInstance();
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
