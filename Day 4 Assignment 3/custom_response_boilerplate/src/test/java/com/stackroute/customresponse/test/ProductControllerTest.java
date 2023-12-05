package com.stackroute.customresponse.test;

import com.stackroute.customresponse.controller.ProductController;
import com.stackroute.customresponse.model.Product;
import com.stackroute.customresponse.response.ResponseHandler;
import com.stackroute.customresponse.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private Product testProduct;

    @Before
    public void setUp() {
        testProduct = new Product( "TestProduct", "TestDescription", 100);
    }

    @Test
    public void testGetAllProduct() {
        List<Product> productList = new ArrayList<>();
        productList.add(testProduct);
        Mockito.when(productService.getAllProduct()).thenReturn(productList);
        ResponseEntity<Object> responseEntity = productController.getAllProduct();
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testGetProductByIdSuccess() {
        Mockito.when(productService.getProductById(1L)).thenReturn(testProduct);
        ResponseEntity<Object> responseEntity = productController.getProductById(1L);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testCreateProduct() {
        Mockito.when(productService.createProduct(testProduct)).thenReturn(testProduct);
        ResponseEntity<Object> responseEntity = productController.createProduct(testProduct);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testDeleteProduct() {
        Mockito.when(productService.deleteProduct(1L)).thenReturn(testProduct);
        ResponseEntity<Object> responseEntity = productController.deleteProduct(1L);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
