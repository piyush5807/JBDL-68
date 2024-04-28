package com.example.demodb.calculator;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("us-bean")
public class USCalculatorImpl implements Calculator{
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }
}
