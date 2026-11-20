package org.example;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean financeOption;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double salesTaxAmount, double recordingFee, double processingFee, boolean financeOption) {
        super(date, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financeOption = financeOption;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }

    @Override
    public double getTotalPrice() {
        //Get the price of the vehicle
        double vehiclePrice = getVehicleSold().getPrice().doubleValue();
        //calculate the 5% sales tax
        salesTaxAmount = vehiclePrice * 0.05;
        // Set the recording fee
        recordingFee = 100.00;
        //Calculate the processing fee
        if (vehiclePrice < 10000) {
            processingFee = 295.00;
        } else {
            processingFee = 495.00;
        }

        //Calculate the total price
        double totalPrice = vehiclePrice + salesTaxAmount + recordingFee + processingFee;

        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        if (!financeOption) {
            return 0.0;
        }
        double totalPrice = getTotalPrice();

        double interestRate;
        int month;

        if (totalPrice >= 10000) {
            interestRate = 0.0425;
            month = 48;
        } else {
            interestRate = 0.0525;
            month = 24;
        }
        // Convert annual intrest to monthly interest
        double monthlyRate = interestRate / 12;
        // Calculate the monthly payment
        double monthlyPayment = totalPrice * monthlyRate / (1 - Math.pow(1 + monthlyRate, -month));
        // return the monthly payment
        return monthlyPayment;
    }
    }


