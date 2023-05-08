package com.cydeo.lab07ormqueries.entity;

import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String street;
    private String zipCode;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", customer=" + customer +
                '}';
    }

    @ManyToOne
    private Customer customer;
}
