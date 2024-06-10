package com.example.demo_security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    /**
     * Operations: Everything needs to be safe (authentication is required)
     *
     * HTTP methods:
     *   GET - Safe : (Because it's not updating the data on the system)
     *   POST , PUT , DELETE - Unsafe (They are changing the data on the system) {CSRF}
     */



    @Autowired
    DemoUserDetailsService demoUserDetailsService;

    private Logger logger = LoggerFactory.getLogger(DemoController.class);

    // Should be invoked by people who have the user authority / role
    @GetMapping("/user/hello")
    public String helloUser(){
        return "Hello User!!";
    }

    // Should be invoked by people who have the admin authority / role
    @GetMapping("/admin/hello")
    public String helloAdmin(){
        return "Hello Admin!!";
    }

    // Should be invoked by anyone who is not even part of the system / public API
    @GetMapping("/hello")
    public String helloGuests(){
        return "Hello Guest!!";
    }

    /**
     * Cyclic dependency error
     * Writing POST API (unsafe) with public access
     */

    /**
     * College library
     *  --> student
     *  --> admin (5-10)
     * FB
     *  --> customer
     *  --> admin (thousands)
     *
     * @param pwd
     * @param username
     * @param authorities
     */

    //TODO: Not a recommended approach

//    @PostMapping("/signup")
//    public void signup(@RequestParam("pwd") String pwd,
//                       @RequestParam("username") String username,
//                       @RequestParam("authorities") String authorities){
//
//        String encodedPwd = NoOpPasswordEncoder.getInstance().encode(pwd);
//
//        DemoUser demoUser = DemoUser.builder()
//                .username(username)
//                .password(pwd)
//                .authorities(authorities)
//                .build();
//
//        this.demoUserDetailsService.create(demoUser);
//    }

    // ------------------------------------------------------------------------

    /**
     * Admin A --> account already exists
     * A wants to onboard his / her colleague B
     * A will hit this API /admin/signup with the details of the B
     * Once the details of B is added in the db, B should be able to login
     **/

    /**
     * User A wants to create their account
     * A will hit the API /user/signup with their details - (Unauthenticated API)
     * Once the details of A is added in the db, A should be able to login
     * @param pwd
     * @param username
     */

    @PostMapping("/admin/signup")         // authenticated or unauthenticated
    public void signup(@RequestParam("pwd") String pwd,
                       @RequestParam("username") String username){

//        String encodedPwd = new BCryptPasswordEncoder().encode(pwd);

        DemoUser demoUser = DemoUser.builder()
                .username(username)
                .password(pwd)
                .authorities("adm")
                .build();

        this.demoUserDetailsService.create(demoUser);
    }

    @PostMapping("/user/signup")
    public void signupUser(@RequestParam("pwd") String pwd,
                       @RequestParam("username") String username){

//        String encodedPwd = new BCryptPasswordEncoder().encode(pwd);

        DemoUser demoUser = DemoUser.builder()
                .username(username)
                .password(pwd)
                .authorities("usr")
                .build();

        this.demoUserDetailsService.create(demoUser);
    }

    // -------------------------------------------------------------------
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
