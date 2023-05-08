package com.cydeo.lab07ormqueries.entity;


import com.cydeo.lab07ormqueries.enums.CartState;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CartState cartState;

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cartState=" + cartState +
                ", cartItemList=" + cartItemList +
                ", discount=" + discount +
                ", order=" + order +
                ", customer=" + customer +
                '}';
    }

    public Cart(CartState cartState) {
        this.cartState = cartState;
    }
    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItemList;

    @ManyToOne
    private Discount discount;

    @OneToOne(mappedBy = "cart")
    private Order order;

    @ManyToOne
    private Customer customer;
}
