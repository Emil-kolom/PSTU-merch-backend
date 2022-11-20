package com.example.coursework4.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "client")
    private Integer clientId;

    @Column(name = "address")
    private String address;

    @Column(name = "note")
    private String note;

    @Column(name = "delivery_price")
    private Double deliveryPrice;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "shipment_date")
    private LocalDateTime shipmentDate;

    @Column(name = "delivery_number")
    private String deliveryNumber;

    public Order() {
    }

    public Order(Integer id, Integer clientId, String address, String note, Double deliveryPrice, LocalDateTime orderDate, LocalDateTime shipmentDate, String deliveryNumber) {
        this.id = id;
        this.clientId = clientId;
        this.address = address;
        this.note = note;
        this.deliveryPrice = deliveryPrice;
        this.orderDate = orderDate;
        this.shipmentDate = shipmentDate;
        this.deliveryNumber = deliveryNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(LocalDateTime shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(String deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!Objects.equals(id, order.id)) return false;
        if (!Objects.equals(clientId, order.clientId)) return false;
        if (!Objects.equals(address, order.address)) return false;
        if (!Objects.equals(note, order.note)) return false;
        if (!Objects.equals(deliveryPrice, order.deliveryPrice))
            return false;
        if (!Objects.equals(orderDate, order.orderDate)) return false;
        if (!Objects.equals(shipmentDate, order.shipmentDate)) return false;
        return Objects.equals(deliveryNumber, order.deliveryNumber);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (deliveryPrice != null ? deliveryPrice.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (shipmentDate != null ? shipmentDate.hashCode() : 0);
        result = 31 * result + (deliveryNumber != null ? deliveryNumber.hashCode() : 0);
        return result;
    }
}
