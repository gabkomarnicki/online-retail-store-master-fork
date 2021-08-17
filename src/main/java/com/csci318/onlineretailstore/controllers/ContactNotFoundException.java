package com.csci318.onlineretailstore.controllers;

@SuppressWarnings("serial")
public class ContactNotFoundException extends RuntimeException {

    ContactNotFoundException(Long id) {
        super("Could not find contact " + id);
    }
}