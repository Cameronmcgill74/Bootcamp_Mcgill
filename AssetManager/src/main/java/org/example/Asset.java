package org.example;

import java.math.BigDecimal;

public class Asset {
    private  String description;
    private  String dataAcquired;
    private BigDecimal originalCost;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDataAcquired() {
        return dataAcquired;
    }

    public void setDataAcquired(String dataAcquired) {
        this.dataAcquired = dataAcquired;
    }

    public BigDecimal getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(BigDecimal originalCost) {
        this.originalCost = originalCost;
    }

    public Asset(String description, String dataAcquired, BigDecimal originalCost) {
        this.description = description;
        this.dataAcquired = dataAcquired;
        this.originalCost = originalCost;
    }
    public BigDecimal getValue() {
        return originalCost;
        }
}
