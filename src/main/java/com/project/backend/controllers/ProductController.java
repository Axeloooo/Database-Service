package com.project.backend.controllers;

import com.project.backend.models.Customer;
import com.project.backend.models.Product;
import com.project.backend.requests.ProductRequest;
import com.project.backend.services.CustomerService;
import com.project.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postProduct(@RequestBody ProductRequest productRequest) {
        try{
            Optional<Customer> searchedCostumer = customerService.getCustomer(productRequest.getCustomerId());
            if(searchedCostumer.isPresent()) {
                Customer customer = searchedCostumer.get();
                Product newProduct = new Product(
                        productRequest.getProductName(),
                        productRequest.getPrice(),
                        productRequest.getQuantity(),
                        productRequest.getDescription(),
                        customer
                );
                return ResponseEntity.created(URI.create("")).body(productService.postProduct(newProduct));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @GetMapping(value = "get/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getProduct(@PathVariable(name = "id") long id) {
        try {
            Optional<Product> searchedProduct = productService.getProduct(id);
            if (searchedProduct.isPresent()) {
                return ResponseEntity.of(searchedProduct);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @GetMapping(value = "get/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllProducts() {
        try {
            return ResponseEntity.ok(productService.getAllProducts());
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @DeleteMapping(value = "delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") long id) {
        try {
            Optional<Product> searchedProduct = productService.getProduct(id);
            if (searchedProduct.isPresent()) {
                productService.deleteProduct(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @PutMapping(value = "put/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> putProduct(@PathVariable(name = "id") long id, @RequestBody ProductRequest productRequest) {
        try {
            Optional<Customer> searchedCustomer = customerService.getCustomer(productRequest.getCustomerId());
            Optional<Product> searchedProduct = productService.getProduct(id);
            if (searchedProduct.isPresent() && searchedCustomer.isPresent()) {
                if (searchedProduct.get().getCustomer().getId() == productRequest.getCustomerId()) {
                    Product updateProduct = searchedProduct.get();
                    Customer updatedCustomer = searchedCustomer.get();
                    updateProduct.setProductName(productRequest.getProductName());
                    updateProduct.setPrice(productRequest.getPrice());
                    updateProduct.setQuantity(productRequest.getQuantity());
                    updateProduct.setDescription(productRequest.getDescription());
                    updateProduct.setCustomer(updatedCustomer);
                    return ResponseEntity.ok(productService.putProduct(updateProduct));
                } else {
                    return ResponseEntity.badRequest().body("Customer ID does not match");
                }
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }
}
