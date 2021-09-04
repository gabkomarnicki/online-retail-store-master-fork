package com.csci318.onlineretailstore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private String supplier;
    private String product;
    private String quantity;


}
