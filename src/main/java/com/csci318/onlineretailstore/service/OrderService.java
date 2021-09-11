package com.csci318.onlineretailstore.service;

import com.csci318.onlineretailstore.models.Order;
import com.csci318.onlineretailstore.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private Validator validator;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
