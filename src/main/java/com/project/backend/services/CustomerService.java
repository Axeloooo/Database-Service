package com.project.backend.services;

import com.project.backend.models.Customer;
import com.project.backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public Customer postCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    public Optional<Customer> getCustomer(long id) {
        return customerRepository.findById(id);
    }
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }
    public Customer putCustomer(Customer updatedCustomer) {
        return customerRepository.save(updatedCustomer);
    }
}
