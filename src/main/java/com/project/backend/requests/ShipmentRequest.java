package com.project.backend.requests;

import java.util.Objects;

public class ShipmentRequest {
    private String datePlaced;
    private int orderTotal;
    private String orderStatus;
    private String paymentStatus;
    private String distributor;

    public ShipmentRequest() {
    }

    public ShipmentRequest(String datePlaced, int orderTotal, String orderStatus, String paymentStatus, String distributor) {
        this.datePlaced = datePlaced;
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.distributor = distributor;
    }

    public String getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(String datePlaced) {
        this.datePlaced = datePlaced;
    }

    public int getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipmentRequest that = (ShipmentRequest) o;
        return orderTotal == that.orderTotal && Objects.equals(datePlaced, that.datePlaced) && Objects.equals(orderStatus, that.orderStatus) && Objects.equals(paymentStatus, that.paymentStatus) && Objects.equals(distributor, that.distributor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datePlaced, orderTotal, orderStatus, paymentStatus, distributor);
    }

    @Override
    public String toString() {
        return "ShipmentRequest{" +
                "datePlaced='" + datePlaced + '\'' +
                ", orderTotal=" + orderTotal +
                ", orderStatus='" + orderStatus + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", distributor='" + distributor + '\'' +
                '}';
    }
}
