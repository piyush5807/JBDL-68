package com.example.demo_redis.dto;

import com.example.demo_redis.model.Person;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePersonRequest {

    @NotBlank
    private String name;

    @Min(1)
    @Max(200)
    private Integer age;

    private Double creditScore;

    private Boolean isSeniorCitizen;

    public Person to() {

        return Person.builder()
                .id(UUID.randomUUID().toString())
                .age(this.age)
                .name(this.name)
                .creditScore(this.creditScore)
                .isSeniorCitizen(this.isSeniorCitizen)
                .build();
    }
}
