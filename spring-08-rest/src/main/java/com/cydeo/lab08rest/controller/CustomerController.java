package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCustomers(){
        return ResponseEntity.ok(new ResponseWrapper("All Discounts retrieved", customerService.listOfCustomers(), HttpStatus.OK));
    }
    @PutMapping
    public ResponseEntity<ResponseWrapper> updateCustomer(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.ok(new ResponseWrapper("Discount updated", customerService.update(customerDTO), HttpStatus.OK));
    }
    @PostMapping
    public ResponseEntity<ResponseWrapper> createCustomer(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.ok(new ResponseWrapper("Discount created", customerService.save(customerDTO), HttpStatus.OK));
    }
    @GetMapping("/{email}")
    public ResponseEntity<ResponseWrapper> getCustomerByEmail(@PathVariable String email){
        return ResponseEntity.ok(new ResponseWrapper("Discount found",customerService.getCustomerByEmail(email),HttpStatus.OK));
    }
}
