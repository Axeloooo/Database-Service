package com.project.backend.services;

import com.project.backend.models.Order;
import com.project.backend.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public Order postOrder(Order newOrder) {
        return orderRepository.save(newOrder);
    }
    public Order getOrder(long id) {
        return orderRepository.getReferenceById(id);
    }
}
