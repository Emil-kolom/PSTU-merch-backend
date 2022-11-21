package com.example.coursework4.model.IdClass;


import com.example.coursework4.model.Order;
import com.example.coursework4.model.Product;

import java.io.Serializable;
import java.util.Objects;

public class ProductOrder implements Serializable {

    private Product product;

    private Order order;

    public ProductOrder() {
    }

    public ProductOrder(Product product, Order order) {
        this.product = product;
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductOrder that = (ProductOrder) o;

        if (!Objects.equals(product, that.product)) return false;
        return Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }
}
