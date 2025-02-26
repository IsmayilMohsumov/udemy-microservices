package com.wedevloop.orders.service.impl;

import com.wedevloop.customers.entity.Customer;
import com.wedevloop.menus.entity.Menu;
import com.wedevloop.orders.constants.OrdersConstants;
import com.wedevloop.orders.dto.OrderDetailDTO;
import com.wedevloop.orders.entity.Order;
import com.wedevloop.orders.repository.OrderRepository;
import com.wedevloop.orders.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;
    // Spring frameworkde http request
    private final RestTemplate restTemplate;


    @Override
    public Order saveOrder(Order order) {
        ResponseEntity<Customer> customerResponse = restTemplate.getForEntity(
                OrdersConstants.CUSTOMER_SERVICE_URL + order.getCustomerId(), Customer.class); //1
        //eger tapmasa
        if (!customerResponse.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Customer not found with id: " + order.getCustomerId());
        }

        ResponseEntity<Menu> menuResponse = restTemplate.getForEntity(
                OrdersConstants.MENU_SERVICE_URL + order.getMenuId(), Menu.class); //1
        //eger tapmasa
        if (!menuResponse.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Menu not found with id: " + order.getMenuId());
        }
        order.setOrderDate(LocalDateTime.now());

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public OrderDetailDTO getOrderDetail(Long id) {
        Order order = orderRepository.findById(id)  //eger varsa
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        //63 den davam


        Customer customer = restTemplate.getForObject(OrdersConstants.CUSTOMER_SERVICE_URL + order.getCustomerId(), Customer.class);
        Menu menu = restTemplate.getForObject(OrdersConstants.MENU_SERVICE_URL + order.getMenuId(), Menu.class);

        return new OrderDetailDTO(customer.getName(), menu.getName(), order.getOrderDate());
    }
}
