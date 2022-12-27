package com.project.backend.controllers;

import com.project.backend.requests.AddressRequest;
import com.project.backend.models.Address;
import com.project.backend.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postAddress(@RequestBody AddressRequest adressRequest) {
        Address newAddress = new Address(
                adressRequest.getCountry(),
                adressRequest.getProvince(),
                adressRequest.getCity(),
                adressRequest.getStreet(),
                adressRequest.getPostalCode(),
                adressRequest.getBuildingName()
        );
        return ResponseEntity.ok(addressService.postAddress(newAddress));
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<?> getAddress(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(addressService.getAddress(id));
    }
}
