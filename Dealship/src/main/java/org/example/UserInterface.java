package org.example;
import jdk.swing.interop.SwingInterOpUtils;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.List;
import java.math.BigDecimal;
public class UserInterface {
    private Dealership dealership;

    private Scanner scanner = new Scanner(System.in);

    private  void init(){
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
    }
    public void display() {
        init();

        int choice;
        do{
            System.out.println("\n==== DEALSHIP MENU ====");
            System.out.println("1. Find vehicles by price");
            System.out.println("2. Find vehicles by make/model");
            System.out.println("3. Find vehicles by year");
            System.out.println("4. Find vehicles by color");
            System.out.println("5. Find vehicles by mileage");
            System.out.println("6. Find vehicles by type");
            System.out.println("7. List al vehicles");
            System.out.println("8. add a vehicle");
            System.out.println("9. Remove a vehicle");
            System.out.println("99. Exit");
            System.out.print("Enter your choice");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }while (choice != 99);
    }
    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
    private void processGetByPriceRequest (){
        System.out.print("Enter minimum price : ");
        BigDecimal min = scanner.nextBigDecimal();

        System.out.print("Enter maximum price: ");
        BigDecimal max = scanner.nextBigDecimal();

        scanner.nextLine();
        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }
    private void processGetByMakeModelRequest() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }
    private void processGetByYearRequest () {
        System.out.print("Enter minumum year: ");
        int min = scanner.nextInt();

        System.out.print("Enter maximum year: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        displayVehicles(dealership.getVehiclesByYear(min, max));
    }
    private void processGetByColorRequest(){
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color));
    }
    private  void processGetByMileageRequest() {
        System.out.print("Enter minimum milege: ");
        int min = scanner.nextInt();

        System.out.print("Enter maximum mileage: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }
    private  void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByType(type));
    }
    private  void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }
    private void processAddVehicleRequest() {
        System.out.print("Enter Vin: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter make");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter mileage: ");
        int mileage = scanner.nextInt();

        System.out.print("Enter price: ");
        BigDecimal price = scanner.nextBigDecimal();
        scanner.nextLine();
        // Create a new vehicle using the info entered
        Vehicle vehicle = new Vehicle(vin,year, make, model,type, color, mileage, price);
        //Add the vehicle to the dealship inventory
        dealership.addVehicle(vehicle);

        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);

        System.out.println("Vehicle added succesfully! ");
    }
    private void processRemoveVehicleRequest() {
            // Ask the user which vehicle to remove
        System.out.print("Enter VIN to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        //Search inventory for mathing vin
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                dealership.removeVehicle(vehicle);
                //Save the updated inventory to the file
                DealershipFileManager fileManager = new DealershipFileManager();
                fileManager.saveDealership(dealership);

                System.out.println("Vehicle removed sucessfully!");
                return;
            }
        }
        System.out.println("Vehicle not found");
    }

}
