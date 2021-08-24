package com.preet.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "product")
@Table(name = "PRODUCT_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private int pid;
    private String productName;
    private int quantity;
    private long price;

    public Product(String productName, int quantity, long price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}
