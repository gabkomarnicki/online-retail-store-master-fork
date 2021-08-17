package com.csci318.onlineretailstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csci318.onlineretailstore.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {}