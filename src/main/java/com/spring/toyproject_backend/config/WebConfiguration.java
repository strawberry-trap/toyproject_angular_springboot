package com.spring.toyproject_backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {

        // allow cross-origin resource sharing(CORS) from 'http://localhost:4200'
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:4200");

        WebMvcConfigurer.super.addCorsMappings(registry);
    }
}
