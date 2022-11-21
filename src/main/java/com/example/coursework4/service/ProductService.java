package com.example.coursework4.service;

import com.example.coursework4.model.Product;
import com.example.coursework4.model.ProductCategory;
import com.example.coursework4.repository.ProductCategoryRepository;
import com.example.coursework4.repository.ProductRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.xml.sax.ErrorHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;


    public ProductService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<ProductCategory> getProductCategories(){
         return productCategoryRepository.findAll();
    }

    public List<Product> getAllProductByCategory(String path){
        return productCategoryRepository.findByUrl(path)
                .map(ProductCategory::getProductList)
                .orElse(new ArrayList<>());
    }

    public Product getProductById(Integer id) throws ResponseStatusException {
        return productRepository.findById(id).orElseThrow(()->{throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "product not found"
        );});
    }

}
