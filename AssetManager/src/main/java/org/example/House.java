package org.example;

import java.math.BigDecimal;

public class House extends Asset {

    public House(String description, String dataAcquired, BigDecimal originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dataAcquired, originalCost);

        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    private  String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
    @Override
    public BigDecimal getValue() {

        double pricePerFoot = 0;

        if (condition == 1) {
            pricePerFoot = 180;
        } else if (condition == 2) {
            pricePerFoot = 130;
        } else if (condition == 3) {
            pricePerFoot = 90;
        } else if (condition == 4) {
            pricePerFoot = 80;
        }
        double houseValue = squareFoot * pricePerFoot;
        double lotValue = lotSize * 0.25;
        double totalValue = houseValue + lotValue;

        return BigDecimal.valueOf(totalValue);
        }
    }

