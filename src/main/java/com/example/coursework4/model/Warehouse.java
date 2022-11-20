package com.example.coursework4.model;

import com.example.coursework4.model.IdClass.ProductSize;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(ProductSize.class)
public class Warehouse {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product", referencedColumnName = "id")
    private Product product;

    @Id
    @Column(name = "size")
    private String size;

    @Column(name = "count")
    private Integer count;

    public Warehouse() {
    }

    public Warehouse(Product product, String size, Integer count) {
        this.product = product;
        this.size = size;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product_id) {
        this.product = product_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Warehouse warehouse = (Warehouse) o;

        if (!product.equals(warehouse.product)) return false;
        if (!Objects.equals(size, warehouse.size)) return false;
        return count.equals(warehouse.count);
    }

    @Override
    public int hashCode() {
        int result = product.hashCode();
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + count.hashCode();
        return result;
    }
}
