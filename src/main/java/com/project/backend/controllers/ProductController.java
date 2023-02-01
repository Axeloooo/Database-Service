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
                calculateProductDetails(newProduct, "post");
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
                Customer customer = searchedProduct.get().getCustomer();
                customer.getProduct().removeIf(product -> product.getId() == id);
                calculateProductDetails(searchedProduct.get(), "delete");
                customerService.putCustomer(customer);
                return ResponseEntity.ok().body("Product with ID:" + id + " deleted.");
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
                    calculateProductsDetails(updateProduct, searchedProduct.get());
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

    private void calculateProductDetails(Product product, String operation) {
        float totalPrice = product.getCustomer().getTotalPrice();
        int totalProducts = product.getCustomer().getTotalProducts();
        Customer customer = product.getCustomer();
        switch (operation) {
            case "post" -> {
                totalPrice += product.getPrice();
                totalProducts += product.getQuantity();
                customer.setTotalPrice(totalPrice);
                customer.setTotalProducts(totalProducts);
            }
            case "delete" -> {
                totalPrice -= product.getPrice();
                totalProducts -= product.getQuantity();
                customer.setTotalPrice(totalPrice);
                customer.setTotalProducts(totalProducts);
            }
        }
    }

    private void calculateProductsDetails(Product newProduct, Product oldProduct) {
        float totalPrice = oldProduct.getCustomer().getTotalPrice();
        int totalProducts = oldProduct.getCustomer().getTotalProducts();
        Customer customer = oldProduct.getCustomer();
        totalPrice -= oldProduct.getPrice();
        totalProducts -= oldProduct.getQuantity();
        totalPrice += newProduct.getPrice();
        totalProducts += newProduct.getQuantity();
        customer.setTotalPrice(totalPrice);
        customer.setTotalProducts(totalProducts);
    }
}
