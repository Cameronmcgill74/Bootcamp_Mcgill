package org.example;

import  java.math.BigDecimal;
import java.util.Locale;

public class Vehicle extends Asset {

    private  String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dataAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        super(description, dataAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
    @Override
    public BigDecimal getValue () {
        int age = 2026 - year;
        double vehicleValue = getOriginalCost().doubleValue();

        for (int i = 1; i <= age; i++){
            if (i <= 3) {
                vehicleValue = vehicleValue * 0.97;
            } else if (i <= 6) {
                vehicleValue = vehicleValue * 0.94;
            } else if (i <= 10) {
                vehicleValue = vehicleValue * 0.92;
            } else {
                vehicleValue = vehicleValue - 1000;
            }
        }
        if (odometer > 100000 &&
                !makeModel.toLowerCase(). contains("honda") &&
                !makeModel.toLowerCase(). contains("toyota")) {
            vehicleValue = vehicleValue * 0.75;
        }
        return BigDecimal.valueOf(vehicleValue);
    }
}
