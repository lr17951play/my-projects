package com.lirui.demo.model.structure.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 * @author Ryan
 */
public class PieceFactory {

    private Map<String, GoPiece> pieceMap = new HashMap<>();

    public GoPiece getPiece(String color){
        GoPiece piece = pieceMap.get(color);
        if (piece == null) {
            synchronized (this){
                piece = new GoPiece(color);
                pieceMap.put(color, piece);
            }
        }
        return piece;
    }
}
