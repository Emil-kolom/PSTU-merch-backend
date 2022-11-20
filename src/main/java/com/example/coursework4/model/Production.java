package com.example.coursework4.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "production")
    private List<ProductionDetails> productionDetailsList;

    public Production() {
    }

    public Production(Integer id, LocalDate date, Double delivery_price, List<ProductionDetails> productionDetailsList) {
        this.id = id;
        this.date = date;
        this.delivery_price = delivery_price;
        this.productionDetailsList = productionDetailsList;
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

    public List<ProductionDetails> getProductionDetailsList() {
        return productionDetailsList;
    }

    public void setProductionDetailsList(List<ProductionDetails> productionDetailsList) {
        this.productionDetailsList = productionDetailsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Production that = (Production) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(date, that.date)) return false;
        if (!Objects.equals(delivery_price, that.delivery_price))
            return false;
        return Objects.equals(productionDetailsList, that.productionDetailsList);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (delivery_price != null ? delivery_price.hashCode() : 0);
        result = 31 * result + (productionDetailsList != null ? productionDetailsList.hashCode() : 0);
        return result;
    }
}
