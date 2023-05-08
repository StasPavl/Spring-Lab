package com.cydeo.lab07ormqueries.entity;

import com.cydeo.lab07ormqueries.enums.DiscountType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal discount;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private String name;

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", discount=" + discount +
                ", discountType=" + discountType +
                ", name='" + name + '\'' +
                ", cartList=" + cartList +
                '}';
    }

    public Discount(BigDecimal discount, DiscountType discountType, String name) {
        this.discount = discount;
        this.discountType = discountType;
        this.name = name;
    }
    @OneToMany(mappedBy = "discount")
    private List<Cart> cartList;
}
