package com.SpringBoot.MyString.repository;

import com.SpringBoot.MyString.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
