package com.csci318.onlineretailstore.controllers;

import com.csci318.onlineretailstore.models.Contact;
import com.csci318.onlineretailstore.models.Customer;
import com.csci318.onlineretailstore.repositories.ContactRepository;
import com.csci318.onlineretailstore.repositories.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDB(CustomerRepository repository,ContactRepository contactRepository) {
        return args -> {
            log.info("Loading... " + repository.save(new Customer("ABC Company", "221B Baker St", "United Kingdom")));
            log.info("Loading... " + repository.save(new Customer("DEF Company", "742 Evergreen Terrace", "United States of America")));
            log.info("Loading... " + contactRepository.save(new Contact("Bilbo", "Baggins", "bil@bibl.bil", "burglar")));
            log.info("Loading... " + contactRepository.save(new Contact("Frodo", "Baggins", "frod@frod.fr", "thief")));
        };
    }
}
