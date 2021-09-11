package com.csci318.onlineretailstore.service;

import com.csci318.onlineretailstore.models.Order;
import com.csci318.onlineretailstore.repositories.OrderRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
