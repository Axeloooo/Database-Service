package com.project.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "SHIPMENT")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Date_Placed")
    private String datePlaced;
    @Column(name = "Order_Total")
    private int orderTotal;
    @Column(name = "Order_Status")
    private String orderStatus;
    @Column(name = "Payment_Status")
    private String paymentStatus;
    @Column(name = "Distributor")
    private String distributor;

    public Shipment() {
    }

    public Shipment(long id, String datePlaced, int orderTotal, String orderStatus, String paymentStatus, String distributor) {
        this.id = id;
        this.datePlaced = datePlaced;
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.distributor = distributor;
    }

    public Shipment(String datePlaced, int orderTotal, String orderStatus, String paymentStatus, String distributor) {
        this.datePlaced = datePlaced;
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.distributor = distributor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        Shipment order = (Shipment) o;
        return id == order.id && orderTotal == order.orderTotal && Objects.equals(datePlaced, order.datePlaced) && Objects.equals(orderStatus, order.orderStatus) && Objects.equals(paymentStatus, order.paymentStatus) && Objects.equals(distributor, order.distributor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datePlaced, orderTotal, orderStatus, paymentStatus, distributor);
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id=" + id +
                ", datePlaced='" + datePlaced + '\'' +
                ", orderTotal=" + orderTotal +
                ", orderStatus='" + orderStatus + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", distributor='" + distributor + '\'' +
                '}';
    }
}
