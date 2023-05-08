package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    //Write a derived query to get top 3 product order by price desc
    //Write a derived query to get product by specific name
    //Write a derived query to get product by specific category
    //Write a derived query to get count by price greater than specific amount
    //Write a derived query to get all product by quantity greater than or equal specific count
    //Write a native query to get all product by price greater than specific amount and quantity lower than specific count
    //Write a native query to get all product by specific categoryId
    //Write a native query to get all product by specific categoryId and price greater than specific amount
}
