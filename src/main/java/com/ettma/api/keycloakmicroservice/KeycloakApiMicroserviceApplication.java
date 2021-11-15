package com.ettma.api.keycloakmicroservice;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.ettma.api" })
@EnableAutoConfiguration
//@ComponentScan(
//		 basePackageClasses = KeycloakSecurityComponents.class,
//		 excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org.keycloak.adapters.springsecurity.management.HttpSessionManager"))

public class KeycloakApiMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeycloakApiMicroserviceApplication.class, args);
	}

	
	@Bean 
	public WebMvcConfigurer corsConfigurer() { 
		return new WebMvcConfigurer() {
			@Override public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*"); 
			  }
		  };   
	  }	  
	 
		
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	 
	    return builder
	            .setConnectTimeout(Duration.ofMillis(3000))
	            .setReadTimeout(Duration.ofMillis(3000))
	            .build();
	}
}
