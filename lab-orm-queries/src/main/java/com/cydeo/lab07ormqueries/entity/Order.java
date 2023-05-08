package com.cydeo.lab07ormqueries.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal paidPrice;
    private BigDecimal totalPrice;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", paidPrice=" + paidPrice +
                ", totalPrice=" + totalPrice +
                ", cart=" + cart +
                ", payment=" + payment +
                ", customer=" + customer +
                '}';
    }

    public Order(BigDecimal paidPrice, BigDecimal totalPrice) {
        this.paidPrice = paidPrice;
        this.totalPrice = totalPrice;
    }

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Cart cart;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Payment payment;

    @ManyToOne
    private Customer customer;
}
