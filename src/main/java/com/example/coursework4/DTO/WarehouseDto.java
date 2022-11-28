package com.example.coursework4.DTO;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.coursework4.model.Warehouse} entity
 */
public class WarehouseDto implements Serializable {
    private final String size;
    private final Integer count;

    private final Double price;

    public WarehouseDto(String size, Integer count, Double price) {
        this.size = size;
        this.count = count;
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public Integer getCount() {
        return count;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WarehouseDto that = (WarehouseDto) o;

        if (!Objects.equals(size, that.size)) return false;
        if (!Objects.equals(count, that.count)) return false;
        return Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        int result = size != null ? size.hashCode() : 0;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WarehouseDto{" +
                "size='" + size + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }

}