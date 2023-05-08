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
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @Override
    public String toString() {
        return "Balance{" +
                "id=" + id +
                ", amount=" + amount +
                ", customer=" + customer +
                '}';
    }

    public Balance(BigDecimal amount) {
        this.amount = amount;
    }

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Customer customer;
}
