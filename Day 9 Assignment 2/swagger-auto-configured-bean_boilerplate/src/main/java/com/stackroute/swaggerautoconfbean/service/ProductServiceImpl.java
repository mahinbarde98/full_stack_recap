package com.stackroute.swaggerautoconfbean.service;


import com.stackroute.swaggerautoconfbean.entity.Product;
import com.stackroute.swaggerautoconfbean.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        Product product1= productRepository.findById(id).get();
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        return productRepository.save(product1);
    }

    @Override
    public String deleteProduct(Long id) {
         productRepository.deleteById(id);
         return "Product Deleted";
    }


}
