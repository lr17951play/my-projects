package com.lirui.demo.model.structure.flyweight;

import lombok.AllArgsConstructor;

/**
 * 具体享元角色
 * @author Ryan
 */
@AllArgsConstructor
public class GoPiece implements Piece{

    private String color;

    @Override
    public void move(int locationX, int locationY) {
        System.out.printf("[%s\t (%d, %d)]\t",this.color, locationX, locationY, this);
    }
}
