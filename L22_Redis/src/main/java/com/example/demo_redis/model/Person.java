package com.example.demo_redis.model;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements Serializable{

    private String id;

    private String name;

    private Integer age;

    private Double creditScore;

    private Boolean isSeniorCitizen;
}
