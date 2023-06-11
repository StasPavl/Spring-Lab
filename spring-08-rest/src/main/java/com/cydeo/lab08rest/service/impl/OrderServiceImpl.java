package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.entity.Order;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.OrderRepository;
import com.cydeo.lab08rest.service.CartService;
import com.cydeo.lab08rest.service.CustomerService;
import com.cydeo.lab08rest.service.OrderService;
import com.cydeo.lab08rest.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final PaymentService paymentService;
    private final CartService cartService;
    private final MapperUtil mapperUtil;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerService customerService, PaymentService paymentService, CartService cartService, MapperUtil mapperUtil) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.paymentService = paymentService;
        this.cartService = cartService;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<OrderDTO> retrieveOrderList() {
        return orderRepository.findAll().stream()
                .map(order -> mapperUtil.convert(order, new OrderDTO())).collect(Collectors.toList());
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        //look for the orderId inside the database and throw the exception

        Order orderById = orderRepository.findById(orderDTO.getId()).orElseThrow(() -> new RuntimeException("Order could not be found"));

        //then we need to check if order field exist or not

        validateRelatedFieldsAreExist(orderDTO);

        //if fields are exist then convert ORderDTo to order and save it
        Order willBeUpdatedOrder = mapperUtil.convert(orderDTO, new Order());
        Order updatedOrder = orderRepository.save(willBeUpdatedOrder);


        return mapperUtil.convert(updatedOrder, new OrderDTO());
    }

    @Override
    public OrderDTO updateOrderById(Long id,OrderDTO orderDTO) {
        Order orderById = orderRepository.findById(orderDTO.getId()).orElseThrow(
                () -> new RuntimeException("Order could not be found"));
        //if we are getting same value its not necessary to pdate the actual value

        boolean changeDetected = false;
        if (!orderById.getPaidPrice().equals(orderDTO.getPaidPrice())){
            orderById.setPaidPrice(orderDTO.getPaidPrice());
            changeDetected = true;
        }
        if (!orderById.getTotalPrice().equals(orderDTO.getTotalPrice())){
            orderById.setTotalPrice(orderDTO.getTotalPrice());
            changeDetected =true;
        }

        //if there any change, update the order and return it
        if (changeDetected){
            Order order = orderRepository.save(orderById);
            return mapperUtil.convert(order,new OrderDTO());
        }else{
           throw new RuntimeException("no changes detected");
        }

    }

    private void validateRelatedFieldsAreExist(OrderDTO orderDTO){
        //in this method we have 3 different service anf make sure they have those fields
        //we will create service and existById method and verify
        if (!customerService.existById(orderDTO.getCustomerId())) {
            throw new RuntimeException("Customer could not be found");
        }
        if (!paymentService.existById(orderDTO.getPaymentId())) {
            throw new RuntimeException("Payment could not be found");
        }
        if (!cartService.existById(orderDTO.getCartId())) {
            throw new RuntimeException("Cart could not be found");
        }
    }
}
