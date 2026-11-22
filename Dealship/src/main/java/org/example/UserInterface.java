package org.example;
import jdk.swing.interop.SwingInterOpUtils;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.InputMismatchException;
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

        int choice = 0;
        do{
            System.out.println("\n==== DEALSHIP MENU ====");
            System.out.println("1. Find vehicles by price");
            System.out.println("2. Find vehicles by make/model");
            System.out.println("3. Find vehicles by year");
            System.out.println("4. Find vehicles by color");
            System.out.println("5. Find vehicles by mileage");
            System.out.println("6. Find vehicles by type");
            System.out.println("7. List all vehicles");
            System.out.println("8. add a vehicle");
            System.out.println("9. Remove a vehicle");
            System.out.println("10. sell a vehicle");
            System.out.println("11. Lease a vehicle");
            System.out.println("99. Exit");
            System.out.print("Enter your choice");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

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
                case 10:
                    processSellVehicleRequest();
                    break;
                case 11:
                    processLeaseVehicleRequest();
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
    private void processGetByPriceRequest () {
        try {
            System.out.print("Enter minimum price : ");
            BigDecimal min = scanner.nextBigDecimal();

            System.out.print("Enter maximum price: ");
            BigDecimal max = scanner.nextBigDecimal();
            scanner.nextLine();

            displayVehicles(dealership.getVehiclesByPrice(min, max));

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();

        }
    }
    private void processGetByMakeModelRequest() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }
    private void processGetByYearRequest () {
       try {
           System.out.print("Enter minumum year: ");
           int min = scanner.nextInt();

           System.out.print("Enter maximum year: ");
           int max = scanner.nextInt();
           scanner.nextLine();

           displayVehicles(dealership.getVehiclesByYear(min, max));
       }catch (InputMismatchException e){
               System.out.println("Invalid input. Please enter a number.");
               scanner.nextLine();
           }
    }
    private void processGetByColorRequest(){
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color));
    }
    private  void processGetByMileageRequest() {
       try {
           System.out.print("Enter minimum milege: ");
           int min = scanner.nextInt();

           System.out.print("Enter maximum mileage: ");
           int max = scanner.nextInt();
           scanner.nextLine();

           displayVehicles(dealership.getVehiclesByMileage(min, max));
       } catch (InputMismatchException e) {
           System.out.println("Invalid input. Please enter a number.");
           scanner.nextLine();
       }
    }
    private  void processGetByVehicleTypeRequest() {
       try {
           System.out.print("Enter vehicle type: ");
           String type = scanner.nextLine();

           displayVehicles(dealership.getVehiclesByType(type));
       }catch (InputMismatchException e) {
           System.out.println("Invalid input. Please enter a number.");
           scanner.nextLine();
           }
    }
    private  void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }
    private void processAddVehicleRequest() {
       try {
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
           Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);
           //Add the vehicle to the dealship inventory
           dealership.addVehicle(vehicle);

           DealershipFileManager fileManager = new DealershipFileManager();
           fileManager.saveDealership(dealership);

           System.out.println("Vehicle added succesfully! ");

       }catch (InputMismatchException e) {
           System.out.println("Invalid input. Please enter a number.");
           scanner.nextLine();
       }
    }
    private void processRemoveVehicleRequest() {
        // Ask the user which vehicle to remove
        try {
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
        }catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
    }
private void processSellVehicleRequest(){
    System.out.println("Enter the VIN of the vehicle to sell:");
    String vin = scanner.nextLine();
    Vehicle vehicle = dealership.getVehicleByVin(vin);

    if (vehicle == null) {
        System.out.println("Vehicle not found.");
        return;
    }
    System.out.println("Vehicle found");
    System.out.println(vehicle);
    System.out.println("Enter customer name:");
    String customerName = scanner.nextLine();
    System.out.println("Enter customer email:");
    String customerEmail = scanner.nextLine();
    System.out.println("Does the customer want financing? (yes/no):");
    String financeAnswer = scanner.nextLine();

    boolean financeOption = financeAnswer.equalsIgnoreCase("yes");
    SalesContract contract = new SalesContract(
            LocalDate.now().toString(),
            customerName,
            customerEmail,
            vehicle,
            0.0,
            0.0,
            0.0,
            financeOption
    );
    System.out.println(contract);
    ContractDataManager.saveContract(contract);
    //Removes the sold vehicle from inventory
    dealership.removeVehicle(vehicle);
    // saves the updated inventory
    DealershipFileManager fileManager = new DealershipFileManager();
    fileManager.saveDealership(dealership);

    System.out.println("Vehicle sold successfully!");
}
private void processLeaseVehicleRequest(){
    System.out.println("Enter the vin of the vehicle to lease:");
    String vin = scanner.nextLine();
    //Find the vehicle in inventory
    Vehicle vehicle = dealership.getVehicleByVin(vin);

    //Check if the vehicle exist
    if (vehicle == null) {
        System.out.println("Vehicle not found.");
        return;
    }
    System.out.println("vehicle found:");
    System.out.println(vehicle);

    int currentYear = LocalDate.now().getYear();
    int vehicleAge = currentYear - vehicle.getYear();

    if (vehicleAge > 3) {
        System.out.println("Vehicle is too old to lease");
        return;
    }
    System.out.println("Enter customer name:");
    String customerName = scanner.nextLine();

    System.out.println("Enter customer email:");
    String customerEmail = scanner.nextLine();
    //Calculate the leae values
    double vehiclePrice = vehicle.getPrice().doubleValue();
    double expectedEndingValue = vehiclePrice * 0.50;
    double leaseFee = vehiclePrice * 0.07;

    LeaseContract contract = new LeaseContract(
            LocalDate.now().toString(),
            customerName,
            customerEmail,
            vehicle,
            expectedEndingValue,
            leaseFee
    );
//display the lease contract
    System.out.println(contract);
    //save the lease contract
    ContractDataManager.saveContract(contract);
    //remove the leased vehicle from inventory
    dealership.removeVehicle(vehicle);
    //Save the updted inventory
    DealershipFileManager fileManager = new DealershipFileManager();
    fileManager.saveDealership(dealership);
// confirm lease
    System.out.println("Vehicle leased successfully!");
}
}
