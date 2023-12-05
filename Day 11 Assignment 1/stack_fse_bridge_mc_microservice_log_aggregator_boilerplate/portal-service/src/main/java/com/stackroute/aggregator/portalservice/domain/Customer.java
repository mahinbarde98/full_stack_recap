package com.stackroute.aggregator.portalservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {


    private Integer id;
    private String name;
    private String email;
    private String gender;
    private String contactNumber;

}
