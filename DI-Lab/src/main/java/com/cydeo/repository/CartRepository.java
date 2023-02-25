package com.cydeo.repository;

import com.cydeo.model.Product;
import org.springframework.stereotype.Component;

@Component
public interface CartRepository {
    boolean addCartDatabase(Product product, int quantity);
}
