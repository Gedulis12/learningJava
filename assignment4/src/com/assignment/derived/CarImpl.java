package com.assignment.derived;

import com.assignment.base.TransportImpl;

public class CarImpl extends TransportImpl implements Car {
    private String brand;
    private int doorQty;
    private boolean EVPowered;

    public CarImpl() {
    }

    public CarImpl(int manufacturedYear, String brand, int doorQty, boolean EVPowered) {
        super(manufacturedYear);
        this.brand = brand;
        this.doorQty = doorQty;
        this.EVPowered = EVPowered;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public void setDoorQty(int doors) {
        this.doorQty = doors;
    }

    @Override
    public int getDoorQty() {
        return this.doorQty;
    }

    @Override
    public void setEVPowered(boolean isEV) {
        this.EVPowered = isEV;
    }

    @Override
    public boolean getEVPowered() {
        return this.EVPowered;
    }

    @Override
    public String toString() {
        return super.toString() +
                "brand='" + brand + '\'' +
                ", doorQty=" + doorQty +
                ", EVPowered=" + EVPowered;
    }
}
