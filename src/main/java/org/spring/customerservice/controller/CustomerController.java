package org.spring.customerservice.controller;

import lombok.RequiredArgsConstructor;
import org.spring.customerservice.model.Customer;

import org.spring.customerservice.service.CustomerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerServiceImpl customerService;

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer) {
         return customerService.addCustomer(customer);

    }

    @GetMapping( "/find/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
        Customer customer = customerService.findCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomerByID(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.findAllCustomers();
        return ResponseEntity.ok(customers);
    }

}
