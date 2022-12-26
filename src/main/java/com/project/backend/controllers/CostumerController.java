package com.project.backend.controllers;

import com.project.backend.requests.CostumerRequest;
import com.project.backend.models.Costumer;
import com.project.backend.services.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/costumer")
public class CostumerController {
    @Autowired
    private CostumerService costumerService;
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postCostumer(@RequestBody CostumerRequest costumerRequest){
        Costumer newCostumer = new Costumer(
                costumerRequest.getFirstName(),
                costumerRequest.getLastName(),
                costumerRequest.getUsername(),
                costumerRequest.getEmail(),
                costumerRequest.getPhoneNumber()
                );
        return ResponseEntity.ok(costumerService.postCostumer(newCostumer));
    }
    @GetMapping(value = "read/{id}")
    public ResponseEntity<?> getCostumer(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(costumerService.getCostumer(id));
    }
}
