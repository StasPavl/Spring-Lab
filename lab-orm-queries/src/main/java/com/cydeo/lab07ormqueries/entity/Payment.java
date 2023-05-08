package com.cydeo.lab07ormqueries.entity;

import com.cydeo.lab07ormqueries.enums.PaymentMethod;
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
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal paidPrice;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paidPrice=" + paidPrice +
                ", paymentMethod=" + paymentMethod +
                ", order=" + order +
                '}';
    }

    public Payment(BigDecimal paidPrice, PaymentMethod paymentMethod) {
        this.paidPrice = paidPrice;
        this.paymentMethod = paymentMethod;
    }

    @OneToOne(mappedBy = "payment")
    private Order order;
}
