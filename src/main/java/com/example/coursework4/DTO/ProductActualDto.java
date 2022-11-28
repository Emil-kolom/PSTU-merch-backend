package com.example.coursework4.DTO;

import com.example.coursework4.model.ProductCategory;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.coursework4.model.Product} entity
 */
public class ProductActualDto implements Serializable {

    private final Integer id;
    private final String name;
    private final String description;
    private final String imgDirPath;
    private final ProductCategory category;
    private final List<WarehouseDto> warehouses;

    public ProductActualDto(Integer id, String name, String description, String imgDirPath, ProductCategory category, List<WarehouseDto> warehouses) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgDirPath = imgDirPath;
        this.category = category;
        this.warehouses = warehouses;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImgDirPath() {
        return imgDirPath;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public List<WarehouseDto> getWarehouses() {
        return warehouses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductActualDto entity = (ProductActualDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.imgDirPath, entity.imgDirPath) &&
                Objects.equals(this.category, entity.category) &&
                Objects.equals(this.warehouses, entity.warehouses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, imgDirPath, category, warehouses);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "description = " + description + ", " +
                "imgDirPath = " + imgDirPath + ", " +
                "category = " + category + ", " +
                "warehouses = " + warehouses + ")";
    }
}