package com.lirui.demo.structure.linear;

/**
 * @author Ryan
 */
public class SparseArray {

    public static int width = 11;
    public static int height = 11;
    public static int steps = 10;

    public static void main(String[] args) {
        /**
         * 棋盘 width * height
         * 步数 steps
         * 空格: 0; 黑子: 1; 白子: 2
         * */
        int[][] chessBoard = new int[width][height];
        for (int i = 1; i <= steps; i ++) {
            int row = Math.toIntExact(Math.round(Math.random() * (width - 1)));
            int col = Math.toIntExact(Math.round(Math.random() * (height - 1)));
            int chess = 1 + (i % 2);
            chessBoard[row][col] = chess;
        }
        int[][] sparseArray = convertToSparseArray(chessBoard);
        int[][] recoveredBoard = recoverFromSparseArray(sparseArray);
        System.out.println("还原棋盘为：");
        for (int[] row : recoveredBoard) {
            for (int cell : row) {
                System.out.printf("%d\t", cell);
            }
            System.out.println();
        }
    }

    private static int[][] recoverFromSparseArray(int[][] sparseArray) {
        int[][] recoveredBoard = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int row = 1; row < sparseArray.length; row ++) {
            recoveredBoard[sparseArray[row][0]][sparseArray[row][1]] = sparseArray[row][2];
        }
        return recoveredBoard;
    }

    private static int[][] convertToSparseArray(int[][] chessBoard) {
        System.out.println("原始棋盘为：");
        int sum = 0;
        for (int[] row : chessBoard) {
            for (int cell : row) {
                System.out.printf("%d\t", cell);
                if (cell > 0) {
                    sum ++;
                }
            }
            System.out.println();
        }

        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = width;
        sparseArray[0][1] = height;
        sparseArray[0][2] = sum;
        int rowNum = 1;
        System.out.println("稀疏数组为：");
        System.out.printf("%d\t%d\t%d\t", sparseArray[0][0], sparseArray[0][1], sparseArray[0][2]);
        System.out.println();
        for (int row = 0; row < chessBoard.length; row ++) {
            for (int col = 0; col < chessBoard[row].length; col ++) {
                if (chessBoard[row][col] > 0) {
                    sparseArray[rowNum][0] = row;
                    sparseArray[rowNum][1] = col;
                    sparseArray[rowNum ++][2] = chessBoard[row][col];
                    System.out.printf("%d\t%d\t%d\t", row, col, chessBoard[row][col]);
                    System.out.println();
                }
            }
        }
        return sparseArray;
    }
}
