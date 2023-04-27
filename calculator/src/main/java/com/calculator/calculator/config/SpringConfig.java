package com.calculator.calculator.config;

import com.calculator.calculator.model.NumberDAO;
import com.calculator.calculator.model.NumberDAOImpl;
import com.calculator.calculator.service.NumberService;
import com.calculator.calculator.service.NumberServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration annotation marking configuration component
// Enables creating of Beans through methods with @Bean annotation
@Configuration
public class SpringConfig {

    // @Bean - objects that make up the base of spring application
    // Usually it's a java class implementing certain interface and java @Bean specification
    // @Bean adheres to singleton pattern
    @Bean
    @Qualifier("NumberDAO")
    public NumberDAO getNumberDao() {
        return new NumberDAOImpl();
    }

    @Bean
    @Qualifier("NumberService")
    public NumberService getNumberService() {
        return new NumberServiceImpl();
    }
}
