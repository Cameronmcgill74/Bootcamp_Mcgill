package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    public static void saveContract(Contract contract) {
        try (FileWriter writer = new FileWriter("contracts.csv", true)) {
            writer.write(contract.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving contracts: " + e.getMessage());
        }
    }
}
