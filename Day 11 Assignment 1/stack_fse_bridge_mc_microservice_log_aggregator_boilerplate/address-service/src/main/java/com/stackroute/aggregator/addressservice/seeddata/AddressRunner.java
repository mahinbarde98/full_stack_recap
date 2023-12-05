package com.stackroute.aggregator.addressservice.seeddata;


import com.stackroute.aggregator.addressservice.domain.Address;
import com.stackroute.aggregator.addressservice.repsoitory.AddressRespository;
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
public class AddressRunner implements CommandLineRunner {

    private static Logger log = LoggerFactory.getLogger(AddressRunner.class);
    @Autowired
    private AddressRespository addressRespository;


    @Override
    public void run(String...args) throws Exception {
        log.info("Application started with command-line arguments");
        addressRespository.save(new Address(1,"3185","Rainbow Drive","Newport","Akron","Ohio",44311));
        addressRespository.save(new Address(2,"250","Longbow Street","Chris Avenue","Boston","Los angeles",12345));
        addressRespository.save(new Address(3,"4208","Hott Street","Payne Avenue","Oklahoma City","Oklahoma",87663));
        addressRespository.save(new Address(4,"1387","Edgewood Road","Square Avenue","Little Rock","Arkansas",72210));
        addressRespository.save(new Address(5,"1176","Pick Street","George Avenue","Kremmling","Colorado",80459));
        addressRespository.save(new Address(6,"2153","Tyler Avenue","Beach Lane","Miami","Florida",33128));
    }
}
