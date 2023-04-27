package com.calculator.calculator.service;

import com.calculator.calculator.model.Number;
import com.calculator.calculator.model.NumberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service - Service layer for business logic
// Service layer calls DAO
@Service
public class NumberServiceImpl implements NumberService {

    // @Autowired is used for automatic dependency injection (IOC - inversion of control)
    // @Bean @Configuration class is required in order to use @Autowired annotation
    @Autowired
    // @Qualifier annotation together with @Autowired ensures which exact Bean should be used to connect dependencies to
    // If @Configuration class has more than one Bean @qualifier is a must.
    // In other cases we get error: 'consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed'
    @Qualifier("NumberDAO")
    private NumberDAO numberDAO;

    @Override
    public void insert(Number number) {
        numberDAO.insertEntity(number);
    }

    @Override
    public Number getById(int id) {
        return numberDAO.findEntityById(id);
    }

    @Override
    public List<Number> getAll() {
        return numberDAO.findEntities();
    }

    @Override
    public void update(Number number) {
        numberDAO.updateEntity(number);
    }

    @Override
    public void delete(int id) {
        numberDAO.removeEntityById(id);
    }
}
