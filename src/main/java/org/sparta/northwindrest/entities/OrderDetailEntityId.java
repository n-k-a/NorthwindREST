package org.sparta.northwindrest.entities;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailEntityId implements Serializable {
    private static final long serialVersionUID = 8006949910203479862L;
    @Column(name = "OrderID", nullable = false)
    private Integer orderID;


    @OneToOne
    @MapsId
    @JoinColumn(name = "ProductID", nullable = false)
    private OrderEntity productID;

    public OrderEntity getProductID() {
        return productID;
    }

    public void setProductID(OrderEntity productID) {
        this.productID = productID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, orderID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderDetailEntityId entity = (OrderDetailEntityId) o;
        return Objects.equals(this.productID, entity.productID) &&
                Objects.equals(this.orderID, entity.orderID);
    }
}