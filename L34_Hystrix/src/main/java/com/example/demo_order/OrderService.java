package com.example.demo_order;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String createOrder(CreateOrderRequest orderRequest) {
        // TODO: Saving the order details in the repository

        this.logger.info("Inside createOrder, request - {}", orderRequest);

        restTemplate.getForObject("http://demo-notif/notify", String.class);

        return UUID.randomUUID().toString();
    }

    public String fallbackMethod(CreateOrderRequest orderRequest) {
        this.logger.info("Inside fallbackMethod, request - {}", orderRequest);
        return "Something went wrong. Please try again later...";
    }

//    public String fallbackMethod2(CreateOrderRequest orderRequest) {
//        restTemplate.getForObject("http://localhost:9090/notify-2", String.class);
//        return "Fallback response: Something went wrong.";
//    }
}









