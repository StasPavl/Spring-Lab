package com.cydeo.lab08rest.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
public class UpdateOrderDTO {

    // only updatable fields should be exist in DTO

    @NotNull(message = "price can not be null")
    @Positive(message = "price shouldn't be negative")
    @DecimalMax(value = "100000",message = "price can not be greater than 1000000")
    @DecimalMin(value = "0.1", message = "price can not be less than 0.1")
    private BigDecimal paidPrice;

    @NotNull(message = "totalPrice can not be null")
    @Positive(message = "totalPrice shouldn't be negative")
    @DecimalMax(value = "100000",message = "totalPrice can not be greater than 1000000")
    @DecimalMin(value = "0.1", message = "totalPrice can not be less than 0.1")
    private BigDecimal totalPrice;

}