package com.calculator.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// SpringBootApplication anotation is the same as @Configuration, @EnableAutoConfiguration and @ComponentScan
// It is used in the class with main method
@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		// Programs control is delegated to static method 'run'
		// Spring framework will run the TomCat server
		SpringApplication.run(CalculatorApplication.class, args);
	}

}
