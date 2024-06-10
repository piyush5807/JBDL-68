package com.example.demo_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoConfig extends WebSecurityConfigurerAdapter {

    /**
     * UserDetailsService authentication - you can define where to fetch data from. We can fetch from literally anywhere, below are some of the examples
     * 1. databases (sql or no-sql)
     * 2. caches
     * 3. file
     * 4. blob storage (s3, gcs)
     * 5. some other application / service
     *
     * @param auth
     * @throws Exception
     */

    @Autowired
    DemoUserDetailsService demoUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(demoUserDetailsService);
//                .and()
//                .withUser("Rohit")
//                .password("userNotFoundPassword")
//                .authorities("admin", "user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .csrf()
                .disable()// don't disable this in your production apps, this is just for demonstration
                .authorizeRequests()
                .antMatchers("/user/signup/**").permitAll()
                .antMatchers("/user/**").hasAuthority("usr")
                .antMatchers("/admin/**").hasAuthority("adm")
                .antMatchers("/**").permitAll()   // skip authentication
                .and()
                .formLogin();

        /**
         * The below approach is correct but might require modification in future if there are other POST APIs as well
         */

//        http
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/user/**").permitAll()
//                .antMatchers("/user/**").hasAuthority("usr")
//                .antMatchers("/admin/**").hasAuthority("adm")
//                .antMatchers("/**").permitAll()   // skip authentication
//                .and()
//                .formLogin();

        /**
         * Never do this as this is by pass authentication for all the APIs
         */
//        http
//
//                .authorizeRequests()
//                .antMatchers("/**").permitAll()   // skip authentication
//                .antMatchers("/user/signup/**").permitAll()
//                .antMatchers("/user/**").hasAuthority("usr")
//                .antMatchers("/admin/**").hasAuthority("adm")
//                .and()
//                .formLogin();

        /**
         * The below one is not correct since ant matchers are sequential and if there's a
         * super set in the above ant matcher it will not go to the below ones
         */
//        http
//                .authorizeRequests()
//                .antMatchers("/user/**").hasAuthority("usr")
//                .antMatchers("/user/signup/**").permitAll()
//                .antMatchers("/admin/**").hasAuthority("adm")
//                .antMatchers("/**").permitAll()   // skip authentication
//                .and()
//                .formLogin();

    }






    /**
     * CSRF - Cross site request forgery
     *
     * A --> sbionline@gmail.com (instead of getting an email from sbionline@sbi.com)
     * A --> opens a link in the email
     * A --> route to a malicious website (/B) {302}
     * /B --> /C (c is sbi's site i.e original website where the user wanted to go)
     * A --> enters the login details i.e username, password etc. on /C and get some cookies and other details in the response headers
     * /C --> /B
     * /B --> make a call on behalf of A to withdraw some money or do a txn of some X amount to their account
     */

}
