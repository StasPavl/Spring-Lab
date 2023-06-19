package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.CartService;
import com.cydeo.lab08rest.service.CustomerService;
import com.cydeo.lab08rest.service.OrderService;
import com.cydeo.lab08rest.service.PaymentService;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;


    public OrderController(OrderService orderService, CustomerService customerService, CartService cartService, PaymentService paymentService) {
        this.orderService = orderService;

    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> retrieveOrderList(){
        return ResponseEntity.ok(new ResponseWrapper("Order LIst retrieved succses", orderService.retrieveOrderList(), HttpStatus.OK));
    }
    @PutMapping
    public ResponseEntity<ResponseWrapper> updateOrder(@RequestBody OrderDTO orderDto){
        return ResponseEntity.ok(new ResponseWrapper("Order is updated", orderService.updateOrder(orderDto), HttpStatus.OK));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseWrapper> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDto){
        return ResponseEntity.ok(new ResponseWrapper("Order is updated", orderService.updateOrderById(id,orderDto), HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(new ResponseWrapper("Order created", orderService.save(orderDTO), HttpStatus.OK));
    }

    @GetMapping("/paymentMethod/{paymentMethod}")
    public ResponseEntity<ResponseWrapper> getOrdersByPaymentMethod(@PathVariable PaymentMethod paymentMethod){
        return ResponseEntity.ok(new ResponseWrapper("Orders retrieved", orderService.retrieveByPayment(paymentMethod), HttpStatus.OK));

    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseWrapper> getOrdersByEmail(@PathVariable String email){
        return ResponseEntity.ok(new ResponseWrapper("Orders retrieved", orderService.retrieveByEmail(email),HttpStatus.OK));
    }
}
