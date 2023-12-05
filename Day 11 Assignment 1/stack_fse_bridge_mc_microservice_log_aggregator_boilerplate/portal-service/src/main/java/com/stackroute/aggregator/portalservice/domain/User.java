package com.stackroute.aggregator.portalservice.domain;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Customer customer;
    private Address address;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
