package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.enums.PaymentMethod;

import java.util.List;

public interface OrderService {

    List<OrderDTO> retrieveOrderList();

    OrderDTO updateOrder(OrderDTO orderDTO);
    OrderDTO updateOrderById(Long id, OrderDTO orderDTO);

    OrderDTO save(OrderDTO orderDTO);
    List<OrderDTO> retrieveByPayment(PaymentMethod paymentMethod);
    List<OrderDTO> retrieveByEmail(String email);
}
