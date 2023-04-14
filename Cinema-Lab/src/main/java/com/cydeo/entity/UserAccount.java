package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String username;

    @OneToMany(mappedBy = "userAccount")
    private List<Ticket> ticketList;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private AccountDetails accountDetails;

    public UserAccount(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;

    }
    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
