package com.example.coursework4.controller;

import com.example.coursework4.DTO.ProductActualDto;
import com.example.coursework4.model.Product;
import com.example.coursework4.model.ProductCategory;
import com.example.coursework4.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private ProductService productService;

    public CategoryController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductCategory> getListCategories(){
        return productService.getProductCategories();
    }

    @GetMapping("/{path}")
    public List<ProductActualDto> getProductList(@PathVariable(value = "path") String path){
        return productService.getAllProductByCategory(path);
    }

    @GetMapping("/info")
    public ProductCategory  getCategory(@PathParam(value = "path") String path){
        return productService.getCategoryByUrl(path);
    }
}
