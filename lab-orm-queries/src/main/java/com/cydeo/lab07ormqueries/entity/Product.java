package com.cydeo.lab07ormqueries.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;
    private Integer quantity;
    private Integer remainingQuantity;

    public Product(String name, BigDecimal price, Integer quantity, Integer remainingQuantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.remainingQuantity = remainingQuantity;
    }

    @ManyToMany
    @JoinTable(
            name = "product_category_rel",
            joinColumns = @JoinColumn(name = "p_id"),
            inverseJoinColumns = @JoinColumn(name = "c_id")
    )
    private List<Category> categoryList;

    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItemList;
}
