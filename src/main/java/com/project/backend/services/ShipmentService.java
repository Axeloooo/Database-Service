package com.project.backend.services;

import com.project.backend.models.Shipment;
import com.project.backend.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;
    public Shipment postShipment(Shipment newOrder) {
        return shipmentRepository.save(newOrder);
    }
    public Optional<Shipment> getShipment(long id) {
        return shipmentRepository.findById(id);
    }
    public List<Shipment> getAllShipment() {
        return shipmentRepository.findAll();
    }
    public void deleteShipment(long id) {
        shipmentRepository.deleteById(id);
    }
}
