package org.experis.book;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scrivere un programma che chiede all’utente quanti libri vuole inserire e li inserisce in un array.
        Scanner scan = new Scanner(System.in);
        int size = 0;
        boolean isNumber = false;
        do {
            System.out.print("How many books do you want to enter: ");
            try{
                size = Integer.parseInt(scan.nextLine());
                isNumber = true;
            }catch (NumberFormatException e){
                System.out.println("-------------------------");
                System.out.println("Error: " + e.getMessage());
                System.out.println("-------------------------");

                isNumber = false;
            }
        }while(!isNumber || size < 0);

        Book[] books = new Book[size];

        // Chiede i dati di un libro (titolo, numero pagine, autore, editore), istanzia un nuovo oggetto della classe Book e lo inserisce nell’array. Lo fa per il numero di elementi previsti.
        for (int i = 0; i < size;) {
            System.out.println("Book #" + (i+1));
            System.out.print("Insert title: ");
            String title = scan.nextLine();

            int page = 0;
            do {
                System.out.print("Insert number of pages: ");
                try{
                    page = Integer.parseInt(scan.nextLine());
                    isNumber = true;
                } catch (NumberFormatException e) {
                    System.out.println("-------------------------");
                    System.out.println("Error: " + e.getMessage());
                    System.out.println("-------------------------");

                    isNumber = false;
                }
            }while (!isNumber);

            System.out.print("Insert author: ");
            String author = scan.nextLine();
            System.out.print("Insert publisher: ");
            String editor = scan.nextLine();

            // Gestire (o anticipare) eventuali errori in modo che il programma non vada in crash.
            try{
                Book book = new Book(title,page,author,editor);
                books[i] = book;
                i++;
            } catch (Exception e) {
                System.out.println("-------------------------");
                System.out.println("Error: " + e.getMessage());
                System.out.println("-------------------------");

            }
        }

        scan.close();

        for (int i = 0; i < size; i++) {
            System.out.println(books[i].toString());
        }

        // Al termine dell’inserimento scrivere tutti i dati dei libri in un file e in seguito rileggerli dal file e mostrarli a video.



    }
}
