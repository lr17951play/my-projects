package com.lirui.demo.model.structure.decorator;

import lombok.Data;

/**
 * @author Ryan
 */
@Data
public abstract class Drink {

    protected String name;

    protected String desc;

    public abstract double cost();
}
