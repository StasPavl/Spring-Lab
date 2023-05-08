package com.cydeo.lab07ormqueries.repository;
import com.cydeo.lab07ormqueries.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    //Write a derived query to get all cart by specific discount type
    //Write a JPQL query to get all cart by customer
    //Write a derived query to get all cart by customer and cart state
    //Write a derived query to get all cart by customer and cart state and discount is null condition
    //Write a native query to get all cart by customer and cart state and discount is not null condition
}
