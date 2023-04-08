package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    public CartItem(Integer quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    private Product product;
    @ManyToOne
    private Cart cart;
}
