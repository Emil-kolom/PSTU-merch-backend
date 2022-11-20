package com.example.coursework4.model;

import com.example.coursework4.model.IdClass.ProductSize;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(ProductSize.class)
public class Warehouse {

    @Id
    @Column(name = "product")
//    @ForeignKey
    private Integer productId;

    @Id
    @Column(name = "size")
    private String size;

    @Column(name = "count")
    private Integer count;

    public Warehouse() {
    }

    public Warehouse(Integer productId, String size, Integer count) {
        this.productId = productId;
        this.size = size;
        this.count = count;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer product_id) {
        this.productId = product_id;
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

        if (!productId.equals(warehouse.productId)) return false;
        if (!Objects.equals(size, warehouse.size)) return false;
        return count.equals(warehouse.count);
    }

    @Override
    public int hashCode() {
        int result = productId.hashCode();
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + count.hashCode();
        return result;
    }
}
