package com.example.demodb.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CalculatorController {

    @Autowired
    @Qualifier("us-bean")
    Calculator calculator;

    /**
     * Will I get an error when I call the API, or even before my application starts
     */

    @GetMapping("/calculator")
    public HashMap<String, Integer> calculate(@RequestParam("a") int a,
                             @RequestParam("b") int b){

        int sum = this.calculator.add(a, b);
        int diff = this.calculator.subtract(a, b);
//        this.calculator.multiply(a, b);

        HashMap<String, Integer> result = new HashMap<>();
        result.put("sum", sum);
        result.put("diff", diff);

        return result;

    }
}
