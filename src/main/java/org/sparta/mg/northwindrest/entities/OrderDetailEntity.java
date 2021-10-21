package org.sparta.mg.northwindrest.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "`order details`", indexes = {
        @Index(name = "ProductID", columnList = "ProductID"),
        @Index(name = "OrderID", columnList = "OrderID")
})
@Entity
public class OrderDetailEntity {
    @EmbeddedId
    private OrderDetailEntityId id;

    @Column(name = "UnitPrice", nullable = false, precision = 19, scale = 4)
    private BigDecimal unitPrice;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Discount", nullable = false)
    private Double discount;

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderDetailEntityId getId() {
        return id;
    }

    public void setId(OrderDetailEntityId id) {
        this.id = id;
    }
}