package com.project.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "price")
    private float price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "description")
    private String description;
    @JsonBackReference(value = "customer")
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    public Product() {
    }

    public Product(long id, String productName, float price, int quantity, String description, Customer customer) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.customer = customer;
    }

    public Product(String productName, float price, int quantity, String description, Customer customer) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Float.compare(product.price, price) == 0 && quantity == product.quantity && Objects.equals(productName, product.productName) && Objects.equals(description, product.description) && Objects.equals(customer, product.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, price, quantity, description, customer);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", customer=" + customer +
                '}';
    }
}
