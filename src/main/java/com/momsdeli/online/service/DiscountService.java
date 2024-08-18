package com.momsdeli.online.service;

import com.momsdeli.online.dto.DiscountDTO;
import com.momsdeli.online.mapper.DiscountMapper;
import com.momsdeli.online.model.Discount;
import com.momsdeli.online.repository.DiscountRepository;
import com.momsdeli.online.request.DiscountRequest;
import com.momsdeli.online.response.DiscountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Autowired
    private DiscountMapper discountMapper;

    public DiscountResponse createDiscount(DiscountRequest request) {
        Discount discount = discountMapper.requestToDiscount(request);
        discount = discountRepository.save(discount);
        return discountMapper.discountToResponse(discount);
    }

    public DiscountResponse updateDiscount(Long id, DiscountRequest request) {
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Discount not found"));
        discountMapper.updateDiscountFromDTO(request, discount);
        discount = discountRepository.save(discount);
        return discountMapper.discountToResponse(discount);
    }

    public void deleteDiscount(Long id) {
        discountRepository.deleteById(id);
    }

    public DiscountResponse getDiscountById(Long id) {
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Discount not found"));
        return discountMapper.discountToResponse(discount);
    }

    public List<DiscountResponse> getAllDiscounts() {
        return discountRepository.findAll().stream()
                .map(discountMapper::discountToResponse)
                .collect(Collectors.toList());
    }

    public DiscountResponse addDiscount(DiscountRequest request) {
        Discount discount = discountMapper.requestToDiscount(request);
        discount = discountRepository.save(discount);
        return discountMapper.discountToResponse(discount);
    }
}
