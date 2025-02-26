package com.wedevloop.orders.repository;

import com.wedevloop.orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
