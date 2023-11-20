package com.beanScope.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ImageConfig {

    // use this class to get the dependency of rest template

    private static final Logger logger = LoggerFactory.getLogger(ImageConfig.class);
    @Bean
    public RestTemplate getRestTemplate(){
        logger.info("Image config getting initialized");
        return new RestTemplate();
    }
}
