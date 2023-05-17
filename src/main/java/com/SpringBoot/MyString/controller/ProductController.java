package com.SpringBoot.MyString.controller;

import com.SpringBoot.MyString.entity.Product;
import com.SpringBoot.MyString.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;

    //build create product rest api
    //http://localhost:8080/api/product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product myproduct1=productService.createProduct(product);
        return new ResponseEntity<>(myproduct1, HttpStatus.CREATED);
    }

    //build get product by id rest api

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long productId){
        Product myproduct2=productService.getProductById(productId);
        return new ResponseEntity<>(myproduct2, HttpStatus.OK);
    }

    //build get all product rest api

    @GetMapping({"all"})
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> myproduct3=productService.getAllProducts();
        return new ResponseEntity<>(myproduct3, HttpStatus.OK);
    }
    //build update product rest api
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") Long productId){
        product.setProductId(productId);
        Product myproduct4=productService.updateProduct(product);
        return new ResponseEntity<>(myproduct4, HttpStatus.OK);
    }

    //build delete product rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>("Product deleted successfully!", HttpStatus.OK);
    }
}
