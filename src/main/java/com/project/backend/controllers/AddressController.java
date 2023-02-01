package com.project.backend.controllers;

import com.project.backend.models.Customer;
import com.project.backend.requests.AddressRequest;
import com.project.backend.models.Address;
import com.project.backend.services.AddressService;
import com.project.backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postAddress(@RequestBody AddressRequest addressRequest) {
        try{
            Optional<Customer> searchedCustomer = customerService.getCustomer(addressRequest.getCustomerId());
            if(searchedCustomer.isPresent()) {
                Customer customer = searchedCustomer.get();
                Address newAddress = new Address(
                        addressRequest.getCountry(),
                        addressRequest.getProvince(),
                        addressRequest.getCity(),
                        addressRequest.getStreet(),
                        addressRequest.getPostalCode(),
                        addressRequest.getBuildingName(),
                        customer
                );
                return ResponseEntity.created(URI.create("")).body(addressService.postAddress(newAddress));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @GetMapping(value = "get/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAddress(@PathVariable(name = "id") long id) {
        Optional<Address> searchedAddress = addressService.getAddress(id);
        if(searchedAddress.isPresent()) {
            return ResponseEntity.of(searchedAddress);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "get/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllAddress() {
        try {
            return ResponseEntity.ok().body(addressService.getAllAddress());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable(name = "id") long id) {
        try {
            Optional<Address> searchedAddress = addressService.getAddress(id);
            if(searchedAddress.isPresent()) {
                Customer customer = searchedAddress.get().getCustomer();
                customer.getAddress().removeIf(address -> address.getId() == id);
                customerService.putCustomer(customer);
                return ResponseEntity.ok().body("Address with ID:" + id + " deleted.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @PutMapping(value = "put/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> putAddress(@PathVariable(name = "id") long id, @RequestBody AddressRequest addressRequest) {
        try {
            Optional<Customer> searchedCustomer = customerService.getCustomer(addressRequest.getCustomerId());
            Optional<Address> searchedAddress = addressService.getAddress(id);
            if (searchedAddress.isPresent() && searchedCustomer.isPresent()) {
                if (searchedAddress.get().getCustomer().getId() == addressRequest.getCustomerId()) {
                    Address updatedAddress = searchedAddress.get();
                    Customer updatedCustomer = searchedCustomer.get();
                    updatedAddress.setCountry(addressRequest.getCountry());
                    updatedAddress.setProvince(addressRequest.getProvince());
                    updatedAddress.setCity(addressRequest.getCity());
                    updatedAddress.setStreet(addressRequest.getStreet());
                    updatedAddress.setPostalCode(addressRequest.getPostalCode());
                    updatedAddress.setBuildingName(addressRequest.getBuildingName());
                    updatedAddress.setCustomer(updatedCustomer);
                    return ResponseEntity.ok().body(addressService.putAddress(updatedAddress));
                } else {
                    return ResponseEntity.badRequest().body("Customer ID does not match.");
                }
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }
}
