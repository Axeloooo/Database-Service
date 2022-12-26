package com.project.backend.services;

import com.project.backend.models.Costumer;
import com.project.backend.repositories.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostumerService {
    @Autowired
    private CostumerRepository costumerRepository;
    public Costumer postCostumer(Costumer costumer){
        return costumerRepository.save(costumer);
    }

    public Costumer getCostumer(long id) {
        return costumerRepository.getReferenceById(id);
    }
}
