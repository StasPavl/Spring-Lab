package com.cydeo;

import com.cydeo.config.ConfigApp;
import com.cydeo.model.Product;
import com.cydeo.repository.CartRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith( SpringRunner.class )
@ContextConfiguration(classes = ConfigApp.class)
public class CartRepositoryTest {

    @Autowired
    private CartRepositoryImpl cartRepository;

    @Test
    public void shouldAddDatabase(){
        Product product = new Product();
        product.setName("milk");
        product.setPrice(new BigDecimal(12));
        product.setQuantity(3);
        product.setRemainingQuantity(3);

        Assert.assertTrue(cartRepository.addCartDatabase(product, 2));
    }

}
