package com.stackroute.smartparkingapp.dto;

/**
 * This class represents the Parking data transfer object
 **/
public class ParkingDto {

    /**
     * Fields
     */
    private Integer parkingId;
    private String vehicleType;
    private String dimensions;

    /**
     * No Args constructor
     */
    public ParkingDto() {

    }

    /**
     * Parameterized constructor
     */
    public ParkingDto(Integer parkingId, String vehicleType, String dimensions) {
        this.parkingId = parkingId;
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
