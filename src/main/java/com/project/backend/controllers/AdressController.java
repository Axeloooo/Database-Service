package com.project.backend.controllers;

import com.project.backend.requests.AdressRequest;
import com.project.backend.models.Adress;
import com.project.backend.models.Costumer;
import com.project.backend.repositories.CostumerRepository;
import com.project.backend.services.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adress")
public class AdressController {
    @Autowired
    private AdressService adressService;
    @Autowired
    private CostumerRepository costumerRepository;
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postAdress(@RequestBody AdressRequest adressRequest) {
        Costumer costumer = costumerRepository.getReferenceById(adressRequest.getCostumerId());
        Adress newAdress = new Adress(
                adressRequest.getCountry(),
                adressRequest.getProvince(),
                adressRequest.getCity(),
                adressRequest.getStreet(),
                adressRequest.getPostalCode(),
                adressRequest.getBuildingName(),
                costumer
        );
        return ResponseEntity.ok(adressService.postAdress(newAdress));
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<?> getAdress(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(adressService.getAdress(id));
    }
}
