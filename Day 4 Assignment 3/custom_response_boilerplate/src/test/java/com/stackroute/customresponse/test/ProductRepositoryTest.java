package com.stackroute.customresponse.test;

import com.stackroute.customresponse.model.Product;
import com.stackroute.customresponse.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSaveProduct() {
        Product product = new Product();
        product.setName("TestProduct");
        product.setPrice(100.0);
        Product savedProduct = productRepository.save(product);
        assertNotNull(savedProduct);
    }

    @Test
    public void testFindProductById() {
        Product product = new Product();
        product.setName("TestProduct");
        product.setPrice(100.0);
        Product savedProduct = productRepository.save(product);
        Product retrievedProduct = productRepository.findById(savedProduct.getId()).orElse(null);
        assertNotNull(retrievedProduct);
        assertEquals("TestProduct", retrievedProduct.getName());
        assertEquals(100.0, retrievedProduct.getPrice(), 0.001);
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        product.setName("TestProduct");
        product.setPrice(100.0);
        Product savedProduct = productRepository.save(product);
        savedProduct.setPrice(200.0);
        Product updatedProduct = productRepository.save(savedProduct);
        assertNotNull(updatedProduct);
        assertEquals(200.0, updatedProduct.getPrice(), 0.001);
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product();
        product.setName("TestProduct");
        product.setPrice(100.0);
        Product savedProduct = productRepository.save(product);
        productRepository.delete(savedProduct);
        Product deletedProduct = productRepository.findById(savedProduct.getId()).orElse(null);
        assertNull(deletedProduct);
    }

    @Test
    public void testFindAllProducts() {
        Product product1 = new Product();
        product1.setName("TestProduct1");
        product1.setPrice(100.0);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("TestProduct2");
        product2.setPrice(200.0);
        productRepository.save(product2);

        List<Product> productList = productRepository.findAll();
        assertNotNull(productList);
        assertEquals(2, productList.size());
    }
}
