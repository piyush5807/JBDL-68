package org.geeksforgeeks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WalletApplication {
    public static void main(String[] args) {
        SpringApplication.run(WalletApplication.class, args);

        // 30000
        // 2550.50

        Double a = 10.56;
        // 1056

        System.out.println(a);
    }
}