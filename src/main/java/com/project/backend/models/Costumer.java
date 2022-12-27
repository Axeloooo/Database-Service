package com.project.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "COSTUMER")
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
    @Column(name = "Username")
    private String username;
    @Column(name = "Email")
    private String email;
    @Column(name = "Phone_Number")
    private int phoneNumber;
    @JsonManagedReference
    @OneToMany(mappedBy = "costumer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Address> address;
    @JsonManagedReference
    @OneToMany(mappedBy = "costumer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Shipment> shipment;

    public Costumer() {
    }

    public Costumer(long id, String firstName, String lastName, String username, String email, int phoneNumber, List<Address> address, List<Shipment> shipment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.shipment = shipment;
    }

    public Costumer(String firstName, String lastName, String username, String email, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Shipment> getShipment() {
        return shipment;
    }

    public void setShipment(List<Shipment> shipment) {
        this.shipment = shipment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Costumer costumer = (Costumer) o;
        return id == costumer.id && phoneNumber == costumer.phoneNumber && Objects.equals(firstName, costumer.firstName) && Objects.equals(lastName, costumer.lastName) && Objects.equals(username, costumer.username) && Objects.equals(email, costumer.email) && Objects.equals(address, costumer.address) && Objects.equals(shipment, costumer.shipment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, email, phoneNumber, address, shipment);
    }

    @Override
    public String toString() {
        return "Costumer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address=" + address +
                ", shipment=" + shipment +
                '}';
    }
}
