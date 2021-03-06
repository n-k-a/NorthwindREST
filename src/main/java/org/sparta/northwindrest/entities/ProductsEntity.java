package org.sparta.northwindrest.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "northwind")
public class ProductsEntity {
    private Integer productId;
    private String productName;
    private SupplierEntity supplierId;
    private CategoryEntity categoryId;
    private String quantityPerUnit;
    private BigDecimal unitPrice;
    private Integer unitsInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;
    private Byte discontinued;

    @Id
    @Column(name = "ProductID")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "ProductName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    @Access(AccessType.PROPERTY)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "SupplierID")
    public SupplierEntity getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(SupplierEntity supplierId) {
        this.supplierId = supplierId;
    }

    @Access(AccessType.PROPERTY)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "CategoryID")
    public CategoryEntity getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryEntity categoryId) {
        this.categoryId = categoryId;
    }
    @Basic
    @Column(name = "QuantityPerUnit")
    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    @Basic
    @Column(name = "UnitPrice")
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "UnitsInStock")
    public Integer getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Integer unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    @Basic
    @Column(name = "UnitsOnOrder")
    public Integer getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(Integer unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    @Basic
    @Column(name = "ReorderLevel")
    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    @Basic
    @Column(name = "Discontinued")
    public Byte getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Byte discontinued) {
        this.discontinued = discontinued;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsEntity that = (ProductsEntity) o;
        return Objects.equals(productId, that.productId) && Objects.equals(productName, that.productName) && Objects.equals(supplierId, that.supplierId) && Objects.equals(categoryId, that.categoryId) && Objects.equals(quantityPerUnit, that.quantityPerUnit) && Objects.equals(unitPrice, that.unitPrice) && Objects.equals(unitsInStock, that.unitsInStock) && Objects.equals(unitsOnOrder, that.unitsOnOrder) && Objects.equals(reorderLevel, that.reorderLevel) && Objects.equals(discontinued, that.discontinued);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, supplierId, categoryId, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued);
    }
}
