package com.cydeo.entity;

import com.cydeo.enums.CartState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CartState cartState;

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
