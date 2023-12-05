package com.stackroute.aggregator.customerservice.domain;

import lombok.*;

import jakarta.persistence.*;


@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String gender;
    @Column
    private String contactNumber;

    public Customer(Integer id, String name, String email, String gender, String contactNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.contactNumber = contactNumber;
    }
}
