package com.example.coursework4.service;

import com.example.coursework4.DTO.ProductActualDto;
import com.example.coursework4.DTO.WarehouseDto;
import com.example.coursework4.model.Product;
import com.example.coursework4.model.ProductCategory;
import com.example.coursework4.model.Warehouse;
import com.example.coursework4.repository.ProductCategoryRepository;
import com.example.coursework4.repository.ProductRepository;
import com.example.coursework4.repository.WarehouseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;

    private final WarehouseRepository warehouseRepository;


    public ProductService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository, WarehouseRepository warehouseRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.warehouseRepository = warehouseRepository;
    }

    public List<ProductCategory> getProductCategories() {
        return productCategoryRepository.findAll();
    }

    public List<Product> getAllProductByCategory(String path) {
        return productCategoryRepository.findByUrl(path)
                .map(ProductCategory::getProductList)
                .orElse(new ArrayList<>());
    }

    public ProductActualDto getProductById(Integer id) throws ResponseStatusException {
        Product product = productRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "product not found"
            );
        });
        ProductActualDto productActualDto = convertToProductActualDTO(product);
        return productActualDto;
    }

    private ProductActualDto convertToProductActualDTO(Product product) {
        List<Warehouse> warehouse = warehouseRepository.findAllByProduct(product);
        List<WarehouseDto> warehouseDtoList =
                warehouse.stream()
                        .map((inStoke) ->
                                new WarehouseDto(inStoke.getSize(), inStoke.getCount(), inStoke.getPrice()))
                        .filter((inStoke)-> inStoke.getCount() > 0)
                        .toList();
        ProductActualDto productActualDto = new ProductActualDto(product.getId(), product.getName(),
                product.getDescription(),
                product.getImgDirPath(),
                product.getCategory(),
                warehouseDtoList
        );
        return productActualDto;
    }

}
