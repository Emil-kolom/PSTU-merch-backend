package com.example.coursework4.repository;

import com.example.coursework4.model.OrderDetails;
import com.example.coursework4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Product> {
}