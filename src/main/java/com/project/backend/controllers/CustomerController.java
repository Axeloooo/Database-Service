package com.project.backend.controllers;

import com.project.backend.requests.CustomerRequest;
import com.project.backend.models.Customer;
import com.project.backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postCustomer(@RequestBody CustomerRequest customerRequest){
        try {
            Customer newCustomer = new Customer(
                    customerRequest.getFirstName(),
                    customerRequest.getLastName(),
                    customerRequest.getUsername(),
                    customerRequest.getEmail(),
                    customerRequest.getPhoneNumber(),
                    0,
                    0
            );
            return ResponseEntity.created(URI.create("")).body(customerService.postCustomer(newCustomer));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }
    @GetMapping(value = "/get/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getCustomer(@PathVariable(name = "id") long id) {
        Optional<Customer> searchedCustomer = customerService.getCustomer(id);
        if(searchedCustomer.isPresent()) {
            return ResponseEntity.of(searchedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping(value = "/get/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllCustomer() {
        try {
            return ResponseEntity.ok().body(customerService.getAllCustomer());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(name = "id") long id) {
        try {
            Optional<Customer> searchedCustomer = customerService.getCustomer(id);
            if (searchedCustomer.isPresent()) {
                customerService.deleteCustomer(id);
                return ResponseEntity.ok().body("Customer with ID:" + id + " deleted.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }
    @PutMapping(value = "/put/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> putCustomer(@PathVariable(name = "id") long id, @RequestBody CustomerRequest customerRequest) {
        try {
            Optional<Customer> searchedCustomer = customerService.getCustomer(id);
            if(searchedCustomer.isPresent()) {
                Customer updatedCustomer = searchedCustomer.get();
                updatedCustomer.setFirstName(customerRequest.getFirstName());
                updatedCustomer.setLastName(customerRequest.getLastName());
                updatedCustomer.setUsername(customerRequest.getUsername());
                updatedCustomer.setEmail(customerRequest.getEmail());
                updatedCustomer.setPhoneNumber(customerRequest.getPhoneNumber());
                return ResponseEntity.ok().body(customerService.putCustomer(updatedCustomer));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

}
