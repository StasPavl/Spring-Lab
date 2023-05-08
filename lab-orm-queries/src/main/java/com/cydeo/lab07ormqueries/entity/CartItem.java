package com.cydeo.lab07ormqueries.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                ", cart=" + cart +
                '}';
    }

    public CartItem(Integer quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    private Product product;
    @ManyToOne
    private Cart cart;
}
