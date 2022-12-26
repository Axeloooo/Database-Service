package com.project.backend.controllers;

import com.project.backend.Requests.OrderRequest;
import com.project.backend.models.Costumer;
import com.project.backend.models.Order;
import com.project.backend.repositories.CostumerRepository;
import com.project.backend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CostumerRepository costumerRepository;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postOrder(@RequestBody OrderRequest orderRequest) {
        Costumer costumer = costumerRepository.getReferenceById(orderRequest.getCostumerId());
        Order newOrder = new Order(
                orderRequest.getDatePlaced(),
                orderRequest.getOrderTotal(),
                orderRequest.getOrderStatus(),
                orderRequest.getPaymentStatus(),
                orderRequest.getDistributor(),
                costumer
        );
        return ResponseEntity.ok(orderService.postOrder(newOrder));
    }
    @GetMapping(value = "get/{id}")
    public ResponseEntity<?> getOrder(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }
}
