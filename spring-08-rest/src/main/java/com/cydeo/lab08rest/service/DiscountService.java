package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {

    List<DiscountDTO> listOfDiscounts();
    DiscountDTO update(DiscountDTO discountDTO);

    DiscountDTO save(DiscountDTO discountDTO);
    DiscountDTO getDiscountByName(String name);

}
