package com.inheritance.derived;

public class ConstructionWorkerImpl implements ConstructionWorker {

    private int totalWorkRecord;
    private String education;
    private String specialization;
    private int salary;

    public ConstructionWorkerImpl() {
    }

    public ConstructionWorkerImpl(int totalWorkRecord, String education, String specialization, int salary) {
        this.totalWorkRecord = totalWorkRecord;
        this.education = education;
        this.specialization = specialization;
        this.salary = salary;
    }

    @Override
    public int getTotalWorkRecord() {
        return totalWorkRecord;
    }

    @Override
    public void setTotalWorkRecord(int workRecord) {
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
    public int getSalary() {
        return this.salary;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
