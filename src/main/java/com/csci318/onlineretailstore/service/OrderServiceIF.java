package com.csci318.onlineretailstore.service;

import com.csci318.onlineretailstore.models.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface OrderServiceIF {

    abstract CollectionModel<EntityModel<Order>> all();
    abstract Order newOrder(Order newOrder);
    abstract EntityModel<Order> one(Long id);
    abstract Order replaceOrder(Order newOrder, Long id);
    abstract void deleteOrder(Long id);
}
