package com.csci318.onlineretailstore.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.csci318.onlineretailstore.models.*;
import com.csci318.onlineretailstore.repositories.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ContactController {

    private final ContactRepository repository;

    private final ContactModelAssembler assembler;
    //contact controller
    ContactController(ContactRepository repository, ContactModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }
    //find all contacts
    @GetMapping("/contacts")
    CollectionModel<EntityModel<Contact>> all() {

        List<EntityModel<Contact>> contacts = repository.findAll().stream() 
                .map(assembler::toModel) 
                .collect(Collectors.toList());

        return CollectionModel.of(contacts, linkTo(methodOn(ContactController.class).all()).withSelfRel());
    }
    //create new contact
    @PostMapping("/contacts")
    ResponseEntity<?> newContact(@RequestBody Contact newContact) {

        EntityModel<Contact> entityModel = assembler.toModel(repository.save(newContact));

        return ResponseEntity 
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) 
                .body(entityModel);
    }
    //find contact by id
    @GetMapping("/contacts/{id}")
    EntityModel<Contact> one(@PathVariable Long id) {

        Contact contact = repository.findById(id) 
                .orElseThrow(() -> new ContactNotFoundException(id));

        return assembler.toModel(contact);
    }
    //update contact by id
    @PutMapping("/contacts/{id}")
    ResponseEntity<?> replaceContact(@RequestBody Contact newContact, @PathVariable Long id) {

        Contact updatedContact = repository.findById(id) 
                .map(contact -> {
                    contact.setName(newContact.getName());
                    contact.setPosition(newContact.getPosition());
                    contact.setEmail(newContact.getEmail());
                    return repository.save(contact);
                }) 
                .orElseGet(() -> {
                    newContact.setId(id);
                    return repository.save(newContact);
                });

        EntityModel<Contact> entityModel = assembler.toModel(updatedContact);

        return ResponseEntity 
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) 
                .body(entityModel);
    }
    //delete contact by id
    @DeleteMapping("/contacts/{id}")
    ResponseEntity<?> deleteContact(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}