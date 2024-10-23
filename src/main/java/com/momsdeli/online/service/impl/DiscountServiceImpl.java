package com.momsdeli.online.service.impl;

import com.momsdeli.online.dto.DiscountDTO;
import com.momsdeli.online.mapper.DiscountMapper;
import com.momsdeli.online.model.Discount;
import com.momsdeli.online.repository.DiscountRepository;
import com.momsdeli.online.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;
    private final DiscountMapper discountMapper;

    @Override
    public DiscountDTO createDiscount(DiscountDTO discountDTO) {
        Discount discount = discountMapper.toEntity(discountDTO);
        Discount savedDiscount = discountRepository.save(discount);
        return discountMapper.toDTO(savedDiscount);
    }

    @Override
    public DiscountDTO getDiscountById(Long id) {
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Discount not found")); // Replace with a custom exception
        return discountMapper.toDTO(discount);
    }

    @Override
    public List<DiscountDTO> getAllDiscounts() {
        return discountRepository.findAll().stream()
                .map(discountMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DiscountDTO updateDiscount(Long id, DiscountDTO discountDTO) {
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Discount not found")); // Replace with a custom exception
        // Update fields
        discount.setCode(discountDTO.getCode());
        discount.setPercentage(discountDTO.getPercentage());
        discount.setStartDate(discountDTO.getStartDate());
        discount.setEndDate(discountDTO.getEndDate());
        discount.setActive(discountDTO.isActive());

        Discount updatedDiscount = discountRepository.save(discount);
        return discountMapper.toDTO(updatedDiscount);
    }

    @Override
    public void deleteDiscount(Long id) {
        discountRepository.deleteById(id);
    }
}
