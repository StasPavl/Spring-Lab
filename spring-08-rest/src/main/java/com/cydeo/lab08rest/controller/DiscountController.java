package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.DiscountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllDiscounts(){
        return ResponseEntity.ok(new ResponseWrapper("All Discounts retrieved", discountService.listOfDiscounts(), HttpStatus.OK));
    }
    @PutMapping
    public ResponseEntity<ResponseWrapper> updateDiscount(@RequestBody DiscountDTO discountDTO){
        return ResponseEntity.ok(new ResponseWrapper("Discount updated", discountService.update(discountDTO), HttpStatus.OK));
    }
    @PostMapping
    public ResponseEntity<ResponseWrapper> createDiscount(@RequestBody DiscountDTO discountDTO){
        return ResponseEntity.ok(new ResponseWrapper("Discount created", discountService.save(discountDTO), HttpStatus.OK));
    }
    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getByName(@PathVariable String name){
        return ResponseEntity.ok(new ResponseWrapper("Discount found",discountService.getDiscountByName(name),HttpStatus.OK));
    }
}
