package com.example.demo_order;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderRequest {

    private String userId;

    private Map<String, Integer> items;
}
