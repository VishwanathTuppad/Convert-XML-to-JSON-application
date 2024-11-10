package com.example.convert.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConvConfiguration {

    @Bean
    public ObjectMapper method(){
        return new ObjectMapper();
    }
}
