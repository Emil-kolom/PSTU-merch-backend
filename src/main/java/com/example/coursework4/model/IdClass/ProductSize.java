package com.example.coursework4.model.IdClass;

import com.example.coursework4.model.Product;

import java.io.Serializable;
import java.util.Objects;

public class ProductSize implements Serializable {

    private Product product;

    private String size;

    public ProductSize() {
    }

    public ProductSize(Product product, String size) {
        this.product = product;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductSize that = (ProductSize) o;

        if (!Objects.equals(product, that.product)) return false;
        return Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        return result;
    }
}
