package com.wedevloop.orders.service;
import com.wedevloop.orders.dto.OrderDetailDTO;
import com.wedevloop.orders.entity.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    Order saveOrder(Order order);

    List<Order> getAllOrders();

    Optional<Order> getOrderById(Long id);

    OrderDetailDTO getOrderDetail(Long id);
}
