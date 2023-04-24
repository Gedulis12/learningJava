package com.calculator.calculator;


import jakarta.validation.constraints.Min;

public class Number {
    @Min(value=0, message="Validation error: Number cannot be negative")
    private int n1;
    @Min(value=0, message="Validation error: Number cannot be negative")
    private int n2;
    private String operation;
    private int result;

    public Number() {}

    public Number(int n1, int n2, String operation, int result) {
        this.n1 = n1;
        this.n2 = n2;
        this.operation = operation;
        this.result = result;
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

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}