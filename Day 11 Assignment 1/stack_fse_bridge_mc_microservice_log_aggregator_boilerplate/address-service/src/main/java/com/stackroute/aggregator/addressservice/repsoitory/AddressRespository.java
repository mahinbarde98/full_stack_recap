package com.stackroute.aggregator.addressservice.repsoitory;

import com.stackroute.aggregator.addressservice.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository marks the specific class as a Data Access Object
 */
@Repository
public interface AddressRespository extends CrudRepository<Address, Integer> {
}
