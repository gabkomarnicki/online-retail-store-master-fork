package com.csci318.onlineretailstore.repositories;

import com.csci318.onlineretailstore.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}

