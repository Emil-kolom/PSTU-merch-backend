package com.example.coursework4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "img_dir_path")
    private String imgDirPath;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category", referencedColumnName = "id")
//    @JsonIdentityInfo(
//            generator = ObjectIdGenerators.PropertyGenerator.class,
//            property = "id")
    @JsonBackReference
    private ProductCategory category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Warehouse> warehouses;

    public Product() {
    }

    public Product(Integer id, String name, String description, String imgDirPath, ProductCategory category, List<Warehouse> warehouses) {
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

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgDirPath() {
        return imgDirPath;
    }

    public void setImgDirPath(String imgDirPath) {
        this.imgDirPath = imgDirPath;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!Objects.equals(id, product.id)) return false;
        if (!Objects.equals(name, product.name)) return false;
        if (!Objects.equals(description, product.description)) return false;
        if (!Objects.equals(imgDirPath, product.imgDirPath)) return false;
        if (!Objects.equals(category, product.category)) return false;
        return Objects.equals(warehouses, product.warehouses);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (imgDirPath != null ? imgDirPath.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (warehouses != null ? warehouses.hashCode() : 0);
        return result;
    }
}
