package com.calculator.calculator.model;

import jakarta.validation.constraints.Min;

import javax.persistence.*;


// Entity is a POJO class connected with table in the database, using ORM functionality
@Entity
@Table(name = "numbers")
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "n1")
    @Min(value=0, message="Validation error: Number cannot be negative")
    private int n1;

    @Column(name = "n2")
    @Min(value=0, message="Validation error: Number cannot be negative")
    private int n2;

    @Column(name = "operation")
    private String operation;

    @Column(name = "result")
    private double result;

    public Number() {}

    public Number(int id, int n1, int n2, String operation, double result) {
        this.id = id;
        this.n1 = n1;
        this.n2 = n2;
        this.operation = operation;
        this.result = result;
    }

    public Number(int n1, int n2, String operation, double result) {
        this.n1 = n1;
        this.n2 = n2;
        this.operation = operation;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", n1=" + n1 +
                ", n2=" + n2 +
                ", operation='" + operation + '\'' +
                ", result=" + result +
                '}';
    }
}