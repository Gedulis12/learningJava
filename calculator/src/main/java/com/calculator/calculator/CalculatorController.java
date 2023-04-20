package com.calculator.calculator;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

// web controller allows to use @RequestMapping
// @RestController annotation shows that for e.g. String type result has to be printed as is
@RestController
// Configuration component, allows us to create bean by using methods with @Bean annotation
// This class level annotation tells spring to "Guess" the configuration
// by looking at the dependencies of the project
// in this case it's working together with main method

@EnableAutoConfiguration
public class CalculatorController {
    @RequestMapping(method = RequestMethod.GET, value = "/calculate")

    // RequestParam annotation passes the arguments through url
    public String calculate(@RequestParam HashMap<String, String> numbers ) {

        // key passed through url has name "n1"
        int n1 = Integer.parseInt(numbers.get("n1"));
        int n2 = Integer.parseInt(numbers.get("n2"));
        double result = 0;
        String operation = numbers.get("operation");

        if (operation.equals("+")) {
           result = n1 + n2;
        } else if (operation.equals("-")) {
            result = n1 - n2;
        } else if (operation.equals("*")) {
            result = n1 * n2;
        } else if (operation.equals("/") && n2 != 0) {
            result = n1 / n2;
        }

        return n1 + " " + operation + " " + n2 + " " + "= " + result;

        // Application context is interface for giving information about application configuration
        // in this case config is taken from beans.xml file
        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        // bean - class object which adheres to singleton template
        // Calculator bean = (Calculator) applicationContext.getBean("calculator");
        // return bean.getHello();
    }
}
