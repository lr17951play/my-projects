package com.lirui.demo.model.creation.prototype;

import lombok.Data;

import java.io.Serializable;

@Data
public class Wheel implements Serializable {

    private String brand;

    private Integer model;

    private Double r;
}
