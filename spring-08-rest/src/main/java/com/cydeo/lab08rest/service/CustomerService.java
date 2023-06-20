package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.dto.DiscountDTO;

import java.util.List;

public interface CustomerService {
    boolean existById(Long id);
    List<CustomerDTO> listOfCustomers();
    CustomerDTO update(CustomerDTO customerDTO);

    CustomerDTO save(CustomerDTO customerDTO);
    CustomerDTO getCustomerByEmail(String email);
}
