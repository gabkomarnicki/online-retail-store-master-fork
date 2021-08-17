package com.csci318.onlineretailstore.controllers;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends RuntimeException {

    CustomerNotFoundException(Long id) {
        super("Customer " + id + " cannot be found.");
    }
}
