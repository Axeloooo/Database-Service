package com.project.backend.controllers;

import com.project.backend.models.Customer;
import com.project.backend.requests.ShipmentRequest;
import com.project.backend.models.Shipment;
import com.project.backend.schemas.WorldClockAPISchema;
import com.project.backend.services.CustomerService;
import com.project.backend.services.ShipmentService;
import com.project.backend.services.WorldClockAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {
    @Autowired
    private WorldClockAPIService worldClockAPIService;
    @Autowired
    private ShipmentService shipmentService;
    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postOrder(@RequestBody ShipmentRequest shipmentRequest) {
        try{
            Optional<Customer> searchedCustomer = customerService.getCustomer(shipmentRequest.getCustomerId());
            if(searchedCustomer.isPresent()) {
                Customer customer = searchedCustomer.get();
                Shipment newShipment = new Shipment(
                        calculateCurrentDate(),
                        shipmentRequest.getOrderStatus(),
                        shipmentRequest.getPaymentStatus(),
                        shipmentRequest.getDistributor(),
                        customer
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
        try {
            return ResponseEntity.ok().body(shipmentService.getAllShipment());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteShipment(@PathVariable(name = "id") long id) {
        try {
            Optional<Shipment> searchedShipment = shipmentService.getShipment(id);
            if (searchedShipment.isPresent()) {
                Customer customer = searchedShipment.get().getCustomer();
                customer.getShipment().removeIf(shipment -> shipment.getId() == id);
                customerService.putCustomer(customer);
                return ResponseEntity.ok().body("Shipment with ID:" + id + " deleted.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @PutMapping(value = "put/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> putShipment(@PathVariable(name = "id") long id, @RequestBody ShipmentRequest shipmentRequest) {
        try {
            Optional<Customer> searchedCustomer = customerService.getCustomer(shipmentRequest.getCustomerId());
            Optional<Shipment> searchedShipment = shipmentService.getShipment(id);
            if (searchedShipment.isPresent() && searchedCustomer.isPresent()) {
                if(searchedShipment.get().getCustomer().getId() == shipmentRequest.getCustomerId()){
                    Shipment updatedShipment = searchedShipment.get();
                    Customer updatedCustomer = searchedCustomer.get();
                    updatedShipment.setDatePlaced(calculateCurrentDate());
                    updatedShipment.setOrderStatus(shipmentRequest.getOrderStatus());
                    updatedShipment.setPaymentStatus(shipmentRequest.getPaymentStatus());
                    updatedShipment.setDistributor(shipmentRequest.getDistributor());
                    updatedShipment.setCustomer(updatedCustomer);
                    return ResponseEntity.ok().body(shipmentService.putShipment(updatedShipment));
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

    private String calculateCurrentDate() {
        try {
            WorldClockAPISchema worldClock = worldClockAPIService.getWorldClockAPI();
            return worldClock.getCurrentDateTime();
        } catch (Exception e) {
            LocalDateTime currentDate = LocalDateTime.now();
            return currentDate.toString();
        }
    }
}
