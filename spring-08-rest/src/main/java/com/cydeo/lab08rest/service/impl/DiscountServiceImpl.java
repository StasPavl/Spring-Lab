package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.entity.Discount;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.DiscountRepository;
import com.cydeo.lab08rest.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;
    private final MapperUtil mapperUtil;

    public DiscountServiceImpl(DiscountRepository discountRepository, MapperUtil mapperUtil) {
        this.discountRepository = discountRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<DiscountDTO> listOfDiscounts() {
        List<Discount> listOfDiscounts = discountRepository.findAll();
        return listOfDiscounts.stream().map(discount -> mapperUtil.convert(discount,new DiscountDTO())).collect(Collectors.toList());
    }

    @Override
    public DiscountDTO save(DiscountDTO discountDTO) {
        Discount discount = discountRepository.save(mapperUtil.convert(discountDTO, new Discount()));
        return mapperUtil.convert(discount, new DiscountDTO());
    }

    @Override
    public DiscountDTO update(DiscountDTO discountDTO) {
        Discount discount = discountRepository.findById(discountDTO.getId()).orElseThrow(() -> new RuntimeException("No such discount"));
        Discount savedDiscount = discountRepository.save(discount);

        return mapperUtil.convert(savedDiscount, new DiscountDTO());
    }

    @Override
    public DiscountDTO getDiscountByName(String name) {
        Discount discount = discountRepository.findFirstByName(name);
        return mapperUtil.convert(discount, new DiscountDTO());
    }
}
