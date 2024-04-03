package org.experis.tris;

public class Board {
    private char[][] board = new char[3][3];
    private char currentPlayer = 'A';

    // Constructor
    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Getter

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    // Methods
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

    public void playerMove(String move) throws IllegalArgumentException{
        String[] coords = move.split("-");

        int coordX = Integer.parseInt(coords[0]) - 1;
        int coordY = Integer.parseInt(coords[1]) - 1;

        // Controllo delle coordinate
        if (coordX < 0 || coordX >= 3 || coordY < 0 || coordY >= 3) {
            throw new IllegalArgumentException("Invalid coordinates");
        }

        // Controllo se la posizione è già occupata
        if (board[coordX][coordY] != ' ') {
            throw new IllegalArgumentException("Position already occupied");
        }

        // Assegna la mossa al giocatore corrente
        board[coordX][coordY] = currentPlayer;

        // se non ha vinto nessuno, cambio il giocatore corrente
        if (!checkForWin()) switchCurrentPlayer();
    }

    public void switchCurrentPlayer(){
        currentPlayer = (currentPlayer == 'A') ? 'B' : 'A';
    }

    public boolean checkForWin(){
        for (int i = 0; i < 3; i++) {
            // Check righe
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }
            // Check colonne
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true;
            }
        }
        // Check diagonale (dall'alto a sinistra al basso a destra)
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true;
        }
        // Check diagonale (dall'alto a destra al basso a sinistra)
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return true;
        }

        return false;
    }

}
