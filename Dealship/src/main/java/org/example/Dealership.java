package org.example;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;


    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public List<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max) {
        return null;
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        return null;
    }
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        return null;
    }
    public List<Vehicle> getVehiclesByColor(String color) {
        return null;
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        return null;
    }
    public List<Vehicle> getVehiclesByType(String vehicletype) {
        return null;
    }
        //Returns all vehicle in the inverntory
    public List<Vehicle> getAllVehicles(){
        return inventory;
    }
    //Add a vehicle to the inventory
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }
    //Removes from the inventory
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }
}
