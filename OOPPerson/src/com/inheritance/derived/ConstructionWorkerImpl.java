package com.inheritance.derived;

import com.inheritance.base.PersonImpl;

public class ConstructionWorkerImpl extends PersonImpl implements ConstructionWorker {

    private double totalWorkRecord;
    private String education;
    private String specialization;
    private double salary;

    public ConstructionWorkerImpl() {
    }

    public ConstructionWorkerImpl(
            String gender, String identityCode, String name, String surname, int age, int weight, int height,
            String hairColor, int totalWorkRecord, String education, String specialization, int salary) {
        super(gender, identityCode, name, surname, age, weight, height, hairColor);
        this.totalWorkRecord = totalWorkRecord;
        this.education = education;
        this.specialization = specialization;
        this.salary = salary;
    }

    @Override
    public double getTotalWorkRecord() {
        return totalWorkRecord;
    }

    @Override
    public void setTotalWorkRecord(double workRecord) {
        this.totalWorkRecord = workRecord;
    }

    @Override
    public String getEducation() {
        return this.education;
    }

    @Override
    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String getSpecialization() {
        return this.specialization;
    }

    @Override
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
