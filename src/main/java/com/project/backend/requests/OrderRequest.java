package com.project.backend.Requests;

import java.util.Objects;

public class OrderRequest {
    private String datePlaced;
    private int orderTotal;
    private String orderStatus;
    private String paymentStatus;
    private String distributor;
    private long costumerId;

    public OrderRequest() {
    }

    public OrderRequest(String datePlaced, int orderTotal, String orderStatus, String paymentStatus, String distributor, long costumerId) {
        this.datePlaced = datePlaced;
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.distributor = distributor;
        this.costumerId = costumerId;
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

    public long getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(long costumerId) {
        this.costumerId = costumerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRequest that = (OrderRequest) o;
        return orderTotal == that.orderTotal && costumerId == that.costumerId && Objects.equals(datePlaced, that.datePlaced) && Objects.equals(orderStatus, that.orderStatus) && Objects.equals(paymentStatus, that.paymentStatus) && Objects.equals(distributor, that.distributor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datePlaced, orderTotal, orderStatus, paymentStatus, distributor, costumerId);
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "datePlaced='" + datePlaced + '\'' +
                ", orderTotal=" + orderTotal +
                ", orderStatus='" + orderStatus + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", distributor='" + distributor + '\'' +
                ", costumerId=" + costumerId +
                '}';
    }
}