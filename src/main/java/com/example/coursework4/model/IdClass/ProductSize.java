package com.example.coursework4.model.IdClass;

import java.io.Serializable;
import java.util.Objects;

public class ProductSize implements Serializable {

    private Integer productId;

    private String size;

    public ProductSize() {
    }

    public ProductSize(Integer product_id, String size) {
        this.productId = product_id;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductSize that = (ProductSize) o;

        if (!Objects.equals(productId, that.productId)) return false;
        return Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        return result;
    }
}
