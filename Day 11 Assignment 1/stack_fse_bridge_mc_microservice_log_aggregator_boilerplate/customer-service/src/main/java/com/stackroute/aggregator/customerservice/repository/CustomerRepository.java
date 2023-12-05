package com.stackroute.aggregator.customerservice.repository;

import com.stackroute.aggregator.customerservice.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository marks the specific class as a Data Access Object
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
