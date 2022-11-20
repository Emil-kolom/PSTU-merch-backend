package com.example.coursework4.repository;

import com.example.coursework4.model.Product;
import com.example.coursework4.model.ProductionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionDetailsRepository extends JpaRepository<ProductionDetails, Product> {
}