package com.stackroute.aggregator.portalservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {


    private Integer id;
    private String buildingNo;
    private String street;
    private String area;
    private String city;
    private String state;
    private int pincode;
}
