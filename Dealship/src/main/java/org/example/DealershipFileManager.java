package org.example;
import java.io.*;
import java.math.BigDecimal;

public class DealershipFileManager {
    public Dealership getDealership() {
        Dealership dealership = null;
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("src/main/inventory.csv"));
            String line = reader.readLine();
            String[] parts =  line.split("\\|");
            dealership = new Dealership(parts[0], parts[1], parts[2]);
            while ((line = reader.readLine()) != null) {
                String[] vehicleParts = line.split("\\|");

                int vin = Integer.parseInt(vehicleParts[0]);
                int year = Integer.parseInt(vehicleParts[1]);
                String make = vehicleParts[2];
                String model = vehicleParts[3];
                String vehicleType = vehicleParts[4];
                String color = vehicleParts[5];
                int odometer = Integer.parseInt(vehicleParts[6]);
                BigDecimal price = new BigDecimal(vehicleParts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType,color, odometer, price);

                dealership.addVehicle(vehicle);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading inventory file.");
            e.printStackTrace();
        }
        return  dealership;
    }
    public void saveDealership(Dealership dealership) {
        try{
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/inventory.csv"));
            writer.write(dealership.getName() + "|" +
                    dealership.getAddress() + "|" +
                    dealership.getPhone());
            writer.newLine();
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice());
                writer.newLine();
            }
            writer.close();
        }catch (IOException e) {
            System.out.println("Error savng inventory file.");
        }
    }
}
