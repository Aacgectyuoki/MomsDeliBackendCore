package com.momsdeli.online.controller;

import com.momsdeli.online.request.DiscountRequest;
import com.momsdeli.online.response.DiscountResponse;
import com.momsdeli.online.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @PostMapping
    public DiscountResponse addDiscount(@RequestBody DiscountRequest request) {
        return discountService.addDiscount(request);
    }

    @PutMapping("/{id}")
    public DiscountResponse updateDiscount(@PathVariable Long id, @RequestBody DiscountRequest request) {
        return discountService.updateDiscount(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteDiscount(@PathVariable Long id) {
        discountService.deleteDiscount(id);
    }

    @GetMapping("/{id}")
    public DiscountResponse getDiscount(@PathVariable Long id) {
        return discountService.getDiscountById(id);
    }

    @GetMapping
    public List<DiscountResponse> getAllDiscounts() {
        return discountService.getAllDiscounts();
    }
}
