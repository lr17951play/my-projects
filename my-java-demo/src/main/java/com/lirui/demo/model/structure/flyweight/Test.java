package com.lirui.demo.model.structure.flyweight;

import java.util.HashSet;
import java.util.Set;

/**
 * 享元模式
 * @author Ryan
 */
public class Test {

    private static final String BLACK = "黑";

    private static final String WHITE = "白";

    public static void main(String[] args) {
        int[][] chessMap = new int[19][19];
        PieceFactory factory = new PieceFactory();
        Set<GoPiece> chessSet = new HashSet<>();

        for (int row = 0; row < chessMap.length; row ++) {
            for (int column = 0; column < chessMap[row].length; column ++) {
                GoPiece goPiece = factory.getPiece((column + row) % 2 == 1 ? BLACK : WHITE);
                goPiece.move(row, column);
                chessSet.add(goPiece);
            }
            System.out.println();
        }
        /** 未重复创建 GoPiece 实例 */
        for (GoPiece goPiece : chessSet) {
            System.out.println(goPiece);
        }
    }
}
