package com.project.backend.requests;

import java.util.Objects;

public class ShipmentRequest {
    private String orderStatus;
    private String paymentStatus;
    private String distributor;
    private long customerId;

    public ShipmentRequest() {
    }

    public ShipmentRequest(String orderStatus, String paymentStatus, String distributor, long customerId) {
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.distributor = distributor;
        this.customerId = customerId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
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
        ShipmentRequest that = (ShipmentRequest) o;
        return customerId == that.customerId && Objects.equals(orderStatus, that.orderStatus) && Objects.equals(paymentStatus, that.paymentStatus) && Objects.equals(distributor, that.distributor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderStatus, paymentStatus, distributor, customerId);
    }

    @Override
    public String toString() {
        return "ShipmentRequest{" +
                "orderStatus='" + orderStatus + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", distributor='" + distributor + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
