package com.swaggerautoconfbean.test.repository;

import com.stackroute.swaggerautoconfbean.entity.Product;
import com.stackroute.swaggerautoconfbean.repository.ProductRepo;
import com.stackroute.swaggerautoconfbean.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductRepoTest {

    @InjectMocks
    private ProductServiceImpl productService; // Assuming you're testing the service, not the repository

    @Mock
    private ProductRepo productRepo;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Product> productList = Arrays.asList(
                new Product(1L, "Product1", 10.0),
                new Product(2L, "Product2", 20.0)
        );
        when(productRepo.findAll()).thenReturn(productList);

        List<Product> result = productRepo.findAll();

        verify(productRepo, times(1)).findAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testFindById() {
        Long productId = 1L;
        Product product = new Product(productId, "Product1", 10.0);
        when(productRepo.findById(productId)).thenReturn(Optional.of(product));

        Optional<Product> result = productRepo.findById(productId);

        verify(productRepo, times(1)).findById(productId);
        assertEquals(product, result.orElse(null));
    }

    @Test
    public void testSave() {
        Product product = new Product(1L, "Product1", 10.0);
        when(productRepo.save(product)).thenReturn(product);

        Product result = productRepo.save(product);

        verify(productRepo, times(1)).save(product);
        assertEquals(product, result);
    }

    @Test
    public void testUpdateProduct() {
        Long productId = 1L;
        Product existingProduct = new Product(productId, "Product1", 10.0);
        Product updatedProduct = new Product(productId, "Updated Product", 15.0);

        // Mock the findById method to return the existingProduct when called with productId
        when(productRepo.findById(productId)).thenReturn(Optional.of(existingProduct));

        // Mock the save method to return the updatedProduct when called with any Product
        when(productRepo.save(any(Product.class))).thenReturn(updatedProduct);

        Product result = productService.updateProduct(updatedProduct, productId);

        verify(productRepo, times(1)).findById(productId);
        verify(productRepo, times(1)).save(existingProduct);
        assertEquals(updatedProduct, result);
    }


    @Test
    public void testDelete() {
        Long productId = 1L;
        doNothing().when(productRepo).deleteById(productId);

        productRepo.deleteById(productId);

        verify(productRepo, times(1)).deleteById(productId);
    }
}

