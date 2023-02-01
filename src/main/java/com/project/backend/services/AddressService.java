package com.project.backend.services;

import com.project.backend.models.Address;
import com.project.backend.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    public Address postAddress(Address newAddress) {
        return addressRepository.save(newAddress);
    }
    public Optional<Address> getAddress(long id) {
        return addressRepository.findById(id);
    }
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }
    public void deleteAddress(long id) {
        addressRepository.deleteById(id);
    }
    public Address putAddress(Address updatedAddress) {
        return addressRepository.save(updatedAddress);
    }
}
