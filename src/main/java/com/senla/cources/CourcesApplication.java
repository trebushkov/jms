package com.senla.cources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class CourcesApplication {

    private static final Logger log = LoggerFactory.getLogger(CourcesApplication.class);

    @Value("${myqueue}")
    private String queue;

    public static void main(String[] args) {
        SpringApplication.run(CourcesApplication.class, args);
    }

//    @Bean
//    CommandLineRunner start(JmsTemplate template) {
//        return args -> {
//            log.info("Sending> ...");
//
//            template.convertAndSend(queue, "Hello World from Spring Boot!");
//        };
//    }

}
