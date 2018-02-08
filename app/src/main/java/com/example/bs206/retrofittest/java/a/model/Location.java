package com.example.bs206.retrofittest.java.a.model;

/**
 * Created by bs206 on 1/15/18.
 */

public class Location
{
    private Double latitude;
    private Double longitude;

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

    public Location(Double latitude, Double longitude) {
    
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
