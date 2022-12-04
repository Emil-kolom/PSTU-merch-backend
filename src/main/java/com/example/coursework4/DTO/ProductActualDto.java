package com.example.coursework4.DTO;

import com.example.coursework4.model.ProductCategory;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.coursework4.model.Product} entity
 */
public class ProductActualDto implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private String imgDirPath;
    private ProductCategory category;
    private List<WarehouseDto> warehouses;

    public ProductActualDto(Integer id, String name, String description, String imgDirPath, ProductCategory category, List<WarehouseDto> warehouses) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgDirPath = imgDirPath;
        this.category = category;
        this.warehouses = warehouses;
    }

    public ProductActualDto() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgDirPath(String imgDirPath) {
        this.imgDirPath = imgDirPath;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public void setWarehouses(List<WarehouseDto> warehouses) {
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