package com.stackroute.swaggerautoconfbean.service;

import com.stackroute.swaggerautoconfbean.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    public Product saveProduct(Product product);
    public Product updateProduct(Product product, Long id);
    public String deleteProduct(Long id);
}
