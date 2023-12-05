package com.stackroute.aggregator.addressservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;


@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String buildingNo;
    @Column
    private String street;
    @Column
    private String area;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private int pincode;

    public Address(Integer id, String buildingNo, String street, String area, String city, String state, int pincode) {
        this.id = id;
        this.buildingNo = buildingNo;
        this.street = street;
        this.area = area;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
}
