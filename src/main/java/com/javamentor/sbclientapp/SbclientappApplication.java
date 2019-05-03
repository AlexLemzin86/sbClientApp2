package com.javamentor.sbclientapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class SbclientappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbclientappApplication.class, args);
	}

    @Bean
    public RestTemplate restTemplate() {
       /* final RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(Arrays.asList(
                new FormHttpMessageConverter(),
                new StringHttpMessageConverter()
        ));
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("Admin", "Admin"));
        return restTemplate;*/
       return new RestTemplate();
    }

}
