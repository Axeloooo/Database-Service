package com.project.backend.services;

import com.project.backend.models.Product;
import com.project.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product postProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }
    public Optional<Product> getProduct(long id) {
        return productRepository.findById(id);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
    public Product putProduct(Product updatedProduct) {
        return productRepository.save(updatedProduct);
    }
}
