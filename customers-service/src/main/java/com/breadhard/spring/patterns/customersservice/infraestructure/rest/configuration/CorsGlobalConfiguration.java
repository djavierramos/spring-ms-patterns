package com.breadhard.spring.patterns.customersservice.infraestructure.rest.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebFlux
@Slf4j
public class CorsGlobalConfiguration implements WebFluxConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        log.info("Configuring CORS");
        corsRegistry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("*")
            .allowedHeaders("*")
            .maxAge(3600)
            ;
        log.info("CORS Configured");
    }

}