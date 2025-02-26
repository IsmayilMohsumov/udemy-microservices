package com.wedevloop.customers.service.impl;

import com.wedevloop.customers.entity.Customer;
import com.wedevloop.customers.exception.CustomerAlreadyExistsException;
import com.wedevloop.customers.repository.CustomerRepository;
import com.wedevloop.customers.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private CustomerRepository customerRepository;

    @Override
    public void createCustomer(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByEmail(customer.getEmail());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException(String.format(
                    "Customer already registered with given email: %s", customer.getEmail()));
        }

        customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }
}
