package com.stackroute.customresponse.repository;

import com.stackroute.customresponse.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}