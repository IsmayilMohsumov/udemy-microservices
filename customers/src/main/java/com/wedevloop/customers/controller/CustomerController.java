package com.wedevloop.customers.controller;

import com.wedevloop.customers.entity.Customer;
import com.wedevloop.customers.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {

    private ICustomerService customerService;
    //CRUD - Create / Read / update / delete

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return ResponseEntity.ok("Customer yaradildi ve database elave olundu!");
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PutMapping
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        return ResponseEntity.ok("Customer updated successfully.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
