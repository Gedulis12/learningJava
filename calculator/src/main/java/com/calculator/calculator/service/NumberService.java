package com.calculator.calculator.service;

import com.calculator.calculator.model.Number;

import java.util.List;

// Service layer purpose is for business logic
public interface NumberService {

    void insert(Number number);

    Number getById(int id);

    List<Number> getAll();

    void update(Number number);

    void delete(int id);
}
