package org.spring.customerservice.service;

import lombok.RequiredArgsConstructor;
import org.spring.customerservice.exeption.UserNotFoundException;
import org.spring.customerservice.model.Customer;
import org.spring.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer findCustomerById(long id) {
        return customerRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("Customer with id " + id + " not found"));
    }

    @Override
    public void deleteCustomerByID(long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("Customer with id " + id + " not found"));
        customerRepository.delete(customer);
    }

    @Override
    public Customer updateCustomer(long id, Customer customer) {
        Customer customerToUpdate = customerRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Customer with id " + id + " not found"));


        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setPhone(customer.getPhone());


        return customerRepository.save(customerToUpdate);
    }

    @Override
    public Customer addCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        if (customers.isEmpty()) {
            throw new UserNotFoundException("There are no customers in the database");
        }
        return customers;
    }
}
