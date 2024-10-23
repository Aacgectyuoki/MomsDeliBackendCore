package com.momsdeli.online.service;

import com.momsdeli.online.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {

    DiscountDTO createDiscount(DiscountDTO discountDTO);

    DiscountDTO getDiscountById(Long id);

    List<DiscountDTO> getAllDiscounts();

    DiscountDTO updateDiscount(Long id, DiscountDTO discountDTO);

    void deleteDiscount(Long id);
}
