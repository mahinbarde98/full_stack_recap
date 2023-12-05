package com.stackroute.smartparkingapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * This class stores the Parking details. This class should be annotated with @Entity annotation.
 */
@Entity
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer parkingId;

    private String vehicleType;
    private String dimensions;

    /**
     * No args constructor
     */
    public Parking() {

    }

    /**
     * Parameterized constructor
     */
    public Parking(String vehicleType, String dimensions) {
        this.vehicleType = vehicleType;
        this.dimensions = dimensions;
    }

    /**
     * Getters and setters
     */
    public Integer getParkingId() {
        return parkingId;
    }

    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    // Add toString() method if needed for debugging or logging

}
