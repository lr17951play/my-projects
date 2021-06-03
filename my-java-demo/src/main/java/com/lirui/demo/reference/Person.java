package com.lirui.demo.reference;


import lombok.Data;

/**
 * @author Ryan
 */
@Data
public class Person {

    private Integer id;

    private String name;

    private String sex;

    public Person(Integer id) {
        this.id = id;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
