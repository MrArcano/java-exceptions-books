package org.experis.tris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Vogliamo realizzare il gioco del tris.
        // Si gioca da console.
        // Ci sono due giocatori e si gioca a turni. Ad ogni turno viene disegnata la griglia di gioco. Una versione molto semplice :

        // X 1 2 3
        // 1
        // 2
        // 3

        // Inizia il giocatore A scegliendo la giocata da fare indicando la riga e la colonna della griglia nella quale posizionare la sua pedina (es. 1-2 significa riga 1 colonna 2).

        // X 1 2 3
        // 1 A
        // 2
        // 3

        // A quel punto viene ridisegnata la griglia e si verifica se il giocatore ha vinto.
        // In caso contrario tocca al giocatore B e anche lui sceglie la sua giocata.

        // X 1 2 3
        // 1 A
        // 2   B
        // 3

        // Si continua così finchè tutte le caselle sono state occupate o finchè un giocatore ha vinto.

        Scanner scan = new Scanner(System.in);

        Board board = new Board();
        board.drawingBoard();
        boolean isValidMove;
        for (int i = 0; i < 9;) {
            do {
                System.out.print("Player " + board.getCurrentPlayer() +", enter your move in the format 'row-column' (for example, '1-2'): ");
                String move = scan.nextLine();
                try {
                    board.playerMove(move);
                    isValidMove = true;
                    i++;
                } catch (IllegalArgumentException e) {
                    System.out.println("-------------------------");
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("-------------------------");
                    isValidMove = false;
                }
                board.drawingBoard();
            }while(!isValidMove);

            // Check se qualcuno ha vinto
            if (board.checkForWin()) {
                break;
            }
        }

        if (board.checkForWin()) {
            System.out.println("Player " + board.getCurrentPlayer() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }

        scan.close();
    }
}
