package com.spring.toyproject_backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {

        // allow cross-origin resource sharing(CORS) to all request
        registry.addMapping("/**");

        WebMvcConfigurer.super.addCorsMappings(registry);
    }
}
