package com.swaggerautoconfbean.test.service;

import com.stackroute.swaggerautoconfbean.entity.Product;
import com.stackroute.swaggerautoconfbean.repository.ProductRepo;
import com.stackroute.swaggerautoconfbean.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepo productRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1L, "Product1", 10.0));
        productList.add(new Product(2L, "Product2", 20.0));
        when(productRepository.findAll()).thenReturn(productList);

        List<Product> result = productService.getAllProducts();

        verify(productRepository, times(1)).findAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetProductById() {
        Long productId = 1L;
        Product product = new Product(productId, "Product1", 10.0);
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        Product result = productService.getProductById(productId);

        verify(productRepository, times(1)).findById(productId);
        assertNotNull(result);
        assertEquals(product, result);
    }

    @Test
    public void testSaveProduct() {
        Product product = new Product(1L, "Product1", 10.0);
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.saveProduct(product);

        verify(productRepository, times(1)).save(product);
        assertNotNull(result);
        assertEquals(product, result);
    }

    @Test
    public void testUpdateProduct() {
        Long productId = 1L;
        Product existingProduct = new Product(productId, "Product1", 10.0);
        Product updatedProduct = new Product(productId, "Updated Product", 15.0);
        when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(existingProduct)).thenReturn(updatedProduct);

        Product result = productService.updateProduct(updatedProduct, productId);

        verify(productRepository, times(1)).findById(productId);
        verify(productRepository, times(1)).save(existingProduct);
        assertNotNull(result);
        assertEquals(updatedProduct, result);
    }

    @Test
    public void testDeleteProduct() {
        Long productId = 1L;
        doNothing().when(productRepository).deleteById(productId);

        String result = productService.deleteProduct(productId);

        verify(productRepository, times(1)).deleteById(productId);
        assertEquals("Product Deleted", result);
    }
}


