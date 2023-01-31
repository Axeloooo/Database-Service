package com.project.backend.requests;

import java.util.Objects;

public class ProductRequest {
    private String productName;
    private float price;
    private int quantity;
    private String description;
    private long customerId;

    public ProductRequest() {
    }

    public ProductRequest(String productName, float price, int quantity, String description, long customerId) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.customerId = customerId;
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

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRequest that = (ProductRequest) o;
        return Float.compare(that.price, price) == 0 && quantity == that.quantity && customerId == that.customerId && Objects.equals(productName, that.productName) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price, quantity, description, customerId);
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
