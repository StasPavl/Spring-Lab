package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    //Write a derived query to get top 5 orders by order by total price desc
    //Write a derived query to get all orders by customer email
    //Write a derived query to get all orders by specific payment method
    //Write a derived query to get all orders by specific payment method
    //Write a derived query to get all orders by specific customer email
    //Write a derived query to check is there any orders by customer email
    //Write a native query to get all orders by specific product name
    //Write a native query to get all orders by specific categoryId
    //Write a derived query to get all orders by totalPrice and paidPrice are equals
    //Write a derived query to get all orders by totalPrice and paidPrice are not equals and discount is not null

}
