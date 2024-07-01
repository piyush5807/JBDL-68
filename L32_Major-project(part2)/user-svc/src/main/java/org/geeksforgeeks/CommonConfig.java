package org.geeksforgeeks;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CommonConfig {


    @Bean
    public ObjectMapper getMapper(){
        return new ObjectMapper();
    }
}
