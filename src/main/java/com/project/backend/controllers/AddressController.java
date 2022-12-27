package com.project.backend.controllers;

import com.project.backend.models.Costumer;
import com.project.backend.repositories.CostumerRepository;
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
    @Autowired
    private CostumerRepository costumerRepository;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postAddress(@RequestBody AddressRequest adressRequest) {
        Costumer searchedCostumer = costumerRepository.getReferenceById(adressRequest.getCostumerId());
        Address newAddress = new Address(
                adressRequest.getCountry(),
                adressRequest.getProvince(),
                adressRequest.getCity(),
                adressRequest.getStreet(),
                adressRequest.getPostalCode(),
                adressRequest.getBuildingName(),
                searchedCostumer
        );
        return ResponseEntity.ok(addressService.postAddress(newAddress));
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<?> getAddress(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(addressService.getAddress(id));
    }
}
