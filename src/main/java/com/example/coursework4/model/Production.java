package com.example.coursework4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Production {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "delivery_price")
    private Double delivery_price;

    public Production() {
    }

    public Production(Integer id, LocalDate date, Double delivery_price) {
        this.id = id;
        this.date = date;
        this.delivery_price = delivery_price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getDelivery_price() {
        return delivery_price;
    }

    public void setDelivery_price(Double delivery_price) {
        this.delivery_price = delivery_price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Production that = (Production) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(date, that.date)) return false;
        return Objects.equals(delivery_price, that.delivery_price);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (delivery_price != null ? delivery_price.hashCode() : 0);
        return result;
    }
}
