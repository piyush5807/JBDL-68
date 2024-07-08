package com.example.demo_order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping("/order")
    public String createOrder(@RequestBody CreateOrderRequest orderRequest){
        String orderId = UUID.randomUUID().toString();

        // TODO: Saving the order in a db table
        logger.info("creating order - {}", orderRequest);
        return this.orderService.createOrder(orderRequest);
    }


}
