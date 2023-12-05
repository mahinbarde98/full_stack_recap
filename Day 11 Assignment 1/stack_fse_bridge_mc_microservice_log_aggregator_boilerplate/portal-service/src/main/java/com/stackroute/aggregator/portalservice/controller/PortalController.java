package com.stackroute.aggregator.portalservice.controller;

import com.stackroute.aggregator.portalservice.domain.Address;
import com.stackroute.aggregator.portalservice.domain.Customer;
import com.stackroute.aggregator.portalservice.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * Controller to access, modify data in database using REST
 */
@RestController
@Slf4j
public class PortalController {


    @Autowired
    RestTemplate restTemplate;

    /**
     * REST Endpoint for getting address and customer details of a user (use RestTemplate)
     * URI: /user/{customerId}  METHOD: GET
     * Response status: success: 302(found)
     */
    @GetMapping(value = "/user/{customerId}")
    public ResponseEntity<User> getUserDetails(@PathVariable(name = "customerId", required = true) long customerId){

        User user = restTemplate.getForObject("/user/" + customerId,User.class);

        if(user!=null){
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        else {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
