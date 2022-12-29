package com.project.backend.controllers;

import com.project.backend.models.Costumer;
import com.project.backend.requests.AddressRequest;
import com.project.backend.models.Address;
import com.project.backend.services.AddressService;
import com.project.backend.services.CostumerService;
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
    private CostumerService costumerService;
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postAddress(@RequestBody AddressRequest addressRequest) {
        try{
            Optional<Costumer> searchedCostumer = costumerService.getCostumer(addressRequest.getCostumerId());
            if(searchedCostumer.isPresent()) {
                Costumer costumer = searchedCostumer.get();
                Address newAddress = new Address(
                        addressRequest.getCountry(),
                        addressRequest.getProvince(),
                        addressRequest.getCity(),
                        addressRequest.getStreet(),
                        addressRequest.getPostalCode(),
                        addressRequest.getBuildingName(),
                        costumer
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
        return ResponseEntity.ok().body(addressService.getAllAddress());
    }
    @DeleteMapping (value = "delete/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable(name = "id") long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok().body("Address with ID:" + id + " deleted.");
    }
}
