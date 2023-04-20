package com.cydeo.repository;


import com.cydeo.entity.AccountDetails;
import com.cydeo.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountDetails, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<AccountDetails> findByCountryOrState(String pattern);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<AccountDetails> findByAgeLessThanEqual(int age);

    //Write a derived query to list all accounts with a specific role
    List<AccountDetails> findByRole(String role);


    //Write a derived query to list all accounts between a range of ages
    List<AccountDetails> findByAgeBetween(int ageStart,int ageEnd);


    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<AccountDetails> findByAddressStartingWith(String pattern);

    //Write a derived query to sort the list of accounts with age

    List<AccountDetails> findAllByAgeOrderByAgeDesc();

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("select a from AccountDetails a")
    List<AccountDetails> retrieveAccounts();


    //Write a JPQL query to list all admin accounts
    @Query("select a from AccountDetails a where a.role='ADMIN' ")
    List<AccountDetails> retrieveAllAdminAccounts();


    //Write a JPQL query to sort all accounts with age
    @Query("select a from AccountDetails a order by a.age")
    List<AccountDetails> sortAccountsByAge();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "select * from account_details a where age < ?1",nativeQuery = true)
    List<AccountDetails> retrieveAllAccWithLowerAgeThan(@Param("age")int age);


    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "select * from account_details where name = ?1 and address = ?2 and country = ?3 and state = ?4 and city = ?5", nativeQuery = true)
    List<AccountDetails> retrieveAllAccWithSpecificValue(@Param("name")String name,
                                                         @Param("address")String address,
                                                         @Param("country")String country,
                                                         @Param("state")String state,
                                                         @Param("city")String city);


    //Write a native query to read all accounts with an age higher than a specific value
    @Query(value = "select * from account_details a where age > :age",nativeQuery = true)
    List<AccountDetails> retrieveAllAccWithHigherAgeThan(@Param("age")int age);

}
