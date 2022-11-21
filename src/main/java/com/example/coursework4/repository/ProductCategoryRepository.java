package com.example.coursework4.repository;

import com.example.coursework4.model.Product;
import com.example.coursework4.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    Optional<ProductCategory> findByUrl(String path);
}