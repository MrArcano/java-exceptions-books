package org.experis.tris;

public class Board {
    private char[][] board = new char[3][3];

    public void drawingBoard(){
        System.out.println("X 1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
