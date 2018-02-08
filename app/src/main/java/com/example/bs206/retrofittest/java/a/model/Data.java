package com.example.bs206.retrofittest.java.a.model;

import com.google.gson.annotations.SerializedName;


public class Data
{
    @SerializedName("address")
    private String address;

    @SerializedName("district")
    private String district;

    @SerializedName("latitude")
    private Double latitude;

    @SerializedName("longitude")
    private Double longitude;

    @SerializedName("name_of_atm")
    private String NameOfAtm;

    @SerializedName("sl")
    private Integer slNum;

    @SerializedName("town_city")
    private String townCity;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getNameOfAtm() {
        return NameOfAtm;
    }

    public void setNameOfAtm(String nameOfAtm) {
        NameOfAtm = nameOfAtm;
    }

    public Integer getSlNum() {
        return slNum;
    }

    public void setSlNum(Integer slNum) {
        this.slNum = slNum;
    }

    public String getTownCity() {
        return townCity;
    }

    public void setTownCity(String townCity) {
        this.townCity = townCity;
    }

    public Data(String address, String district, Double latitude, Double longitude,
                String nameOfAtm, Integer slNum, String townCity) {
        this.address = address;
        this.district = district;
        this.latitude = latitude;
        this.longitude = longitude;
        NameOfAtm = nameOfAtm;
        this.slNum = slNum;
        this.townCity = townCity;
    }
}
