package com.stackroute.aggregator.customerservice.controller;


import com.stackroute.aggregator.customerservice.domain.Customer;
import com.stackroute.aggregator.customerservice.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Controller to access, modify data in database using REST
 */
@RestController
@Slf4j
@RequestMapping(value = "/customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * REST Endpoint to get customer details of a customer given customerId
     * URI: /{customerId}  METHOD: GET
     * Response status: success: 202(accepted)
     */
    @GetMapping(value = "/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable(name = "customerId", required = true) int customerId){

        Customer customer =customerRepository.findById(customerId).orElse(null);

        if(customer!=null)
        {
            return new ResponseEntity<>(customer,HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
