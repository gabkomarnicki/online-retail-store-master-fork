package com.csci318.onlineretailstore.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.csci318.onlineretailstore.models.Contact;

@Component
public class ContactModelAssembler implements RepresentationModelAssembler<Contact, EntityModel<Contact>> {
	//contact model assembler
    @Override
    public EntityModel<Contact> toModel(Contact contact) {

        return EntityModel.of(contact, 
                linkTo(methodOn(ContactController.class).one(contact.getId())).withSelfRel(),
                linkTo(methodOn(ContactController.class).all()).withRel("contacts"));
    }
}