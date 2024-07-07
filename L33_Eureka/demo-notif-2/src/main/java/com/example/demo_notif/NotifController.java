package com.example.demo_notif;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class NotifController {

    private Logger logger = LoggerFactory.getLogger(NotifController.class);

    @GetMapping("/notify")
    public String notifyUser(){
        logger.info("Inside notifController 2");
        return UUID.randomUUID().toString();
    }
}
