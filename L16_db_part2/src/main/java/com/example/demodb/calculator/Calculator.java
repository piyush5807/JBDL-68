package com.example.demodb.calculator;

import org.springframework.stereotype.Repository;

@Repository
public interface Calculator {

    int add(int a, int b);

    int subtract(int a, int b);
}
