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

    @Column(name = "price")
    private Double price;

    public Warehouse() {
    }

    public Warehouse(Product product, String size, Integer count, Double price) {
        this.product = product;
        this.size = size;
        this.count = count;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Warehouse warehouse = (Warehouse) o;

        if (!Objects.equals(product, warehouse.product)) return false;
        if (!Objects.equals(size, warehouse.size)) return false;
        if (!Objects.equals(count, warehouse.count)) return false;
        return Objects.equals(price, warehouse.price);
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
