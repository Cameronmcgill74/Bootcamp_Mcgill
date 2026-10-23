package org.example;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book[] books = new Book[20];


        books[0] = new Book(1, "978-0000000001", "The Lost World");
        books[1] = new Book(2, "978-0000000002", "Ocean Adventures");
        books[2] = new Book(3, "978-0000000003", "Mystery at Midnight");
        books[3] = new Book(4, "978-0000000004", "Journey to the Stars");
        books[4] = new Book(5, "978-0000000005", "The Secret Garden");
        books[5] = new Book(6, "978-0000000006", "A Day in the Forest");
        books[6] = new Book(7, "978-0000000007", "The Hidden Treasure");
        books[7] = new Book(8, "978-0000000008", "Adventures in Space");
        books[8] = new Book(9, "978-0000000009", "The Magic Castle");
        books[9] = new Book(10, "978-0000000010", "Tales of the Wild");
        books[10] = new Book(11, "978-0000000011", "The Forgotten Island");
        books[11] = new Book(12, "978-0000000012", "Secrets of the Ocean");
        books[12] = new Book(13, "978-0000000013", "The Brave Explorer");
        books[13] = new Book(14, "978-0000000014", "A Winter Adventure");
        books[14] = new Book(15, "978-0000000015", "The Golden Key");
        books[15] = new Book(16, "978-0000000016", "Legends of the Kingdom");
        books[16] = new Book(17, "978-0000000017", "The Mysterious Forest");
        books[17] = new Book(18, "978-0000000018", "Dreams of Tomorrow");
        books[18] = new Book(19, "978-0000000019", "The Last Detective");
        books[19] = new Book(20, "978-0000000020", "Beyond the Mountains");

        while (true){
            System.out.println("Book Store Home Screen");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");

            int userInput = scanner.nextInt();

            switch (userInput){
                case 1:
                    for (int i = 0; i < books.length; i++) {
                        if (books[i].isCheckedout() == false) {
                            System.out.println(books[i].getId() + " " + books[i].getIsbn() + " " + books[i].getTitle());
                        }
                    }
                    System.out.println("Enter the ID of the book you want to check out:");
                    int bookId = scanner.nextInt();

                    for (int i = 0; i < books.length; i++) {
                        if (books[i].getId() == bookId) {
                            System.out.println("Enter your name:");
                            scanner.nextLine();
                            String name = scanner.nextLine();

                            books[i].checkOut(name);

                        }
                    }
                    break;

                case 2:
                    for (int i = 0; i < books.length; i++) {
                        if (books[i]. isCheckedout() == true) {
                            System.out.println(books[i].getId() + " " + books[i].getIsbn() + " " + books[i].getTitle() + " " + books[i].getCheckedOutTo());
                        }
                    }
                    System.out.println("C - check in a book");
                    System.out.println("X - Go back to home screen");
                    System.out.println("Enter your choice");

                    scanner.nextLine();
                    String choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("C")) {
                        System.out.println("Enter the Id of the book you want to check in");
                        int checkInId = scanner.nextInt();

                        for (int i = 0; i < books.length; i++){
                            if (books[i].getId() == checkInId) {
                                books[i].checkin();
                            }
                        }
                    }

                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    }