package com.example.demo_security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/hello")
    public String getHello(){
        this.logger.info("inside demoController: getHello");
        return "Hello World!!";
    }

    /**
     * 1. We need to get rid of default random password on every server restart
     * 2. We need to allow multiple users to be created in our application
     * 3. We need to persist their data so that even if the server stops and starts again, we have their data intact
     */

    // 9be42507-65d7-40e2-9820-db64c3985550   5b92e45c-67bb-4b60-8805-ad082608f88e

    // /hello -> request headers = Cookie: JSESSIONID=B9219F0082D5E6EED3DE38351CACA090 of an unauthenticated user

    // get /login -> request headers = Cookie: JSESSIONID=B9219F0082D5E6EED3DE38351CACA090

    // post /login -> request headers = Cookie: JSESSIONID=B9219F0082D5E6EED3DE38351CACA090 , response header --> Set-Cookie: JSESSIONID=41F0DD456596C8A85A6F0206C276CFF4 , also sets the new JSESSIONID that it has created in security context

    // FE has changed the cookie named as JSESSIONID on the front end from B9219F0082D5E6EED3DE38351CACA090 -> 41F0DD456596C8A85A6F0206C276CFF4


    // before logout, jsession id authenticated user - 8E6F3CAE017D74DC55FABF49DCF06B04   , 547F30C05B6364D06EEA18D2D66F65D6
}
