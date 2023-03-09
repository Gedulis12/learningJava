package com.assignment.base;

import java.util.ArrayList;
import java.util.List;

public class ClientImpl implements Client {
    private String name;
    private String surname;
    private String address;
    private double amount;
    private int clientCode;
    private static List<ClientImpl> instances = new ArrayList<>();

    public ClientImpl() {
    }

    public ClientImpl(String name, String surname, String address, double amount) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.amount = amount;
        setClientCode();
        instances.add(this);
    }

    protected ClientImpl(ClientImpl orig) {
        this.name = orig.getName();
        this.surname = orig.getSurname();
        this.address = orig.getAddress();
        this.amount = orig.getAmount();
        this.clientCode = orig.getClientCode();
    }

    @Override
    public int getClientCode() {
        return this.clientCode;
    }

    private void setClientCode() {
        int maxCode = 0;
        for (ClientImpl i : instances) {
            if (i.getClientCode() >= maxCode) {
               maxCode = i.getClientCode();
            }
        }
        this.clientCode = maxCode + 1;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public double getAmount() {
        return (double) this.amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Client details: " +
                "client code='" + clientCode + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", amount=" + amount;
    }
}
