package com.example.coursework4.controller;

import com.example.coursework4.model.Product;
import com.example.coursework4.model.User;
import com.example.coursework4.service.EmailService;
import com.example.coursework4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Product getProduct(@PathParam("id") Integer id){
        return productService.getProductById(id);
    }

    @ExceptionHandler
    private ResponseEntity<String> errorResponse(ResponseStatusException e) {
        return new ResponseEntity<>(e.getReason(), e.getStatus());
    }
}
