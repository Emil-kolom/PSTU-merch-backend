package com.example.coursework4.model;

import com.example.coursework4.model.IdClass.ProductProduction;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "production_details")
@IdClass(ProductProduction.class)
public class ProductionDetails {

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "production_id", referencedColumnName = "id")
    private Production production;

    @Column(name = "size")
    private String size;

    @Column(name = "quantity")
    private Integer quantity;

    public ProductionDetails() {
    }

    public ProductionDetails(Product product, Production production, String size, Integer quantity) {
        this.product = product;
        this.production = production;
        this.size = size;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product productId) {
        this.product = productId;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production productionId) {
        this.production = productionId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductionDetails that = (ProductionDetails) o;

        if (!Objects.equals(product, that.product)) return false;
        if (!Objects.equals(production, that.production)) return false;
        if (!Objects.equals(size, that.size)) return false;
        return Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (production != null ? production.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
