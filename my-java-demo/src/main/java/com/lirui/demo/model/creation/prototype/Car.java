package com.lirui.demo.model.creation.prototype;

import lombok.Data;

import java.io.*;

/**
 * @author Ryan
 */
@Data
public class Car implements Serializable, Cloneable {

    private String brand;

    private String model;

    private Engine engine;

    private Wheel wheel;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Car deepClone() {
        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            //当前这个对象以对象流的方式输出
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            Car copyObj = (Car) ois.readObject();

            return copyObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            //关闭流
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }
    }
}
