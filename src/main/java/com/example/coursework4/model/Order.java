package com.example.coursework4.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL) //fetch
    @JoinColumn(name = "client", referencedColumnName = "id")
    private Client client;

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

    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetailsList;

    public Order() {
    }

    public Order(Client client, String address, String note, Double deliveryPrice, LocalDateTime orderDate, LocalDateTime shipmentDate, String deliveryNumber, String email, List<OrderDetails> orderDetailsList) {
        this.client = client;
        this.address = address;
        this.note = note;
        this.deliveryPrice = deliveryPrice;
        this.orderDate = orderDate;
        this.shipmentDate = shipmentDate;
        this.deliveryNumber = deliveryNumber;
        this.email = email;
        this.orderDetailsList = orderDetailsList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!Objects.equals(id, order.id)) return false;
        if (!Objects.equals(client, order.client)) return false;
        if (!Objects.equals(address, order.address)) return false;
        if (!Objects.equals(note, order.note)) return false;
        if (!Objects.equals(deliveryPrice, order.deliveryPrice))
            return false;
        if (!Objects.equals(orderDate, order.orderDate)) return false;
        if (!Objects.equals(shipmentDate, order.shipmentDate)) return false;
        if (!Objects.equals(deliveryNumber, order.deliveryNumber))
            return false;
        if (!Objects.equals(email, order.email)) return false;
        return Objects.equals(orderDetailsList, order.orderDetailsList);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (deliveryPrice != null ? deliveryPrice.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (shipmentDate != null ? shipmentDate.hashCode() : 0);
        result = 31 * result + (deliveryNumber != null ? deliveryNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (orderDetailsList != null ? orderDetailsList.hashCode() : 0);
        return result;
    }
}
