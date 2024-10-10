package org.spring.customerservice.service;

import org.spring.customerservice.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer findCustomerById(long id);

    Customer addCustomer(Customer customer);

    void deleteCustomerByID(long id);

    Customer updateCustomer(long id, Customer customer);

    List<Customer> findAllCustomers();
}
