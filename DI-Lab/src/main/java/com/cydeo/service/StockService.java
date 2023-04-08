package com.cydeo.service;

import com.cydeo.model.Product;
import org.springframework.stereotype.Component;


public interface StockService {
    boolean checkStockIsAvailable(Product product, int quantity);
}
