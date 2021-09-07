package com.csci318.onlineretailstore.controllers;

import com.csci318.onlineretailstore.models.Order;
import com.csci318.onlineretailstore.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    //loading database with data
    @Bean
    CommandLineRunner initDB(OrderRepository repository) {
        return args -> {
//            log.info("Loading... " + repository.save(new Customer("ABC Company", "221B Baker St", "United Kingdom")));
//            log.info("Loading... " + repository.save(new Customer("DEF Company", "742 Evergreen Terrace", "United States of America")));
//            log.info("Loading... " + contactRepository.save(new Contact("Mark", "Baggins", "021456378", "markFbil@gmail.com", "CEO")));
//            log.info("Loading... " + contactRepository.save(new Contact("Phill", "Baggins", "049876512","frodlib@outlook.com", "President")));
            log.info("Loading..." + repository.save(new Order("ABC Supplier", "microwave", "20")));
            log.info("Loading..." + repository.save(new Order("FedEx", "microprocessor", "90")));
        };
    }
}
