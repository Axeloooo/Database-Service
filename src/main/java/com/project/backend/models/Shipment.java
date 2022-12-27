package com.project.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference(value = "costumer")
    @ManyToOne(fetch = FetchType.EAGER)
    private Costumer costumer;

    public Shipment() {
    }

    public Shipment(long id, String datePlaced, int orderTotal, String orderStatus, String paymentStatus, String distributor, Costumer costumer) {
        this.id = id;
        this.datePlaced = datePlaced;
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.distributor = distributor;
        this.costumer = costumer;
    }

    public Shipment(String datePlaced, int orderTotal, String orderStatus, String paymentStatus, String distributor, Costumer costumer) {
        this.datePlaced = datePlaced;
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.distributor = distributor;
        this.costumer = costumer;
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

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return id == shipment.id && orderTotal == shipment.orderTotal && Objects.equals(datePlaced, shipment.datePlaced) && Objects.equals(orderStatus, shipment.orderStatus) && Objects.equals(paymentStatus, shipment.paymentStatus) && Objects.equals(distributor, shipment.distributor) && Objects.equals(costumer, shipment.costumer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datePlaced, orderTotal, orderStatus, paymentStatus, distributor, costumer);
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
                ", costumer=" + costumer +
                '}';
    }
}
