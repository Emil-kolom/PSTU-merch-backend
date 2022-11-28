package com.example.coursework4.repository;

import com.example.coursework4.model.Product;
import com.example.coursework4.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<Warehouse, Product> {
    List<Warehouse> findAllByProduct(Product product);
}