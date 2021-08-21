package com.csci318.onlineretailstore.controllers;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends RuntimeException {
	//return error message when cannot find customer id
    CustomerNotFoundException(Long id) {
        super("Customer " + id + " cannot be found.");
    }
}
