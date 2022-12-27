package com.project.backend.services;

import com.project.backend.models.Shipment;
import com.project.backend.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;
    public Shipment postOrder(Shipment newOrder) {
        return shipmentRepository.save(newOrder);
    }
    public Shipment getOrder(long id) {
        return shipmentRepository.getReferenceById(id);
    }
}
