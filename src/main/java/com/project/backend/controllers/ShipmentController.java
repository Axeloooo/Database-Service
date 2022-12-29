package com.project.backend.controllers;

import com.project.backend.models.Costumer;
import com.project.backend.repositories.CostumerRepository;
import com.project.backend.repositories.ShipmentRepository;
import com.project.backend.requests.ShipmentRequest;
import com.project.backend.models.Shipment;
import com.project.backend.services.CostumerService;
import com.project.backend.services.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {
    @Autowired
    private ShipmentService shipmentService;
    @Autowired
    private CostumerService costumerService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postOrder(@RequestBody ShipmentRequest shipmentRequest) {
        try{
            Optional<Costumer> searchedCostumer = costumerService.getCostumer(shipmentRequest.getCostumerId());
            if(searchedCostumer.isPresent()) {
                Costumer costumer = searchedCostumer.get();
                Shipment newShipment = new Shipment(
                        shipmentRequest.getDatePlaced(),
                        shipmentRequest.getOrderTotal(),
                        shipmentRequest.getOrderStatus(),
                        shipmentRequest.getPaymentStatus(),
                        shipmentRequest.getDistributor(),
                        costumer
                );
                return ResponseEntity.created(URI.create("")).body(shipmentService.postShipment(newShipment));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }
    @GetMapping(value = "get/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getOrder(@PathVariable(name = "id") long id) {
        Optional<Shipment> searchedShipment = shipmentService.getShipment(id);
        if(searchedShipment.isPresent()) {
            return ResponseEntity.of(searchedShipment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping(value = "get/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllShipment() {
        return ResponseEntity.ok().body(shipmentService.getAllShipment());
    }
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteShipment(@PathVariable(name = "id") long id) {
        shipmentService.deleteShipment(id);
        return ResponseEntity.ok().body("Shipment with ID:" + id + " deleted.");
    }
}
