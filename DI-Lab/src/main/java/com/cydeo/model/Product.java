package com.cydeo.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class Product {
    private String name;
    private int quantity;
    private int remainingQuantity;
    private BigDecimal price;
}
