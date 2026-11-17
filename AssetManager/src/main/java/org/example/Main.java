package org.example;
import java.math.BigDecimal;
import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Test 1: Check house value calculation
        House house = new House("Family Home", "2024-05-10", new BigDecimal("200000"), "123 main st", 1, 2000, 5000);
        System.out.println("House Value: $" + house.getValue());

        if (house.getValue().compareTo(new BigDecimal("361250")) == 0){
            System.out.println("House Test: Pass");
        } else {
            System.out.println("House Test: Fail");
        }
        // Test 2: Check vehicle depreciation
        Vehicle vehicle = new Vehicle("personal car", "2024-04-10", new BigDecimal("20000"), "toyota camry", 2020, 120000);
        System.out.println("Vehicle Value: $" + vehicle.getValue());
        if (vehicle.getValue().compareTo(new BigDecimal("15161.031820639997")) == 0) {
            System.out.println("Vehicle Test: PASS");
        } else {
            System.out.println("Vehicle Test: Fail");
        }
        // Test 3: Check mileage penalty
        Vehicle vehicle2 = new Vehicle("personal car", "2024-04-10", new BigDecimal("20000"), "ford mustang", 2020, 100001);
        System.out.println("Vehicle 2 value: $" + vehicle2.getValue());
        if (vehicle2.getValue().compareTo(new BigDecimal("15161.031820639997")) < 0) {
            System.out.println("Mileage Test : Pass");
        } else {
            System.out.println("Mileage Test: Fail");
        }
    }
}
