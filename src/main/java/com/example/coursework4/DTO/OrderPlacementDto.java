package com.example.coursework4.DTO;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class OrderPlacementDto implements Serializable {
    private final String firstName;
    private final String secondName;
    private final String middleName;
    private final String phoneNumber;
    private final Boolean isNeedCall;
    private final Boolean homeDelivery;
    private final String deliveryCompany;
    private final String email;
    private final String address;
    private final String note;

    private final List<ProductInOrder> productInOrderList;

    public class ProductInOrder{
        private final Integer id;
        private final String size;
        private final Integer quantity;

        public ProductInOrder(Integer id, String size, Integer quantity) {
            this.id = id;
            this.size = size;
            this.quantity = quantity;
        }

        public Integer getId() {
            return id;
        }

        public String getSize() {
            return size;
        }

        public Integer getQuantity() {
            return quantity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ProductInOrder that = (ProductInOrder) o;

            if (!Objects.equals(id, that.id)) return false;
            if (!Objects.equals(size, that.size)) return false;
            return Objects.equals(quantity, that.quantity);
        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (size != null ? size.hashCode() : 0);
            result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
            return result;
        }
    }

    public OrderPlacementDto(String firstName, String secondName, String middleName, String phoneNumber, Boolean isNeedCall, Boolean homeDelivery, String deliveryCompany, String email, String address, String note, List<ProductInOrder> productInOrderList) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.isNeedCall = isNeedCall;
        this.homeDelivery = homeDelivery;
        this.deliveryCompany = deliveryCompany;
        this.email = email;
        this.address = address;
        this.note = note;
        this.productInOrderList = productInOrderList;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Boolean getNeedCall() {
        return isNeedCall;
    }

    public Boolean getHomeDelivery() {
        return homeDelivery;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getNote() {
        return note;
    }

    public List<ProductInOrder> getProductInOrderList() {
        return productInOrderList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderPlacementDto that = (OrderPlacementDto) o;

        if (!Objects.equals(firstName, that.firstName)) return false;
        if (!Objects.equals(secondName, that.secondName)) return false;
        if (!Objects.equals(middleName, that.middleName)) return false;
        if (!Objects.equals(phoneNumber, that.phoneNumber)) return false;
        if (!Objects.equals(isNeedCall, that.isNeedCall)) return false;
        if (!Objects.equals(homeDelivery, that.homeDelivery)) return false;
        if (!Objects.equals(deliveryCompany, that.deliveryCompany))
            return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(address, that.address)) return false;
        if (!Objects.equals(note, that.note)) return false;
        return Objects.equals(productInOrderList, that.productInOrderList);
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (isNeedCall != null ? isNeedCall.hashCode() : 0);
        result = 31 * result + (homeDelivery != null ? homeDelivery.hashCode() : 0);
        result = 31 * result + (deliveryCompany != null ? deliveryCompany.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (productInOrderList != null ? productInOrderList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderPlacementDto{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isNeedCall=" + isNeedCall +
                ", homeDelivery=" + homeDelivery +
                ", deliveryCompany='" + deliveryCompany + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", note='" + note + '\'' +
                ", productInOrderList=" + productInOrderList +
                '}';
    }
}