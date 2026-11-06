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
        //Loads the saved transactions from the CSV file
        List<Transaction> transactions = FileManager.getTransactions();
        //ALlow the user to enter information
        Scanner scanner = new Scanner(System.in);
        //controls when the program stops running
        boolean running = true;
        //keeps the main menu running until the user exits
        while(running) {
            System.out.println("\n=== ACCUNTTING LEDGER ===");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Enter Choice: ");
            //Gets the user's menu choice
            String choice = scanner.nextLine();
            //runs the option selected by the user
            switch (choice.toUpperCase()) {
                //Allows the user to add a new deposit
                case "D":
                    System.out.println("Enter description: ");
                    // Stores the description entered by the user
                    String description = scanner.nextLine();

                    System.out.print("Enter vendor: ");
                    String vendor = scanner.nextLine();

                    System.out.println("Enter amount: ");
                    //Converts the entered amount into a decimal number
                    double amount = Double.parseDouble(scanner.nextLine());
                    //Gets the current date and time for the deposit
                    LocalDate date = LocalDate.now();
                    LocalTime time = LocalTime.now();
                    //Create a new transaction with the deposit information
                    Transaction transaction = new Transaction(date, time, description, vendor, amount);
                    //Adds the deposit to the transaction list
                    transactions.add(transaction);
                    //Saves the deposit to the CSV file
                    FileManager.saveTransaction(transaction);
                    break;
                case "P":
                    System.out.print("enter description: ");
                    String paymentDescription = scanner.nextLine();

                    System.out.print("enter vendor: ");
                    String paymentVendor = scanner.nextLine();

                    System.out.print("Enter amount: ");
                    double Amount = 0;
                    try {
                        Amount = Double.parseDouble(scanner.nextLine().replace(",",""));
                    }catch (NumberFormatException e) {
                        System.out.println("Invalid amount. Enter a number.");
                        break;
                    }

                    Amount = -Math.abs(Amount);

                    LocalDate paymentDate = LocalDate.now();
                    LocalTime paymentTime = LocalTime.now();

                    Transaction payment = new Transaction(
                            paymentDate, paymentTime,
                            paymentDescription, paymentVendor, Amount
                    );
                    transactions.add(payment);
                    FileManager.saveTransaction(payment);

                    break;
                    //opens the ledger menu
                case "L":
                    //Keeps track of whether the ledger menu is running
                    boolean ledgerRunning = true;
                    //keeps showing the ledger menu until the user goes bacl
                    while (ledgerRunning) {
                        System.out.println("\n=== LEDGER MENU ===");
                        System.out.println("A) All Transactions");
                        System.out.println("D) Deposits");
                        System.out.println("P) Payments");
                        System.out.println("R) Reports");
                        System.out.println("H) Home");
                        System.out.println("Enter Choice: ");
                        //Gets the user's choice and changes it to uppercase
                        String ledgerChoice = scanner.nextLine().toUpperCase();
                        //Runs the selected ledger option
                        switch (ledgerChoice) {
                            //
                            case "A":
                                System.out.println("=== All TRANSACTIONS ===");
                                //Loops through transaction foe newest to oldest
                                for (int i = transactions.size() - 1; i >= 0; i--) {
                                    //Gets the current transaction from list
                                    Transaction item = transactions.get(i);
                                    //Display the transaction dates, times, Description, vendor, and Amount
                                    System.out.println(
                                                     item.getDate() + "|" +
                                                    item.getTime() + "|" +
                                                    item.getDescription() + "|" +
                                                    item.getVendor() + "|$" +
                                                    item.getAmount()
                                    );
                                    }
                                break;
                                //Display only deposit transaction
                            case "D":
                                System.out.println("=== DEPOSITS ===");
                                    //Checks transaction from new to old
                                for (int i = transactions.size() - 1; i >=0; i--) {
                                    Transaction item = transactions.get(i);
                                    //Only display transaction with postive amount
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
                                //Display all payment transactions
                            case "P":
                                System.out.println("=== PAYMENT ===");
                                // loops through payment from new to old
                                for (int i = transactions.size() - 1; i >= 0; i--){
                                    Transaction item = transactions.get(i);
                                    //Only display transaction with a negtive amount
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
                            //Opens the report menu
                            case "R":
                                //Controls whether the report menu keeps running
                                boolean reportsRunning = true;
                                // Keeps displaying the report menu
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
                                    // runs what the used clicked
                                    String reportChoice = scanner.nextLine();

                                    switch (reportChoice) {
                                        case "1":
                                            System.out.println("=== MONTH TO DATE ===");
                                            // Gets date
                                            LocalDate today = LocalDate.now();
                                            // goes through each transacton in list
                                            for (Transaction item : transactions) {
                                                //check to see if transaction matches the current year, month
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
                                        //previus month ransaction
                                        case "2":
                                            System.out.println("=== Previous Month ===");

                                            LocalDate lastMonth = LocalDate.now().minusMonths(1);

                                            for (Transaction item : transactions) {
                                                // makes sure it matches last month and year transaction
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
                                        //current year transaction
                                        case "3":
                                            System.out.println("=== YEAR TO DATE ===");

                                            LocalDate currentDate = LocalDate.now();
                                            //goes through saved transactions
                                            for (Transaction item : transactions) {
                                                //&& both true conditions, ! excluding future date
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
                                            //Get last year by subtracting one from current year
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
                                            //Allow the user to seacrh transaction by vendor
                                        case "5":
                                            System.out.println("=== SEARCH BY Vendor ===");
                                            System.out.println("Enter Vendor name: ");
                                            //stores the vendor name entered by the user
                                            String seachvendor = scanner.nextLine();

                                            for (Transaction items : transactions) {
                                                //makes user the transaction vender matches search
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
                                        //Allows the user to searchmultiple filters
                                        case "6":
                                            System.out.print("=== CUSTOM SEARCH ===");
                                            System.out.print("Enter Start Date (YYYY-MM-DD)");
                                            //Stores the ending date for search
                                            String startDate = scanner.nextLine();
                                            System.out.print("Enter End Date (YYYY-MM-DD): ");
                                            String endDate = scanner.nextLine();
                                            System.out.print("Enter Description: ");
                                            String searchDescription = scanner.nextLine();
                                            System.out.print("Enter Vendor: ");
                                            String searchVendor = scanner.nextLine();
                                            System.out.print("Enter Amount: ");
                                            String searchAmount = scanner.nextLine();
                                            //checks each transaction agist the seacrh filter
                                            for (Transaction items : transactions) {
                                                //skips transaction before the start date
                                                if (!startDate.isEmpty() &&
                                                    items.getDate().isBefore(LocalDate.parse(startDate))) {
                                                    continue;
                                                }
                                                //skips transaction after the end date
                                                if (!endDate.isEmpty() &&
                                                        items.getDate().isAfter(LocalDate.parse(endDate))) {
                                                    continue;
                                                }
                                                //skips transaction that dont match the description
                                                if (!searchDescription.isEmpty() &&
                                                        !items.getDescription().equalsIgnoreCase(searchDescription)) {
                                                    continue;
                                                }
                                                //Skips transaction that donr match the vendor
                                                if (!searchVendor.isEmpty() &&
                                                        !items.getVendor().equalsIgnoreCase(searchVendor)) {
                                                    continue;
                                                }
                                                //skips transaction that dont match the amount
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
                                            // returns from the report menu to the ledger menu
                                        case "0":
                                            reportsRunning = false;
                                            break;
                                        default:
                                            System.out.println("Invalid choice.");
                                            break;
                                    }
                                }
                                break;
                                //returnes from the ledge menu to main menu
                            case "H":
                                ledgerRunning = false;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                    }
                    break;
                    //exit program
                case "X":
                    running = false;
                    System.out.println("Goodbye");
                    break;
                    // display an error message for invalid menu
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

    }
}