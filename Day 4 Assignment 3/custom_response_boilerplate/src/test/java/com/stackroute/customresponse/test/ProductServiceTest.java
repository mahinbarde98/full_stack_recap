package com.stackroute.customresponse.test;

import com.stackroute.customresponse.exception.ResourceNotFoundException;
import com.stackroute.customresponse.model.Product;
import com.stackroute.customresponse.repository.ProductRepository;
import com.stackroute.customresponse.service.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product testProduct;

    @Before
    public void setUp() {
        testProduct = new Product(1L,"TestProduct", "TestDescription",100);


    }

    @Test
    public void testCreateProduct() {
        Mockito.when(productRepository.save(testProduct)).thenReturn(testProduct);
        Product createdProduct = productService.createProduct(testProduct);
        assertNotNull(createdProduct);
        assertEquals("TestProduct", createdProduct.getName());
    }

    @Test
    public void testUpdateProduct() {
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(testProduct));
        Mockito.when(productRepository.save(testProduct)).thenReturn(testProduct);
        Product updatedProduct = productService.updateProduct(testProduct);
        assertNotNull(updatedProduct);
        assertEquals("TestProduct", updatedProduct.getName());
    }

    @Test
    public void testGetAllProduct() {
        List<Product> productList = new ArrayList<>();
        productList.add(testProduct);
        Mockito.when(productRepository.findAll()).thenReturn(productList);
        List<Product> retrievedProducts = productService.getAllProduct();
        assertNotNull(retrievedProducts);
        assertEquals(1, retrievedProducts.size());
    }

    @Test
    public void testGetProductByIdSuccess() {
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(testProduct));
        Product retrievedProduct = productService.getProductById(1L);
        assertNotNull(retrievedProduct);
        assertEquals("TestProduct", retrievedProduct.getName());
    }

    @Test
    public void testGetProductByIdNotFound() {
        Mockito.when(productRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> productService.getProductById(2L));
    }

    @Test
    public void testDeleteProductSuccess() {
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(testProduct));
        Product deletedProduct = productService.deleteProduct(1L);
        assertEquals(null, deletedProduct);
    }

    @Test
    public void testDeleteProductNotFound() {
        Mockito.when(productRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> productService.deleteProduct(2L));
    }
}
