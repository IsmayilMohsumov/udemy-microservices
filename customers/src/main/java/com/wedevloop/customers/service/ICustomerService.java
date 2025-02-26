package com.wedevloop.customers.service;

import com.wedevloop.customers.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    //CRUD

    void createCustomer(Customer customer);

    List<Customer> getAllCustomers();

    void updateCustomer(Customer customer);

    void deleteCustomer(Long id);
    Optional<Customer> getCustomerById(Long id);
}
