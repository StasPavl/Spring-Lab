package com.cydeo.lab07ormqueries.entity;

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
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productList=" + productList +
                '}';
    }

    public Category(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "categoryList")
    private List<Product> productList;
}
