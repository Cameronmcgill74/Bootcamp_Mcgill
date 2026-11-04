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
                    boolean ledgerRunning = true;

                    while (ledgerRunning) {
                        System.out.println("\n=== LEDGER MENU ===");
                        System.out.println("A) All Transactions");
                        System.out.println("D) Deposits");
                        System.out.println("P) Payments");
                        System.out.println("R) Reports");
                        System.out.println("H) Home");
                        System.out.println("Enter Choice: ");

                        String ledgerChoice = scanner.nextLine().toUpperCase();

                        switch (ledgerChoice) {
                            case "A":
                                System.out.println("=== All TRANSACTIONS ===");
                                for (int i = transactions.size() - 1; i >= 0; i--) {
                                    Transaction item = transactions.get(i);

                                    System.out.println(
                                                     item.getDate() + "|" +
                                                    item.getTime() + "|" +
                                                    item.getDescription() + "|" +
                                                    item.getVendor() + "|$" +
                                                    item.getAmount()
                                    );
                                    }
                                break;

                            case "D":
                                System.out.println("=== DEPOSITS ===");

                                for (int i = transactions.size() - 1; i >=0; i--) {
                                    Transaction item = transactions.get(i);

                                if (item.getAmount() > 0) {
                                    System.out.println(
                                            item.getDate() + "|" +
                                            item.getTime() + "|" +
                                            item.getDescription() + "|" +
                                            item.getVendor() + "|" +
                                            item.getAmount()
                                    );

                                }
                                }
                                break;

                            case "P":
                                System.out.println("=== PAYMENT ===");

                                for (int i = transactions.size() - 1; i >= 0; i--){
                                    Transaction item = transactions.get(i);

                                    if (item.getAmount() < 0) {
                                        System.out.println(
                                                item.getDate() + "|" +
                                                item.getTime() + "|" +
                                                item.getDescription() + "|" +
                                                item.getVendor() + "|$" +
                                                item.getAmount()

                                        );

                                    }
                                }
                       break;

                            case "R":
                                boolean reportsRunning = true;

                                while (reportsRunning) {
                                    System.out.println("\n=== Reports Menu ===");
                                    System.out.println("1) Month to Date");
                                    System.out.println("2) Previous Month");
                                    System.out.println("3) Year to date");
                                    System.out.println("4) Previous Year");
                                    System.out.println("5) Search by vender");
                                    System.out.println("6) Custom Search");
                                    System.out.println("0) Back to Ledger");
                                    System.out.println("Enter choice: ");

                                    String reportChoice = scanner.nextLine();

                                    switch (reportChoice) {
                                        case "1":
                                            System.out.println("=== MONTH TO DATE ===");

                                            LocalDate today = LocalDate.now();

                                            for (Transaction item : transactions) {
                                                if (item.getDate().getMonthValue() == today.getMonthValue()
                                                && item.getDate().getYear() == today.getYear()){

                                                    System.out.println(
                                                            item.getDate() + "|" +
                                                            item.getTime() + "|" +
                                                            item.getDescription() + "|" +
                                                            item.getVendor() + "$" +
                                                            item.getAmount()
                                                    );
                                                }
                                            }
                                            break;

                                        case "2":
                                            System.out.println("=== Previous Month ===");

                                            LocalDate lastMonth = LocalDate.now().minusMonths(1);

                                            for (Transaction item : transactions) {
                                                if (item.getDate().getMonthValue() == lastMonth.getMonthValue()
                                                && item.getDate().getYear() == lastMonth.getYear()) {

                                                    System.out.println(
                                                            item.getDate() + "|" +
                                                            item.getTime() + "|" +
                                                            item.getDescription() + "|" +
                                                            item.getVendor() + "|$" +
                                                            item.getAmount()
                                                    );
                                                }

                                            }
                                            break;

                                        case "3":
                                            System.out.println("=== YEAR TO DATE ===");

                                            LocalDate currentDate = LocalDate.now();

                                            for (Transaction item : transactions) {
                                                if (item.getDate().getYear() == currentDate.getYear()
                                                && !item.getDate().isAfter(currentDate)){

                                                    System.out.println(
                                                            item.getDate() + "|" +
                                                                    item.getTime() + "|" +
                                                                    item.getDescription() + "|" +
                                                                    item.getVendor() + "|$" +
                                                                    item.getAmount()
                                                    );
                                                }
                                                }
                                            break;
                                        case "4":
                                            System.out.println("=== PREVIOUS YEAR ===");

                                            int previousYear = LocalDate.now().getYear() - 1;

                                            for (Transaction items : transactions) {
                                                if (items.getDate().getYear() == previousYear) {

                                                    System.out.println(
                                                            items.getDate() + "|" +
                                                            items.getTime() + "|" +
                                                            items.getDescription() + "|" +
                                                            items.getVendor() + "|$" +
                                                            items.getAmount()
                                                    );
                                                }
                                            }


                                            break;
                                        case "5":
                                            System.out.println("=== SEARCH BY Vendor ===");
                                            System.out.println("Enter Vendor name: ");
                                            String seachvendor = scanner.nextLine();

                                            for (Transaction items : transactions) {
                                                if (items.getVendor().equalsIgnoreCase(seachvendor)){

                                                    System.out.println(
                                                            items.getDate() + "|" +
                                                            items.getTime() + "|" +
                                                            items.getDescription() + "|" +
                                                            items.getVendor() + "|$" +
                                                            items.getAmount()
                                                    );

                                                }
                                            }
                                            break;

                                        case "6":
                                            System.out.print("=== CUSTOM SEARCH ===");
                                            System.out.print("Enter Start Date (YYYY-MM-DD");
                                            String startDate = scanner.nextLine();
                                            System.out.print("Enter End Date (YYYY-MM-DD): ");
                                            String endDate = scanner.nextLine();
                                            System.out.print("Enter Description: ");
                                            String searchDescription = scanner.nextLine();
                                            System.out.print("Enter Vendor: ");
                                            String searchVendor = scanner.nextLine();
                                            System.out.print("Enter Amount: ");
                                            String searchAmount = scanner.nextLine();
                                            for (Transaction items : transactions) {
                                                if (!startDate.isEmpty() &&
                                                    items.getDate().isBefore(LocalDate.parse(startDate))) {
                                                    continue;
                                                }
                                                if (!endDate.isEmpty() &&
                                                        items.getDate().isAfter(LocalDate.parse(endDate))) {
                                                    continue;
                                                }
                                                if (!searchDescription.isEmpty() &&
                                                        !items.getDescription().equalsIgnoreCase(searchDescription)) {
                                                    continue;
                                                }
                                                if (!searchVendor.isEmpty() &&
                                                        !items.getVendor().equalsIgnoreCase(searchVendor)) {
                                                    continue;
                                                }
                                                if (!searchAmount.isEmpty() &&
                                                        items.getAmount() !=Double.parseDouble(searchAmount)) {
                                                    continue;
                                                }
                                                System.out.println(
                                                        items.getDate() + "|" +
                                                        items.getTime() + "|" +
                                                        items.getDescription() + "|" +
                                                        items.getVendor() + "|$" +
                                                        items.getAmount()
                                                );

                                            }
                                            break;
                                        case "0":
                                            reportsRunning = false;
                                            break;
                                        default:
                                            System.out.println("Invalid choice.");
                                            break;
                                    }
                                }
                                break;
                            case "H":
                                ledgerRunning = false;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
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