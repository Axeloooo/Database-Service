package com.project.backend.services;

import com.project.backend.models.Address;
import com.project.backend.models.Costumer;
import com.project.backend.repositories.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostumerService {
    @Autowired
    private CostumerRepository costumerRepository;
    public Costumer postCostumer(Costumer costumer){
        return costumerRepository.save(costumer);
    }
    public Optional<Costumer> getCostumer(long id) {
        return costumerRepository.findById(id);
    }
    public List<Costumer> getAllCostumer() {
        return costumerRepository.findAll();
    }
    public void deleteCostumer(long id) {
        costumerRepository.deleteById(id);
    }
}
