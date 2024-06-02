package com.example.demo_security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoSecurityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String en1 = passwordEncoder.encode("gaurav@123");
		String en2 = passwordEncoder.encode("sandeep@123");
		System.out.println(en1 + " " +  en2);
//		System.out.println(passwordEncoder.matches("pass@1234", en1));

		/**
		 * $2a$10$tcbt5fkE.9m4MxDe2D/E6.nxPhDAu2r34nWs8oosSWGe2KP1psgn.
		 * $2a$10$VllFXT2kf3zcRXAfs1xL9enZzeNRxyPHp4PYpcu6iCYuP5/F25Fn6
		 */

		/**
		 * Salt 1 - $2a$10$A5OdJfUZuzeP.An0lLSree
		 * EN PWD 1 - $2a$10$A5OdJfUZuzeP.An0lLSree.Ayea8jUHgvJvRdx2MOORamgmmPrgdy
		 *
		 * Salt 2 - $2a$10$m9vNWwZCHu91Cdnt8a..vO
		 * EN PWD 2 - $2a$10$m9vNWwZCHu91Cdnt8a..vOSqGmOxrSSweuG/WIKXyIqNTo8Kt5kmK
		 *
		 */

		/**
		 * encryption:
		 * 		salt :
		 * 	    randomness:
		 */
	}
}
