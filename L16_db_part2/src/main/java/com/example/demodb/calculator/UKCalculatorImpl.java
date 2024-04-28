package com.example.demodb.calculator;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("uk-bean")
public class UKCalculatorImpl implements Calculator{
    @Override
    public int add(int a, int b) {
        return a + b + 1;
    }

    @Override
    public int subtract(int a, int b) {
        return Math.abs(a - b);
    }
}
