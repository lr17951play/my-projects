package com.lirui.demo.model.creation.prototype;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ryan
 */
@Data
public class Engine implements Serializable, Cloneable {

    private String brand;

    private Integer type;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
