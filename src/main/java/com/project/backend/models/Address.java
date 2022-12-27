package com.project.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Country")
    private String country;
    @Column(name = "Province")
    private String province;
    @Column(name = "City")
    private String city;
    @Column(name = "Street")
    private String street;
    @Column(name = "Postal_Code")
    private String postalCode;
    @Column(name = "Building_Name")
    private String buildingName;
    @JsonBackReference(value = "costumer")
    @ManyToOne(fetch = FetchType.EAGER)
    private Costumer costumer;
    public Address() {
    }

    public Address(long id, String country, String province, String city, String street, String postalCode, String buildingName, Costumer costumer) {
        this.id = id;
        this.country = country;
        this.province = province;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.buildingName = buildingName;
        this.costumer = costumer;
    }

    public Address(String country, String province, String city, String street, String postalCode, String buildingName, Costumer costumer) {
        this.country = country;
        this.province = province;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.buildingName = buildingName;
        this.costumer = costumer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
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
        Address address = (Address) o;
        return id == address.id && Objects.equals(country, address.country) && Objects.equals(province, address.province) && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(postalCode, address.postalCode) && Objects.equals(buildingName, address.buildingName) && Objects.equals(costumer, address.costumer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, province, city, street, postalCode, buildingName, costumer);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", costumer=" + costumer +
                '}';
    }
}
