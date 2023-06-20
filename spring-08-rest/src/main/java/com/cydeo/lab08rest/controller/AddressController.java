package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getListOfAddress() {
        return ResponseEntity.ok(new ResponseWrapper("List Retrieved", addressService.getListOfAddress(), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateAddress(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(new ResponseWrapper("List Retrieved", addressService.update(addressDTO), HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createAddress(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(new ResponseWrapper("List Retrieved", addressService.save(addressDTO), HttpStatus.OK));
    }

    @GetMapping("/startsWith/{address}")
    public ResponseEntity<ResponseWrapper> getAddressStartWith(@PathVariable String address) {
        return ResponseEntity.ok(new ResponseWrapper("List Retrieved", addressService.getAddressStartWith(address), HttpStatus.OK));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<ResponseWrapper> getAddressByCustomerId(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseWrapper("List Retrieved", addressService.getAddressByCustomerId(id), HttpStatus.OK));
    }
    @GetMapping("/customer/{customerId}/name/{name}")
    public ResponseEntity<ResponseWrapper> getAddressByCustomerIdAndStreetName(@PathVariable Long customerId, @PathVariable String name){
        return ResponseEntity.ok(new ResponseWrapper("Address retrieved", addressService.getAddressByIdAndByName(customerId,name), HttpStatus.OK));
    }
}
