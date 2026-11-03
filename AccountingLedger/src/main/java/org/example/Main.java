package org.example;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import  java.time.LocalDate;
import java.time.LocalTime;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = FileManager.getTransactions();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while(running) {
            System.out.println("\n=== ACCUNTTING LEDGER ===");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Enter Choice: ");

            String choice = scanner.nextLine();

            switch (choice.toUpperCase()) {
                case "D":
                    System.out.println("Enter description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter vendor: ");
                    String vendor = scanner.nextLine();

                    System.out.println("Enter amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());

                    LocalDate date = LocalDate.now();
                    LocalTime time = LocalTime.now();

                    Transaction transaction = new Transaction(date, time, description, vendor, amount);
                    transactions.add(transaction);
                    FileManager.saveTransaction(transaction);
                    break;
                case "P":
                    System.out.print("enter description: ");
                    String paymentDescription = scanner.nextLine();

                    System.out.print("enter vendor: ");
                    String paymentVendor = scanner.nextLine();

                    System.out.print("Enter amount: ");
                    double paymentAmount = Double.parseDouble(scanner.nextLine());

                    paymentAmount = -Math.abs(paymentAmount);

                    LocalDate paymentDate = LocalDate.now();
                    LocalTime paymentTime = LocalTime.now();

                    Transaction payment = new Transaction(
                            paymentDate, paymentTime,
                            paymentDescription, paymentVendor, paymentAmount
                    );
                    transactions.add(payment);
                    FileManager.saveTransaction(payment);

                    break;
                case "L":
                    System.out.println("=== TRANSACTION LEDGER ===");
                    for (Transaction item : transactions) {
                        System.out.println(
                                item.getDate() + "|" +
                                item.getTime() + "|" +
                                item.getDescription() + "|" +
                                item.getVendor() + "|$" +
                                item.getAmount()
                        );
                    }
                    break;
                case "X":
                    running = false;
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

    }
}