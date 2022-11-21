package com.example.coursework4.model.IdClass;

import com.example.coursework4.model.Product;
import com.example.coursework4.model.Production;

import java.io.Serializable;
import java.util.Objects;

public class ProductProduction implements Serializable {
    private Product product;
    private Production production;

    public ProductProduction() {
    }

    public ProductProduction(Product product, Production production) {
        this.product = product;
        this.production = production;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductProduction that = (ProductProduction) o;

        if (!Objects.equals(product, that.product)) return false;
        return Objects.equals(production, that.production);
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (production != null ? production.hashCode() : 0);
        return result;
    }
}
