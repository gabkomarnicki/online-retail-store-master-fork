package com.csci318.onlineretailstore.controllers;

@SuppressWarnings("serial")
public class ContactNotFoundException extends RuntimeException {
	//return error message when cannot find contact id
    ContactNotFoundException(Long id) {
        super("Could not find contact " + id);
    }
}