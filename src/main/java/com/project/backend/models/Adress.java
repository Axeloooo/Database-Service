package com.project.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "ADRESS")
public class Adress {
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

    public Adress() {
    }

    public Adress(long id, String country, String province, String city, String street, String postalCode, String building, Costumer costumer) {
        this.id = id;
        this.country = country;
        this.province = province;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.buildingName = building;
        this.costumer = costumer;
    }

    public Adress(String country, String province, String city, String street, String postalCode, String building, Costumer costumer) {
        this.country = country;
        this.province = province;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.buildingName = building;
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

    public String getBuilding() {
        return buildingName;
    }

    public void setBuilding(String buildingName) {
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
        Adress adress = (Adress) o;
        return id == adress.id && Objects.equals(country, adress.country) && Objects.equals(province, adress.province) && Objects.equals(city, adress.city) && Objects.equals(street, adress.street) && Objects.equals(postalCode, adress.postalCode) && Objects.equals(buildingName, adress.buildingName) && Objects.equals(costumer, adress.costumer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, province, city, street, postalCode, buildingName, costumer);
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
                ", costumer=" + costumer +
                '}';
    }
}
