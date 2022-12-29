package com.project.backend.controllers;

import com.project.backend.requests.CostumerRequest;
import com.project.backend.models.Costumer;
import com.project.backend.services.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/costumer")
public class CostumerController {
    @Autowired
    private CostumerService costumerService;
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postCostumer(@RequestBody CostumerRequest costumerRequest){
        try {
            Costumer newCostumer = new Costumer(
                    costumerRequest.getFirstName(),
                    costumerRequest.getLastName(),
                    costumerRequest.getUsername(),
                    costumerRequest.getEmail(),
                    costumerRequest.getPhoneNumber()
            );
            return ResponseEntity.created(URI.create("")).body(costumerService.postCostumer(newCostumer));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }
    @GetMapping(value = "/get/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getCostumer(@PathVariable(name = "id") long id) {
        Optional<Costumer> searchedCostumer = costumerService.getCostumer(id);
        if(searchedCostumer.isPresent()) {
            return ResponseEntity.of(searchedCostumer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping(value = "/get/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllCostumer() {
        return ResponseEntity.ok().body(costumerService.getAllCostumer());
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteCostumer(@PathVariable(name = "id") long id) {
        costumerService.deleteCostumer(id);
        return ResponseEntity.ok().body("Costumer with ID:" + id + " deleted.");
    }
    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> putCostumer(@RequestBody Costumer costumer) {
        try {
            Optional<Costumer> searchedCostumer = costumerService.getCostumer(costumer.getId());
            if(searchedCostumer.isPresent()) {
                Costumer updatedCostumer = searchedCostumer.get();
                updatedCostumer.setFirstName(costumer.getFirstName());
                updatedCostumer.setLastName(costumer.getLastName());
                updatedCostumer.setUsername(costumer.getUsername());
                updatedCostumer.setEmail(costumer.getEmail());
                updatedCostumer.setPhoneNumber(costumer.getPhoneNumber());
                return ResponseEntity.ok().body(costumerService.postCostumer(updatedCostumer));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }
}
