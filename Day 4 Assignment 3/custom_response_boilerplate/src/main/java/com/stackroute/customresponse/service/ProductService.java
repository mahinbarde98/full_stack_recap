package com.stackroute.customresponse.service;
import com.stackroute.customresponse.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    Product updateProduct(Product product);

    List < Product > getAllProduct();

    Product getProductById(long productId);

    Product deleteProduct(long id);
}