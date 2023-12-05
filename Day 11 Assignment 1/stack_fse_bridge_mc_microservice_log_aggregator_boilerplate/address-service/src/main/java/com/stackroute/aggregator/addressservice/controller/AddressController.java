package com.stackroute.aggregator.addressservice.controller;

import com.stackroute.aggregator.addressservice.domain.Address;
import com.stackroute.aggregator.addressservice.repsoitory.AddressRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


/**
 * Controller to access, modify data in database using REST
 */
@RestController
@Slf4j
@RequestMapping(value = "/address")
public class AddressController {

    private AddressRespository addressRespository;

    @Autowired
    public AddressController(AddressRespository addressRespository) {
        this.addressRespository = addressRespository;
    }

    /**
     * REST Endpoint to get address of a customer given customerId
     * URI: /{customerId}  METHOD: GET
     * Response status: success: 202(accepted)
     */
    @GetMapping(value = "/{customerId}")
    public ResponseEntity<Address> getAddress(@PathVariable(name = "customerId", required = true) int customerId){

        Address address = addressRespository.findById(customerId).orElse(null);

        if(address!=null){
            return  new ResponseEntity<>(address,HttpStatus.ACCEPTED);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}
