package com.example.coursework4.model.IdClass;


import java.io.Serializable;
import java.util.Objects;

public class ProductOrder implements Serializable {

    private Integer productId;

    private Integer orderId;

    public ProductOrder() {
    }

    public ProductOrder(Integer productId, Integer orderId) {
        this.productId = productId;
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductOrder that = (ProductOrder) o;

        if (!Objects.equals(productId, that.productId)) return false;
        return Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        return result;
    }
}
