package com.stackroute.swaggerautoconfbean.repository;

import com.stackroute.swaggerautoconfbean.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
