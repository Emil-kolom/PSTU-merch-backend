package com.example.coursework4.model;

import com.example.coursework4.model.IdClass.ProductProduction;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "production_details")
@IdClass(ProductProduction.class)
public class ProductionDetails {

    @Id
    @Column(name = "product_id")
//    @ForeignKey
    private Integer productId;

    @Id
    @Column(name = "production_id")
    private Integer productionId;

    @Column(name = "size")
    private String size;

    @Column(name = "quantity")
    private Integer quantity;

    public ProductionDetails() {
    }

    public ProductionDetails(Integer productId, Integer productionId, String size, Integer quantity) {
        this.productId = productId;
        this.productionId = productionId;
        this.size = size;
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductionId() {
        return productionId;
    }

    public void setProductionId(Integer productionId) {
        this.productionId = productionId;
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

        if (!Objects.equals(productId, that.productId)) return false;
        if (!Objects.equals(productionId, that.productionId)) return false;
        if (!Objects.equals(size, that.size)) return false;
        return Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (productionId != null ? productionId.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
