package com.example.coursework4.model;

import com.example.coursework4.model.IdClass.ProductOrder;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "order_details")
@IdClass(value = ProductOrder.class)
public class OrderDetails {

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @Column(name = "size")
    private String size;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;

    public OrderDetails() {
    }

    public OrderDetails(Product product, Order order, String size, Integer quantity, Double price) {
        this.product = product;
        this.order = order;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product productId) {
        this.product = productId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order orderId) {
        this.order = orderId;
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

        if (!Objects.equals(product, that.product)) return false;
        if (!Objects.equals(order, that.order)) return false;
        if (!Objects.equals(size, that.size)) return false;
        if (!Objects.equals(quantity, that.quantity)) return false;
        return Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
