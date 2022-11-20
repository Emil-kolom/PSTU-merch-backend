package com.example.coursework4.model.IdClass;

import java.io.Serializable;
import java.util.Objects;

public class ProductProduction implements Serializable {
    private Integer productId;
    private Integer productionId;

    public ProductProduction() {
    }

    public ProductProduction(Integer productId, Integer productionId) {
        this.productId = productId;
        this.productionId = productionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductProduction that = (ProductProduction) o;

        if (!Objects.equals(productId, that.productId)) return false;
        return Objects.equals(productionId, that.productionId);
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (productionId != null ? productionId.hashCode() : 0);
        return result;
    }
}
