package com.cydeo.lab07ormqueries.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String firstName;
    private String lastName;
    private String userName;

    public Customer(String email, String firstName, String lastName, String userName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
//                ", cartList=" + cartList +
//                ", orderList=" + orderList +
//                ", balance=" + balance +
//                ", addressList=" + addressList +
                '}';
    }

    @OneToMany(mappedBy = "customer")
    private List<Cart> cartList;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderList;

    @OneToOne(mappedBy = "customer")
    private Balance balance;

    @OneToMany(mappedBy = "customer")
    private List<Address> addressList;
}
