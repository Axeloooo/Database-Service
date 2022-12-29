package com.project.backend.services;

import com.project.backend.models.Address;
import com.project.backend.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    public Address postAddress(Address newAddress) {
        return addressRepository.save(newAddress);
    }
    public Address getAddress(long id) {
        return addressRepository.getReferenceById(id);
    }
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }
    public void deleteAddress(long id) {
        addressRepository.deleteById(id);
    }
}
