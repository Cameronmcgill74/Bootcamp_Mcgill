package org.example;

public class LeaseContract extends Contract {

    private double expectedEndingValue;
    private double LeaseFee;

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return LeaseFee;
    }

    public void setLeaseFee(double leaseFee) {
       this.LeaseFee = leaseFee;
    }

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double expectedEndingValue, Double leaseFee) {
        super(date, customerName, customerEmail, vehicleSold);

            this.expectedEndingValue = expectedEndingValue;
            this.LeaseFee = leaseFee;

        }

    @Override
    public double getTotalPrice() {
        double vehiclePrice = getVehicleSold().getPrice().doubleValue();
        expectedEndingValue = vehiclePrice * 0.50;
        LeaseFee = vehiclePrice * 0.07;
        double totalPrice = expectedEndingValue + LeaseFee;
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        double totalPrice = getTotalPrice();
        double monthlyRate = 0.04 / 12;
        double numberOfPayment = 36;
        double rateFactor = Math.pow(1 + monthlyRate, numberOfPayment);
        double monthlyPayment = totalPrice * monthlyRate * rateFactor / (rateFactor - 1);
        return monthlyPayment;
    }

    @Override
    public String toString() {
        return "LEASE|" + getDate() + "|" +
        getCustomerName() + "|" +
        getCustomerEmail() + "|" +
        getVehicleSold().getVin() + "|" +
        getVehicleSold().getYear() + "|" +
        getVehicleSold().getMake() + "|" +
        getVehicleSold().getModel() + "|" +
        getVehicleSold().getVehicleType() + "|" +
        getVehicleSold().getColor() + "|" +
        getVehicleSold().getOdometer() + "|" +
        getVehicleSold().getPrice() + "|" +
        getExpectedEndingValue() + "|" +
        getLeaseFee() + "|" +
        getTotalPrice() + "|" +
        getMonthlyPayment();

    }
}
