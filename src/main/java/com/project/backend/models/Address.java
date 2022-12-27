package com.project.backend.models;

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

    public Address() {
    }

    public Address(long id, String country, String province, String city, String street, String postalCode, String building) {
        this.id = id;
        this.country = country;
        this.province = province;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.buildingName = building;
    }

    public Address(String country, String province, String city, String street, String postalCode, String building) {
        this.country = country;
        this.province = province;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.buildingName = building;
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

    public String getBuilding() {
        return buildingName;
    }

    public void setBuilding(String buildingName) {
        this.buildingName = buildingName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address adress = (Address) o;
        return id == adress.id && Objects.equals(country, adress.country) && Objects.equals(province, adress.province) && Objects.equals(city, adress.city) && Objects.equals(street, adress.street) && Objects.equals(postalCode, adress.postalCode) && Objects.equals(buildingName, adress.buildingName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, province, city, street, postalCode, buildingName);
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", buildingName='" + buildingName + '\'' +
                '}';
    }
}
