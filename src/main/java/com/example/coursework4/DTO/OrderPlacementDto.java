package com.example.coursework4.DTO;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class OrderPlacementDto implements Serializable {
    private String firstName;
    private String secondName;
    private String middleName;
    private String phoneNumber;
    private Boolean isNeedCall;
    private Boolean homeDelivery;
    private String deliveryCompany;
    private String email;
    private String address;
    private String note;

    private List<ProductInOrder> productInOrderList;

    public static class ProductInOrder implements Serializable {
        private final Integer id;
        private final String size;
        private final Integer quantity;

        public ProductInOrder(String size, Integer quantity, Integer id) {
            this.size = size;
            this.quantity = quantity;
            this.id = id;
        }

        public String getSize() {
            return size;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ProductInOrder entity = (ProductInOrder) o;
            return Objects.equals(this.size, entity.size) &&
                    Objects.equals(this.quantity, entity.quantity) &&
                    Objects.equals(this.id, entity.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, size, quantity);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "id = " + id + ", " +
                    "size = " + size + ", " +
                    "quantity = " + quantity + ")";
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setNeedCall(Boolean needCall) {
        isNeedCall = needCall;
    }

    public void setHomeDelivery(Boolean homeDelivery) {
        this.homeDelivery = homeDelivery;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setProductInOrderList(List<ProductInOrder> productInOrderList) {
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