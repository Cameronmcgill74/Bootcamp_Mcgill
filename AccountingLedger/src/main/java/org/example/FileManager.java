package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;

public class FileManager {
    public static List<Transaction> getTransactions(){
        List<Transaction> transactions = new ArrayList<>();

    try {
        FileReader fileReader = new FileReader("C:/Bootcamp/Bootcamp_Mcgill/AccountingLedger/src/main/resources/transactions.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split("\\|");
            LocalDate date = LocalDate.parse(parts[0]);
            LocalTime time = LocalTime.parse(parts[1]);
            String description = parts[2];
            String vendor = parts[3];
            double amount = Double.parseDouble(parts[4]);

            Transaction transaction = new Transaction(date, time, description, vendor, amount);
            transactions.add(transaction);
        }
    } catch (Exception Io) {
        System.out.println("Error reading files.");
    }
    return  transactions;
    }
public static void saveTransaction(Transaction transaction) {
        try {
            FileWriter fileWriter = new FileWriter(
                    "C:/Bootcamp/Bootcamp_Mcgill/AccountingLedger/src/main/resources/transactions.csv",
                    true
            );
            fileWriter.write(
                    transaction.getDate() + "|" +
                        transaction.getTime() + "|" +
                        transaction.getDescription() + "|" +
                        transaction.getVendor() + "|" +
                        transaction.getAmount() + "\n"
            );

            fileWriter.close();

        }catch (Exception Io) {
            System.out.println("Error saving transaction.");
        }
        }

}


