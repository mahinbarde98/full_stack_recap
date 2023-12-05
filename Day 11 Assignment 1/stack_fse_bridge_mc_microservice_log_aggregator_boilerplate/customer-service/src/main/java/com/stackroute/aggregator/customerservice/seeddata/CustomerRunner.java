package com.stackroute.aggregator.customerservice.seeddata;

import com.stackroute.aggregator.customerservice.domain.Customer;
import com.stackroute.aggregator.customerservice.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * Class that implements CommandLineRunner to save data to H2 database
 */

@Slf4j
@Component
public class CustomerRunner implements CommandLineRunner {

    private static Logger log = LoggerFactory.getLogger(CustomerRunner.class);
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void run(String...args) throws Exception {
        log.info("Application started with command-line arguments");
        customerRepository.save(new Customer(1,"Nick","nick@email.com","Male","56738897"));
        customerRepository.save(new Customer(2,"John","John@email.com","Male","99377104"));
        customerRepository.save(new Customer(3,"Peter","peter@email.com","Male","55773112"));
        customerRepository.save(new Customer(4,"Sarah","sarah@email.com","Female","44771234"));
        customerRepository.save(new Customer(5,"Smith","smith@email.com","Female","88466257"));
    }
}
