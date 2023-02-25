package com.cydeo.service;

import com.cydeo.model.Cart;
import com.cydeo.model.Product;
import com.cydeo.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class CartServiceImpl implements CartService{
    private CartRepository cartRepository;
    private StockService service;

    public CartServiceImpl(CartRepository cartRepository, StockService service) {
        this.cartRepository = cartRepository;
        this.service = service;
    }

    public Cart addCart(Product product, int quantity) {
        boolean stockAvailable = service.checkStockIsAvailable(product, quantity);
        Cart cart = new Cart();
        if (!stockAvailable){
           return cart;
        }
        cartRepository.addCartDatabase(product, quantity);
        BigDecimal totalAmount = product.getPrice().multiply(new BigDecimal(quantity));
        Map<Product, Integer> productMap = new HashMap<>();
        productMap.put(product, quantity);
        cart.setCartTotalAmount(totalAmount);
        cart.setProductMap(productMap);
        return cart;

    }
}
