package com.project.backend.Requests;

import java.util.Objects;

public class AdressRequest {
    private String country;
    private String province;
    private String city;
    private String street;
    private String postalCode;
    private String buildingName;
    private long costumerId;

    public AdressRequest() {
    }

    public AdressRequest(String country, String province, String city, String street, String postalCode, String buildingName, long costumerId) {
        this.country = country;
        this.province = province;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.buildingName = buildingName;
        this.costumerId = costumerId;
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
        AdressRequest that = (AdressRequest) o;
        return costumerId == that.costumerId && Objects.equals(country, that.country) && Objects.equals(province, that.province) && Objects.equals(city, that.city) && Objects.equals(street, that.street) && Objects.equals(postalCode, that.postalCode) && Objects.equals(buildingName, that.buildingName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, province, city, street, postalCode, buildingName, costumerId);
    }

    @Override
    public String toString() {
        return "AdressRequest{" +
                "country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", costumerId=" + costumerId +
                '}';
    }
}
