package org.example;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.List;

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
    }
    private void processGetByMakeModelRequest() {

    }
    private void processGetByYearRequest () {
    }
    private void processGetByColorRequest(){
    }
    private  void processGetByMileageRequest() {
    }
    private  void processGetByVehicleTypeRequest() {
    }
    private  void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }
    private void processAddVehicleRequest() {

    }
    private void processRemoveVehicleRequest() {
    }

}
