package com.calculator.calculator.controller;

import com.calculator.calculator.model.Number;
import jakarta.validation.Valid;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

// web controller allows to use @RequestMapping
// @RestController annotation shows that for e.g. String type result has to be printed as is
// @RestController annotation is used when creating frontendless application
// When view is necessary (Spring MVC), we use annotation @Controller
@Controller

// Configuration component, allows us to create bean by using methods with @Bean annotation
// This class level annotation tells spring to "Guess" the configuration
// by looking at the dependencies of the project
// in this case it's working together with main method
@EnableAutoConfiguration
public class CalculatorController {
    @RequestMapping(method = RequestMethod.POST, value = "/calculate")

    // RequestParam annotation passes the arguments through url
    public String calculate(
            // IMPORTANT:
            // param bindingResult must go after annotation @Valid
            // In other case there will be error "Validation failed for object"
            @Valid @ModelAttribute("number") Number numb, BindingResult bindingResult,
            @RequestParam HashMap<String, String> inputNumbers, ModelMap outputNumbers) {

        // If validation errors (see validation in Number class by each number variable)
        if(bindingResult.hasErrors()) {
            // user stays in calculator page until the validation errors are not fixed
            return "calculator.jsp";
        } else { // user passed validation
            int n1 = Integer.parseInt(inputNumbers.get("n1"));
            int n2 = Integer.parseInt(inputNumbers.get("n2"));
            double result = 0;
            String operation = inputNumbers.get("operation");

            if (operation.equals("+")) {
                result = n1 + n2;
            } else if (operation.equals("-")) {
                result = n1 - n2;
            } else if (operation.equals("*")) {
                result = n1 * n2;
            } else if (operation.equals("/") && n2 != 0) {
                result = n1 / n2;
            }

            // inputNumbers are used to send data from spring MVC controller to JSP file (view)
            outputNumbers.put("n1", n1);
            outputNumbers.put("n2", n2);
            outputNumbers.put("operation", operation);
            outputNumbers.put("result", result);

           return "calculate.jsp";
        }

        // Application context is interface for giving information about application configuration
        // in this case config is taken from beans.xml file
        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        // bean - class object which adheres to singleton template
        // Calculator bean = (Calculator) applicationContext.getBean("calculator");
        // return bean.getHello();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String displayHomePage(Model model) {
        // If Model 'number' does not pass validation - errors through it are returned to view
        model.addAttribute("number", new Number());
        // return JSP file which must be placed in "webapp/WEB-INF/JSP"
        return "calculator.jsp";
    }
}