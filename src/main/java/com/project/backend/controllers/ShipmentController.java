package com.project.backend.controllers;

import com.project.backend.requests.ShipmentRequest;
import com.project.backend.models.Shipment;
import com.project.backend.services.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {
    @Autowired
    private ShipmentService shipmentService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postOrder(@RequestBody ShipmentRequest orderRequest) {
        Shipment newOrder = new Shipment(
                orderRequest.getDatePlaced(),
                orderRequest.getOrderTotal(),
                orderRequest.getOrderStatus(),
                orderRequest.getPaymentStatus(),
                orderRequest.getDistributor()
        );
        return ResponseEntity.ok(shipmentService.postOrder(newOrder));
    }
    @GetMapping(value = "get/{id}")
    public ResponseEntity<?> getOrder(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(shipmentService.getOrder(id));
    }
}
