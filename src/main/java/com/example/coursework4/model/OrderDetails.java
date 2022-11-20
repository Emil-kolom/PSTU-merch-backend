package com.example.coursework4.model;

import com.example.coursework4.model.IdClass.ProductOrder;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "order_details")
@IdClass(value = ProductOrder.class)
public class OrderDetails {

    @Id
    @Column(name = "product_id")
//    @ForeignKey
    private Integer productId;

    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "size")
    private String size;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;

    public OrderDetails() {
    }

    public OrderDetails(Integer productId, Integer orderId, String size, Integer quantity, Double price) {
        this.productId = productId;
        this.orderId = orderId;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

        OrderDetails that = (OrderDetails) o;

        if (!Objects.equals(productId, that.productId)) return false;
        if (!Objects.equals(orderId, that.orderId)) return false;
        if (!Objects.equals(size, that.size)) return false;
        if (!Objects.equals(quantity, that.quantity)) return false;
        return Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
