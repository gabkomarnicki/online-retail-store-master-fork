package com.csci318.onlineretailstore.controllers;

import com.csci318.onlineretailstore.models.*;
import com.csci318.onlineretailstore.repositories.*;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CustomerController {

    private final CustomerRepository repository;
    private final ContactRepository contactRepository;
    private final CustomerModelAssembler assembler;
    
    public CustomerController(CustomerRepository repository, CustomerModelAssembler assembler, ContactRepository contactRepository) {
        this.repository = repository;
        this.assembler = assembler;
        this.contactRepository = contactRepository;
    }
  //find all the customers
    @GetMapping("/customers")
    CollectionModel<EntityModel<Customer>> all() {

        List<EntityModel<Customer>> customers = repository.findAll().stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(customers,
        linkTo(methodOn(CustomerController.class).all()).withSelfRel());
    }
    //create new customer
    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer newCustomer) {
        return repository.save(newCustomer);
    }
    //find data by id
    @GetMapping("/customers/{id}")
    EntityModel<Customer> one(@PathVariable Long id) {

        Customer customer = repository.findById(id)
            .orElseThrow(() -> new CustomerNotFoundException(id));

        return assembler.toModel(customer);
    }
    //update customer
    @PutMapping("/customers/{id}")
    Customer replaceCustomer(@RequestBody Customer newCustomer,
                             @PathVariable Long id) {
        return repository.findById(id)
                .map(customer -> {
                    customer.setCompanyName(newCustomer.getCompanyName());
                    customer.setAddress(newCustomer.getAddress());
                    customer.setCountry(newCustomer.getCountry());
                    return repository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
    }
    //update customer and contact
  	@PutMapping("/customers/{id}/contact/{contactId}")
    Customer updateCustomerContact(@PathVariable Long id, @PathVariable Long contactId) {
  		Customer customer = repository.findById(id).orElseThrow(RuntimeException::new);
        Contact contact = contactRepository.findById(contactId).orElseThrow(RuntimeException::new);
        customer.setContact(contact);
        return repository.save(customer);
    }
  	
  	//delete customer record
    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
