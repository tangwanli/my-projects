package com.ly.fish_boom.congfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JackJsonConfig {
	  @Bean
	    public ObjectMapper serializingObjectMapper() {
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.findAndRegisterModules();
	        return objectMapper;
	    }
}
