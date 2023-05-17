package com.SpringBoot.MyString.service;


import com.SpringBoot.MyString.entity.Product;
import com.SpringBoot.MyString.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long productId) {
        Optional<Product> optionalProduct=productRepository.findById(productId);
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        Product product1=productRepository.findById(product.getProductId()).get();
        product1.setProductName(product.getProductName());
        product1.setPrice(product.getPrice());
        Product updatedProduct=productRepository.save(product);
        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long productId) {

    }
}
