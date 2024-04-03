package org.experis.book;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scrivere un programma che chiede all’utente quanti libri vuole inserire e li inserisce in un array.
        Scanner scan = new Scanner(System.in);
        int size = 0;
        boolean isNumber = false;
        do {
            System.out.print("Quanti libri vuoi inserire: ");
            try{
                size = Integer.parseInt(scan.nextLine());
                isNumber = true;
            }catch (NumberFormatException e){
                isNumber = false;
            }
        }while(!isNumber);




        Book[] books = new Book[size];
        // Chiede i dati di un libro (titolo, numero pagine, autore, editore), istanzia un nuovo oggetto della classe Book e lo inserisce nell’array. Lo fa per il numero di elementi previsti.
        for (int i = 0; i < size; i++) {
            System.out.print("Inserisci titolo: ");
            String title = scan.nextLine();


            int page = 0;
            do {
                System.out.print("Inserisci numero pagine: ");
                try{
                    page = Integer.parseInt(scan.nextLine());
                    isNumber = true;
                } catch (NumberFormatException e) {
                    System.out.println("Error: " + e.getMessage());
                    isNumber = false;
                }
            }while (!isNumber);

            System.out.print("Inserisci autore: ");
            String author = scan.nextLine();
            System.out.print("Inserisci editore: ");
            String editor = scan.nextLine();

            // Gestire (o anticipare) eventuali errori in modo che il programma non vada in crash.
            try{
                Book book = new Book(title,page,author,editor);
                books[i] = book;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        scan.close();

        for (int i = 0; i < size; i++) {
            System.out.println(books[i].toString());
        }

        // Al termine dell’inserimento scrivere tutti i dati dei libri in un file e in seguito rileggerli dal file e mostrarli a video.



    }
}
