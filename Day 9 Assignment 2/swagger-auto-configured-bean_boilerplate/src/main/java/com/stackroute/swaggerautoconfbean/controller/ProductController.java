package com.stackroute.swaggerautoconfbean.controller;


import com.stackroute.swaggerautoconfbean.entity.Product;
import com.stackroute.swaggerautoconfbean.service.CustomService;
import com.stackroute.swaggerautoconfbean.service.ProductService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    private final CustomService customService;

    public ProductController(ProductService productService, CustomService customService) {
        this.productService = productService;
        this.customService = customService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Long id) {
        return new ResponseEntity<>(productService.updateProduct(product, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }



    //Add controller for custom endpoint
    @GetMapping
    public String customEndpoint() {
        return  customService.customLogic();
    }



}
