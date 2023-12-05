package com.swaggerautoconfbean.test.controller;

import com.stackroute.swaggerautoconfbean.controller.ProductController;
import com.stackroute.swaggerautoconfbean.entity.Product;
import com.stackroute.swaggerautoconfbean.service.ProductService;
import com.stackroute.swaggerautoconfbean.service.CustomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Mock
    private CustomService customService;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    public void testGetAllProducts() {
        when(productService.getAllProducts()).thenReturn(someListOfProducts());

        ResponseEntity<?> response = productController.getAllProducts();

        verify(productService, times(1)).getAllProducts();
        assertThat(response.getBody(), samePropertyValuesAs(someListOfProducts()));
    }

    @Test
    public void testGetProductById() {
        Long productId = 1L;
        Product expectedProduct = new Product(productId, "Sample Product", 9.99);
        when(productService.getProductById(productId)).thenReturn(expectedProduct);

        ResponseEntity<?> response = productController.getProductById(productId);

        verify(productService, times(1)).getProductById(productId);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Use Hamcrest's samePropertyValuesAs to compare objects
        assertThat(response.getBody(), samePropertyValuesAs(expectedProduct));
    }

    @Test
    public void testSaveProduct() {
        Product product = someProduct();
        when(productService.saveProduct(product)).thenReturn(product);

        ResponseEntity<?> response = productController.saveProduct(product);

        verify(productService, times(1)).saveProduct(product);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    public void testUpdateProduct() {
        Long productId = 1L;
        Product updatedProduct = someProduct();
        when(productService.updateProduct(updatedProduct, productId)).thenReturn(updatedProduct);

        ResponseEntity<?> response = productController.updateProduct(updatedProduct, productId);

        verify(productService, times(1)).updateProduct(updatedProduct, productId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedProduct, response.getBody());
    }

    @Test
    public void testDeleteProduct() {
        Long productId = 1L;
        when(productService.deleteProduct(productId)).thenReturn("Product Deleted");

        ResponseEntity<?> response = productController.deleteProduct(productId);

        verify(productService, times(1)).deleteProduct(productId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Product Deleted", response.getBody());
    }

    private Product someProduct() {
        return new Product(1L, "Sample Product", 9.99);
    }

    private List<Product> someListOfProducts() {
        List<Product> products = new ArrayList<>();
        products.add(someProduct());
        // Add more sample products as needed
        return products;
    }

    @Test
    public void customEndpoint_ReturnsCustomMessage() {
        // Arrange
        when(customService.customLogic()).thenReturn("Custom logic executed by CustomService");

        // Act
        String response = productController.customEndpoint();

        // Assert
        assertEquals("Custom logic executed by CustomService", response);
    }
}

