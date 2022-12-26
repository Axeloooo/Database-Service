package com.project.backend.services;

import com.project.backend.models.Adress;
import com.project.backend.repositories.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdressService {
    @Autowired
    private AdressRepository adressRepository;
    public Adress postAdress(Adress newAdress) {
        return adressRepository.save(newAdress);
    }
    public Adress getAdress(long id) {
        return adressRepository.getReferenceById(id);
    }
}
