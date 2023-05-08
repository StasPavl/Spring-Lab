package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Address;
import com.cydeo.lab07ormqueries.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    //Write a derived query to get all address with a specific customer
    List<Address> findAllByCustomer(Customer customer);
    //Write a derived query to get address with a specific street
    List<Address> findAllByStreet(String street);
    //Write a derived query to get top 3 address with a specific customer email
    List<Address> findTop3ByCustomer_Email(String email);
    //Write a derived query to get all address with a specific customer and name
    //------List<Address> findAllByCustomer
    //Write a derived query to list all address where the beginning of the street contains the keyword
    List<Address> findAllByStreetStartingWith(String pattern);
    //Write a JPQL query to get all address with a specific customerId
    @Query("select a from Address a where a.customer.id= ?1")
    List<Address> retrieveAllAddressesByCustomerId(Long id);
}
