package com.pluralsight.NorthwindTradersAPI.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("products")
public class Product {
    @Id @Column("ProductID")
    private int productID;
    @Column("CategoryID")
    private int categoryID;
    @Column("ProductName")
    private String name;
    @Column("UnitPrice")
    private double unitPrice;

    public Product() {
        this(0, 0, null, 0);
    }

    public Product(int productID, int categoryID, String name, double unitPrice) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public int getProductID() {
        return productID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
