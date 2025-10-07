package com.taxi;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MyConfiguration {
	
    @Bean
    ModelMapper getModelmapper(){
		return new ModelMapper();
	}
	
    @Bean
    PasswordEncoder getpasswordencoder() {
    	return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    
    
}
