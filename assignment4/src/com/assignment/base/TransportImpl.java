package com.assignment.base;

public class TransportImpl implements Transport {
    private String type;
    private boolean motor;
    private int manufacturedYear;

    public TransportImpl () {}
    public TransportImpl (String type, boolean motor, int manufacturedYear) {
       this.type = type;
       this.motor = motor;
       this.manufacturedYear = manufacturedYear;
    }
    public TransportImpl (int manufacturedYear) {
       this.type = "ground";
       this.motor = true;
       this.manufacturedYear = manufacturedYear;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setMotor(boolean motor) {
        this.motor = motor;
    }

    @Override
    public boolean getMotor() {
        return this.motor;
    }

    @Override
    public void setManufacturedYear(int year) {
        this.manufacturedYear = year;
    }

    @Override
    public int getManufacturedYear() {
       return this.manufacturedYear;
    }

    @Override
    public String toString() {
                return "Vehicle: " +
                "type='" + type + '\'' +
                ", motor=" + motor +
                ", manufacturedYear=" + manufacturedYear + " ";
    }
}