package com.csci318.onlineretailstore.service;

import com.csci318.onlineretailstore.models.Order;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface OrderServiceIF {

    public abstract CollectionModel<EntityModel<Order>> all();
    public abstract ResponseEntity<?> newOrder(Order newOrder);
    public abstract EntityModel<Order> one(Long id);
    public abstract ResponseEntity<?> replaceOrder(Order newOrder,Long id);
    public abstract ResponseEntity<?> deleteOrder(Long id);
}
