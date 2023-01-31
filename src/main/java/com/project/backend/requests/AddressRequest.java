package com.project.backend.requests;

import java.util.Objects;

public class AddressRequest {
    private String country;
    private String province;
    private String city;
    private String street;
    private String postalCode;
    private String buildingName;
    private long customerId;

    public AddressRequest() {
    }

    public AddressRequest(String country, String province, String city, String street, String postalCode, String buildingName, long customerId) {
        this.country = country;
        this.province = province;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.buildingName = buildingName;
        this.customerId = customerId;
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
        AddressRequest that = (AddressRequest) o;
        return customerId == that.customerId && Objects.equals(country, that.country) && Objects.equals(province, that.province) && Objects.equals(city, that.city) && Objects.equals(street, that.street) && Objects.equals(postalCode, that.postalCode) && Objects.equals(buildingName, that.buildingName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, province, city, street, postalCode, buildingName, customerId);
    }

    @Override
    public String toString() {
        return "AddressRequest{" +
                "country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
